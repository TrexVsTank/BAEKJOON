import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// [CLASS]
public class Main_13511_트리와쿼리2_P3 {
	
	// [information]
	private static class Info {
		int parent;
		long distance;
		public Info(int parent, long distance) {
			this.parent = parent;
			this.distance = distance;
		}
	} // [information]
	
	// [MAIN]
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int M;
	static int K;
	static int[] depthArray;
	static Info[][] sparseTable;
	
	static int a;
	static int b;
	static int c;
	
	public static void main(String[] args) throws IOException {
		
		init();
		
		BFS();
		
		completeSparseTable();
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			String order = st.nextToken();
			switch (order) {
			case "1":
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				sb.append(getDistance(a, b)).append("\n");
				break;
			case "2":
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				sb.append(getPath(a, b, c)).append("\n");
				break;
			}
		}
		
		System.out.println(sb);
		
	} // [MAIN]
	
	// [INITIALIZATION]
	static List<int[]>[] link;
	static boolean[] visited;
	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		while (N > Math.pow(2, K)) {
			K++;
		}
//		K = 21;
		sparseTable = new Info[K+1][N+1];
		for (int k = 0; k <= K; k++) {
			for (int n = 0; n <= N; n++) {
				sparseTable[k][n] = new Info(0, 0);
			}
		}
		depthArray = new int[N+1];
		depthArray[0] = -1;
		link = new List[N+1];
		for (int n = 1; n <= N; n++) {
			link[n] = new ArrayList<>();
		}
		for (int n = 0; n < N-1; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			link[a].add(new int[] {b, distance});
			link[b].add(new int[] {a, distance});
		}
		visited = new boolean[N+1];
		M = Integer.parseInt(br.readLine());
	} // [INITIALIZATION]
	
	// [BREADTH FIRST SEARCH]
	private static void BFS() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		while (!queue.isEmpty()) {
			int parent = queue.poll();
			visited[parent] = true;
			for (int[] i : link[parent]) {
				int child = i[0];
				if (!visited[child]) {
					int distance = i[1];
					depthArray[child] = depthArray[parent] + 1;
					sparseTable[0][child] = new Info(parent, distance);
					queue.offer(child);
				}
			}
		}
	} // [BREADTH FIRST SEARCH]
	
	// [COMPLETE SPARSE TABLE]
	private static void completeSparseTable() {
		for (int k = 1; k < K; k++) {
			for (int n = 1; n <= N; n++) {
				int par = sparseTable[k-1][n].parent;
				long dist = sparseTable[k-1][n].distance;
				dist += sparseTable[k-1][par].distance;
				par = sparseTable[k-1][par].parent;
				sparseTable[k][n] = new Info(par, dist);
			}
		}
	} // [COMPLETE SPARSE TABLE]
	
	// [GET Lowest Common Ancestor]
	static long distA;
	static long distB;
	static int pathA;
	static int pathB;
	static int A;
	static int B;
	static int lca;
	private static void LCA(int a, int b) {
		A = a;
		B = b;
		distA = 0;
		distB = 0;
		pathA = 0;
		pathB = 0;
		if (depthArray[A] > depthArray[B]) {
			for (int k = K; k >= 0; k--) {
				if (depthArray[B] + Math.pow(2, k) <= depthArray[A]) {
					distA += sparseTable[k][A].distance;
					pathA += Math.pow(2, k);
					A = sparseTable[k][A].parent;
				}
			}
		} else {
			for (int k = K; k >= 0; k--) {
				if (depthArray[A] + Math.pow(2, k) <= depthArray[B]) {
					distB += sparseTable[k][B].distance;
					pathB += Math.pow(2, k);
					B = sparseTable[k][B].parent;
				}
			}
		}
		for (int k = K; k >= 0; k--) {
			if (sparseTable[k][A].parent != sparseTable[k][B].parent) {
				distA += sparseTable[k][A].distance;
				distB += sparseTable[k][B].distance;
				pathA += Math.pow(2, k);
				pathB += Math.pow(2, k);
				A = sparseTable[k][A].parent;
				B = sparseTable[k][B].parent;
			}
		}
		while (A != B) {
			distA += sparseTable[0][A].distance;
			distB += sparseTable[0][B].distance;
			pathA ++;
			pathB ++;
			A = sparseTable[0][A].parent;
			B = sparseTable[0][B].parent;
		}
		lca = A;
	} // [GET Lowest Common Ancestor]
	
	// [GET DISTANCE]
	private static long getDistance(int a, int b) {
		LCA(a, b);
		return distA + distB;
	} // [GET DISTANCE]
	
	// [GET PATH]
	private static int getPath(int a, int b, int c) {
		if (c <= 1) {
			return a;
		}
		LCA(a, b);
		int A = a;
		int B = b;
		int C = c - 1;
		for (int k = K; k >= 0; k--) {
			if (C >= Math.pow(2, k) && pathA >= Math.pow(2, k)) {
				A = sparseTable[k][A].parent;
				C -= Math.pow(2, k);
				pathA -= Math.pow(2, k);
			}
		}
		if (C == 0) {
			return A;
		}
		C = pathB - C;
		for (int k = K; k >= 0; k--) {
			if (C >= Math.pow(2, k)) {
				B = sparseTable[k][B].parent;
				C -= Math.pow(2, k);
			}
		}
		return B;
	} // [GET PATH]
	
} // [CLASS]
