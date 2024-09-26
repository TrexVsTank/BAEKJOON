import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 클래스
public class Main_1520_내리마길_G3 {
	
	static int N;
	static int M;
	static int map[][];
	static int dp[][];
	static int direction[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 동 서 남 북
	// 메인
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 1 ~ 500
		M = Integer.parseInt(st.nextToken()); // 1 ~ 500
		
		map = new int[N][M];
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		dp[0][0] = 1;
		
		System.out.println(path_finder(N-1, M-1));
		
//		System.out.println();
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println();
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		
	} // 메인
	
	// 패스파인더
	static int path_finder(int row, int col) {
		if (dp[row][col] != -1) {
			return dp[row][col];
		}
		dp[row][col] = 0;
		for (int[] dir : direction) {
			if(
				0 <= row+dir[0] &&
				row+dir[0] < N &&
				0 <= col+dir[1] &&
				col+dir[1] < M &&
				map[row][col] < map[row+dir[0]][col+dir[1]])
			{
				dp[row][col] += path_finder(row+dir[0], col+dir[1]);
			}
		}
		return dp[row][col];
	} // 패스파인더 끝
	
} // 클래스