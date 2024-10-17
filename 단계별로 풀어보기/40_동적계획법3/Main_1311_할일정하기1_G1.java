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
public class Main_1311_할일정하기1_G1 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static final int INF = 1_000_000_000;
	static int FULL;
	
	static int N;
	static int[][] info;
	static int[] pow;
	static int[] dp;
	static List<Integer> temp;
	static Set<Integer> next_temp;
	static int status;
	
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
		
		// [pow]
		pow = new int[N+1];
		pow[1] = 1;
		for (int i = 2; i <= N; i++) {
			pow[i] = pow[i-1] * 2;
		}
		
		// [FULL]
		FULL = pow[N] * 2 - 1;
		
		// [dp]
		dp = new int[FULL + 1];
		Arrays.fill(dp, INF);
		dp[0] = 0;
		
		// RUN
		run();
		
		// PRINT
		System.out.println(dp[FULL]);
	} // [main]
	
	// [메서드] run
	static void run() {
		temp = new ArrayList<>();
		temp.add(0);
		for (int i = 1; i <= N; i++) {
			next_temp = new HashSet<>();
			for (int b : temp) {
				for (int p = 1; p <= N; p++) {
					if ((pow[p] & b) != pow[p]) {
						status = b + pow[p];
						next_temp.add(status);
						dp[status] = Math.min(dp[status], dp[b] + info[i][p]);
					}
				}
			}
			temp = new ArrayList<>();
			for (int t : next_temp) {
				temp.add(t);
			}
		}
	} // [메서드] run
	
} // [class]
