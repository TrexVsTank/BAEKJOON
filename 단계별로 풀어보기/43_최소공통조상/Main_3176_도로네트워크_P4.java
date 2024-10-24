import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// [CLASS]
public class Main_3176_도로네트워크_P4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int[] depthArray;
	static boolean[] visited;
	static List<int[]>[] link;
	static int K;
	static Info[][] sparseTable;
	static int M;
	
	// [MAIN]
	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(br.readLine());
		
		depthArray = new int[N+1];
		
		visited = new boolean[N+1];
		
		link = new List[N+1];
		for (int n = 1; n <= N; n++) {
			link[n] = new ArrayList<>();
		}
		for (int n = 0; n < N-1; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cityA = Integer.parseInt(st.nextToken());
			int cityB = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			link[cityA].add(new int[] {cityB, dist});
			link[cityB].add(new int[] {cityA, dist});
		}
		
		K = 1;
		while (N-1 > Math.pow(2, K)) {
			K++;
		}
		
		sparseTable = new Info[K+1][N+1];
		for (int k = 0; k <= K; k++) {
			for (int n = 0; n <= N; n++) {
				sparseTable[k][n] = new Info(0, 1_000_000, 0);
			}
		}
		
		bfs();
		
		for (int k = 1; k <= K; k++) {
			for (int n = 2; n <= N; n++) {
				int par = sparseTable[k-1][n].parent;
				int min = Math.min(sparseTable[k-1][n].minimum, sparseTable[k-1][par].minimum);
				int max = Math.max(sparseTable[k-1][n].maximum, sparseTable[k-1][par].maximum);
				par = sparseTable[k-1][par].parent;
				sparseTable[k][n] = new Info(par, min, max);
			}
		}
		
		M = Integer.parseInt(br.readLine());
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int[] mm = minAndMax(a, b);
			sb.append(mm[0]).append(" ").append(mm[1]).append("\n");
		}
		
		System.out.println(sb);
		
	} // [MAIN]
	
	// [INFORMATION]
	private static class Info {
		int parent;
		int minimum;
		int maximum;
		public Info(int parent, int minimum, int maximum) {
			this.parent = parent;
			this.minimum = minimum;
			this.maximum = maximum;
		}
	} // [INFORMATION]
	
	// [BFS]
	private static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		while (!queue.isEmpty()) {
			int parent = queue.poll();
			visited[parent] = true;
			for (int[] i : link[parent]) {
				int child = i[0];
				if (!visited[child]) {
					int dist = i[1];
					depthArray[child] = depthArray[parent] + 1;
					sparseTable[0][child] = new Info(parent, dist, dist);
					queue.offer(child);
				}
			}
		}
	} // [BFS]
	
	// [MIN AND MAX]
	private static int[] minAndMax(int a, int b) {
		int A = a;
		int B = b;
		int min = 1_000_000;
		int max = 0;
		if (depthArray[A] > depthArray[B]) {
			int temp = A;
			A = B;
			B = temp;
		}
		for (int k = K; k >= 0; k--) {
			if (depthArray[A] + Math.pow(2, k) <= depthArray[B]) {
				min = Math.min(min, sparseTable[k][B].minimum);
				max = Math.max(max, sparseTable[k][B].maximum);
				B = sparseTable[k][B].parent;
			}
		}
		for (int k = K; k >= 0; k--) {
			if (sparseTable[k][A].parent != sparseTable[k][B].parent) {
				min = Math.min(min, sparseTable[k][A].minimum);
				min = Math.min(min, sparseTable[k][B].minimum);
				max = Math.max(max, sparseTable[k][A].maximum);
				max = Math.max(max, sparseTable[k][B].maximum);
				A = sparseTable[k][A].parent;
				B = sparseTable[k][B].parent;
			}
		}
		while (A != B) {
			min = Math.min(min, sparseTable[0][A].minimum);
			min = Math.min(min, sparseTable[0][B].minimum);
			max = Math.max(max, sparseTable[0][A].maximum);
			max = Math.max(max, sparseTable[0][B].maximum);
			A = sparseTable[0][A].parent;
			B = sparseTable[0][B].parent;
		}
//		System.out.println(A + " | " + B);
		return new int[] {min, max};
	} // [MIN AND MAX]
	
} // [CLASS]
