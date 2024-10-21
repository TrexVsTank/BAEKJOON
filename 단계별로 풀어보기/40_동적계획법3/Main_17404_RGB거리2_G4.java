import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [CLASS]
public class Main_17404_RGB거리2_G4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[][] cost;
	static int[][][] dp;
	static final int INF = 1_000_000_000;
	
	// [MAIN]
	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(br.readLine());
		
		cost = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[N][3][3];
		for (int start = 0; start < 3; start++) {
			dp[0][start][start] = cost[0][start];
		}
		
		for (int line = 1; line < N-1; line++) {
			for (int start = 0; start < 3; start++) {
				for (int from = 0; from < 3; from++) {
					for (int to = 0; to < 3; to++) {
						if (from != to && ( (dp[line][start][to] == 0) || (dp[line][start][to] > dp[line-1][start][from] + cost[line][to]) )  && dp[line-1][start][from] != 0) {
							dp[line][start][to] = dp[line-1][start][from] + cost[line][to];
						}
					}
				}
			}
		}
		
		for (int start = 0; start < 3; start++) {
			for (int from = 0; from < 3; from++) {
				for (int to = 0; to < 3; to++) {
					if (start != to && from != to && ( (dp[N-1][start][to] == 0) || (dp[N-1][start][to] > dp[N-2][start][from] + cost[N-1][to]) ) && dp[N-2][start][from] != 0) {
						dp[N-1][start][to] = dp[N-2][start][from] + cost[N-1][to];
					}
				}
			}
		}
		
		int min = INF;
		for (int start = 0; start < 3; start++) {
			for (int color = 0; color < 3; color++) {
				if (dp[N-1][start][color] != 0) {
					min = Math.min(min, dp[N-1][start][color]);
				}
			}
		}
		
		System.out.println(min);
		
	} // [MAIN]
	
} // [CLASS]
