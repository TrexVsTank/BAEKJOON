import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 클래스
public class Main_7576_토마토_G5 {
	
	// 스태틱
	static int dir[][] = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
	
	static int N;
	static int M;
	
	static int arr[][];
	
	static int count = 0;
	
	static Queue<int[]> queue = new ArrayDeque<>();
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		count = N*M;
		
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					count--;
					queue.offer(new int[] {i, j});
				} else if (num == -1) {
					count--;
				}
				arr[i][j] = num;
			}
		}
		
		int time = 0;
		
		while (!queue.isEmpty()) {
			int s = queue.size();
			for (int i = 0; i < s; i++) {
				int q[] = queue.poll();
				for (int[] d : dir) {
					if (checker(q[0]+d[0], q[1]+d[1]) && arr[q[0]+d[0]][q[1]+d[1]] == 0) {
						queue.offer(new int[] {q[0]+d[0], q[1]+d[1]});
						count--;
						arr[q[0]+d[0]][q[1]+d[1]] = 1;
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
		
	} // 메인 끝
	
	// 체커
	static boolean checker(int row, int col) {
		if (0 <= row && row < N && 0 <= col && col < M) {
			return true;
		}
		return false;
	} // 체커 끝
	
} // 클래스 끝