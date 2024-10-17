import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

// [class]
public class Main_2098_외판원순회_G1 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	
	static int N;
	static int[][] info;
	
	static final int INF = 1_000_000_000;
	static int[] power;
	static int FULL;
	static int[][] dp;
	
	static List<int[]> temp;
	static Set<int[]> next_temp;
	static int status;
	static int tf;
	static int ts;
	
	// [main]
	public static void main(String[] args) throws IOException {
		
		// [N]
		N = Integer.parseInt(br.readLine());
		
		// [info]
		info = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				info[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// [power]
		power = new int[N+1];
		power[1] = 1;
		for (int i = 2; i <= N; i++) {
			power[i] = power[i-1] * 2;
		}
		
		// [FULL]
		FULL = power[N] * 2 - 1;
		
		// [dp]
		dp = new int[FULL+1][N+1];
		for (int i = 1; i <= FULL; i++) {
			Arrays.fill(dp[i], INF);
		}
		dp[0][1] = 0;
		
		// RUN
		run();
		
		// PRINT
		int result = dp[FULL][1];
		System.out.println(result);
		
	} // [main]
	
	// [메서드] run
	private static void run() {
		
		temp = new ArrayList<>();
		temp.add(new int[] {0, 1});
		
		for (int i = 1; i <= N; i++) {
			
			next_temp = new HashSet<>();
			
			for (int[] t : temp) {
				ts = t[0];
				tf = t[1];
				for (int to = 1; to <= N; to++) {
					status = ts + power[to];
					if (tf != to && power[to] == (power[to] & status) && info[tf][to] != 0 && dp[status][to] > dp[ts][tf] + info[tf][to]) {
						next_temp.add(new int[] {status, to});
						dp[status][to] = dp[ts][tf] + info[tf][to];
					}
				}
			}
			
			temp = new ArrayList<>();
			for (int[] nt : next_temp) {
				temp.add(nt);
			}
			
		}
	} // [메서드] run
	
} // [class]
