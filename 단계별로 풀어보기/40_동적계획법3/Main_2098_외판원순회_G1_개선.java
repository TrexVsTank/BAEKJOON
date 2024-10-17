import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [CLASS]
public class Main_2098_외판원순회_G1_개선 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static final int INF = 16_000_000;
	static int[] pow;
	static int FULL;
	
	static int N;
	static int[][] cost;
	static int[][] dp;
	
	// [MAIN]
	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(br.readLine());
		
		cost = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pow = new int[N];
		pow[0] = 1;
		for (int i = 1; i < N; i++) {
			pow[i] = pow[i-1] << 1;
		}
		
		FULL = pow[N-1] << 1;
		
		dp = new int[N][FULL--];
		
		System.out.println(dfs(0, 1));
		
	} // [MAIN]
	
	// [DFS]
	private static int dfs(int from, int visit) {
		
		if (visit == FULL) {
			return cost[from][0] == 0 ? INF : cost[from][0];
		}
		
		if (dp[from][visit] != 0) {
			return dp[from][visit];
		}
		
		int temp = INF;
		
		for (int to = 1; to < N; to++) {
			if (cost[from][to] != 0 && (visit & pow[to]) == 0) {
				temp = Math.min(temp, cost[from][to] + dfs(to, visit | pow[to]));
			}
		}
		
		return dp[from][visit] = temp;
	} // [DFS]
	
} // [CLASS]