import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// class S
public class Main_2206_벽부수고이동하기_G3 {
	
	static int N;
	static int M;
	
	// main S
	public static void main(String[] args) throws IOException {
		
		int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][][] arr = new int[N][M][2];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				int n = -str.charAt(j)+'0';
				arr[i][j][0] = arr[i][j][1] = n;
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.deepToString(arr[i]));
//		}
//		System.out.println();
		
		int time = 1;
		
		Queue<int[]> queue = new ArrayDeque<>();
		
		arr[0][0][0] = time;
		queue.offer(new int[] {0, 0, 0});
		
		
		while (!queue.isEmpty()) {
			time++;
			
			int s = queue.size();
			for (int i = 0; i < s; i++) {
				int[] q = queue.poll();
				int r = q[0];
				int c = q[1];
				int b = q[2];
				
				for (int[] d : dir) {
					int R = r+d[0];
					int C = c+d[1];

					if (checker(R, C)) {
						
						if (b == 0) {
							if (arr[R][C][0] == 0) {
								arr[R][C][0] = time;
								queue.offer(new int[] {R, C, 0});
							}
							if (arr[R][C][0] == -1 && arr[R][C][1] == -1) {
								arr[R][C][1] = time;
								queue.offer(new int[] {R, C, 1});
							}
							
						}
						
						if (b == 1) {
							if (arr[R][C][1] == 0) {
								arr[R][C][1] = time;
								queue.offer(new int[] {R, C, 1});
							}
						}
						
					}
				}
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.deepToString(arr[i]));
//		}
		
		if (arr[N-1][M-1][0] == 0 && arr[N-1][M-1][1] == 0) {
			System.out.println(-1);
		} else if (arr[N-1][M-1][0] > 0 && arr[N-1][M-1][1] > 0) {
			System.out.println(Math.min(arr[N-1][M-1][0], arr[N-1][M-1][1]));
		} else {
			System.out.println(Math.max(arr[N-1][M-1][0], arr[N-1][M-1][1]));
		}
		
	} // main E
	
	// checker S
	static boolean checker(int row, int col) {
		return 0 <= row && row < N && 0 <= col && col < M;
	} // checker E
	
} // class E
