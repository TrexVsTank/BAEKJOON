import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// [CLASS]
public class Main_3584_가장가까운공통조상_G4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int K;
	static int[][] parentArr;
	static List<Integer>[] childArr;
	static int[] depthArr;
	static int root;
	
	// [MAIN]
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		// [TEST CASE]
		for (int t = 0; t < T; t++) {
			
			N = Integer.parseInt(br.readLine());
			
			K = 1;
			while (N - 1 > Math.pow(2, K)) {
				K++;
			}
			
			childArr = new List[N+1];
			for (int i = 1; i <= N; i++) {
				childArr[i] = new ArrayList<>();
			}
			
			parentArr = new int[K+1][N+1];
			for (int i = 0; i < N-1; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				parentArr[0][child] = parent;
				childArr[parent].add(child);
			}
			for (int k = 1; k <= K; k++) {
				for (int n = 1; n <= N; n++) {
					parentArr[k][n] = parentArr[k-1][parentArr[k-1][n]];
				}
			}
			
			for (int i = 1; i <= N; i++) {
				if (parentArr[0][i] == 0) {
					root = i;
					break;
				}
			}
			
			
			depthArr = new int[N+1];
			Queue<Integer> queue = new ArrayDeque<>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				int curr = queue.poll();
				for (int i : childArr[curr]) {
					depthArr[i] = depthArr[curr] + 1;
					queue.offer(i);
				}
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if (depthArr[A] > depthArr[B]) {
				int temp = A;
				A = B;
				B = temp;
			}
			for (int k = K; k >= 0; k--) {
				if (depthArr[A] <= depthArr[B] - Math.pow(2, k)) {
					B = parentArr[k][B];
				}
			}
			
			while (A != B) {
				A = parentArr[0][A];
				B = parentArr[0][B];
			}
			
			System.out.println(A);
			
		} // [TEST CASE]
		
	} // [MAIN]
	
} // [CLASS]
