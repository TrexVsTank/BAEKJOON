import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 클래스
public class Main_2178_미로탐색_S1 {
	
	// 스태틱
	static int N;
	static int M;
	
	static int[][] dir = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {0, 0});
		arr[0][0] = 2;
		int time = 2;
		
		while (true) {
			int q = queue.size();
			for (int i = 0; i < q; i++) {
				int[] idx = queue.poll();
				for (int[] d : dir) {
					if (checker(idx[0]+d[0], idx[1]+d[1]) && arr[idx[0]+d[0]][idx[1]+d[1]] == 1) {
						queue.offer(new int[] {idx[0]+d[0], idx[1]+d[1]});
						arr[idx[0]+d[0]][idx[1]+d[1]] = time;
					}
				}
			}
			
			if (arr[N-1][M-1] != 1) {
				break;
			}
			
			time++;
		}
		
		
		System.out.println(time);
		
	} // 메인 끝
	
	// 체커
	static boolean checker(int row, int col) {
		if (0 <= row && row < N && 0 <= col && col < M) {
			return true;
		}
		return false;
	} // 체커 끝
	
} // 클래스 끝
