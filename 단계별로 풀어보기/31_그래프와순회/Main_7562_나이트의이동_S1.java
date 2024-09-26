import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 클래스
public class Main_7562_나이트의이동_S1 {
	
	// 스태틱
	static int dir[][] = { {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1} };
	
	static int N;
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		// 테케
		for (int t = 0; t < T; t++) {
			
			N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N][N];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			int er = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			
			Queue<int[]> queue = new ArrayDeque<>();
			
			queue.offer(new int[] {sr, sc});
			int time = 1;
			arr[sr][sc] = time;
			
			w : while (true) {
				int s = queue.size();
				for (int i = 0; i < s; i++) {
					int[] q = queue.poll();
					for (int[] d : dir) {
						int R = q[0]+d[0];
						int C = q[1]+d[1];
						if (R == er && C == ec) {
							break w;
						}
						if (checker(R, C) && arr[R][C] == 0) {
							arr[R][C] = 1;
							queue.offer(new int[] {R, C});
						}
					}
				}
				time++;
			}
			
			if (sr == er && sc == ec) {
				time = 0;
			}
			
			System.out.println(time);
			
		} // 테케 끝
		
	} // 메인 끝
	
	// 체커
	static boolean checker(int row, int col) {
		if (0 <= row && row < N && 0 <= col && col < N) {
			return true;
		}
		return false;
	} // 체커 끝
	
} // 클래스 끝