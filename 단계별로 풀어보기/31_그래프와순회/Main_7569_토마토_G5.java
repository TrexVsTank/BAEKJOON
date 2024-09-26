import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569_토마토_G5 {
	
	static int dir[][] = { {0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}, {0, 0, 1}, {0, 0, -1} };
	
	static int M;
	static int N;
	static int H;
	
	static Queue<int[]> queue = new ArrayDeque<>();
	
	static int count;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		count = M*N*H;
		
		int[][][] arr = new int[N][M][H];
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int m = 0; m < M; m++) {
					int num = Integer.parseInt(st.nextToken());
					arr[n][m][h] = num;
					if (num != 0) {
						count--;
						if (num == 1) {
							queue.offer(new int[] {n, m, h});
						}
					}
				}
			}
		}
		
		int time = 0;
		while (!queue.isEmpty()) {
			int s = queue.size();
			for (int i = 0; i < s; i++) {
				int[] q = queue.poll();
				for (int[] d : dir) {
					int R = q[0]+d[0];
					int C = q[1]+d[1];
					int H = q[2]+d[2];
					if (checker(R, C, H) && arr[R][C][H] == 0) {
						queue.offer(new int[] {R, C, H});
						arr[R][C][H] = 1;
						count--;
					}
				}
			}
			time++;
		}
		
		if (count == 0) {
			System.out.println(time-1);
		} else {
			System.out.println(-1);
		}
		
	}
	
	static boolean checker(int r, int c, int h) {
		if (0 <= r && r < N && 0 <= c && c < M && 0 <= h && h < H) {
			return true;
		}
		return false;
	}
	
}
