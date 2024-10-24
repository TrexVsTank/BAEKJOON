import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// [CLASS]
public class Main_11438_LCA2_P5 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int M;
	static int K;
	static int[] deapthArray;
	static boolean visited[];
	static List<Integer>[] link;
	static int[][] sparceTable;
	
	// [MAIN]
	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine());
		
		link = new List[N+1];
		for (int n = 0; n <= N; n++) {
			link[n] = new ArrayList<>();
		}
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			link[A].add(B);
			link[B].add(A);
		}
		
		deapthArray = new int[N+1];
		
		K = 1;
		while (N-1 > Math.pow(2, K)) {
			K++;
		}
		sparceTable = new int[K+1][N+1];
		
		visited = new boolean[N+1];
		
		Queue<Integer> queue = new ArrayDeque<>();
		
		queue.offer(1);
		
		while (!queue.isEmpty()) {
			int parent = queue.poll();
			visited[parent] = true;
			for (int child : link[parent]) {
				if (!visited[child]) {
					deapthArray[child] = deapthArray[parent] + 1;
					sparceTable[0][child] = parent;
					queue.offer(child);
				}
			}
		}
		
		for (int k = 1; k <= K; k++) {
			for (int n = 1; n <= N; n++) {
				sparceTable[k][n] = sparceTable[k-1][sparceTable[k-1][n]];
			}
		}
		
		M = Integer.parseInt(br.readLine());
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			sb.append(LCA(A, B)).append("\n");
		}
		
		System.out.println(sb);
		
	} // [MAIN]
	
	// [Lowest Common Ancestor]
	private static int LCA(int a, int b) {
		int A = a;
		int B = b;
		if (deapthArray[A] > deapthArray[B]) {
			int temp = A;
			A = B;
			B = temp;
		}
		for (int k = K; k >= 0; k--) {
			if (deapthArray[A] + Math.pow(2, k) <= deapthArray[B]) {
				B = sparceTable[k][B];
			}
		}
		for (int k = K; k >= 0; k--) {
			if (sparceTable[k][A] != sparceTable[k][B]) {
				A = sparceTable[k][A];
				B = sparceTable[k][B];
			}
		}
		while (A != B) {
			A = sparceTable[0][A];
			B = sparceTable[0][B];
		}
		return A;
	} // [Lowest Common Ancestor]
	
} // [CLASS]
