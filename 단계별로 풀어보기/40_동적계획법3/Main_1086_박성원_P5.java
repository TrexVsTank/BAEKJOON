import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// [CLASS]
public class Main_1086_박성원_P5 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;
	static String[] number;
	static int K;
	
	static int FULL;
	static int[] pow;
	static long[][] dp;
	static int[][] mods;
	static long[] facts;
	
	// [MAIN]
	public static void main(String[] args) throws IOException {
		
		input();
		
		init();
		
		long result = dfs(0, 0);
		
		if (result == 0) {
			System.out.println("0/1");
		} else if (result == facts[N]) {
			System.out.println("1/1");
		} else {
			long GCV = uclid_GCV(facts[N], result);
			System.out.println(result / GCV + "/" + facts[N] / GCV);
		}
		
	} // [MAIN]
	
	// [DFS]
	private static long dfs(int mod, int visit) {
		if (visit == FULL) {
			return mod == 0 ? 1 : 0;
		}
		
		if (dp[mod][visit] != -1) {
			return dp[mod][visit];
		}
		
		long count = 0;
		for (int i = 0; i < N; i++) {
			if ( (visit & pow[i]) == 0) {
				count += dfs(modCal(i, mod), visit | pow[i]);
			}
		}
		return dp[mod][visit] = count;
	} // [DFS]
	
	// [UCLID GCV]
	private static long uclid_GCV(long big, long small) {
		if (big % small == 0) {
			return small;
		}
		return uclid_GCV(small, big % small);
	} // [UCLID]
	
	// [MODCAL]
	private static int modCal(int index, int mod) {
		if (mods[mod][index] != -1) {
			return mods[mod][index];
		}
		int result = mod;
		for (char c : number[index].toCharArray())
			result = (result * 10 + c - '0') % K;
		return mods[mod][index] = result;
	} // [MODCAL]
	
	// [FACT]
	private static long fact(int n) {
		if (facts[n] != 0) {
			return facts[n];
		}
		if (n <= 1) {
			return facts[n] = 1;
		}
		return facts[n] = fact(n-1) * n;
	} // [FACT]
	
	// [INPUT]
	private static void input() throws NumberFormatException, IOException {
		
		N = Integer.parseInt(br.readLine());
		
		number = new String[N];
		for (int i = 0; i < N; i++) number[i] = br.readLine();
		
		K = Integer.parseInt(br.readLine());
		
	} // [INPUT]
	
	// [INIT]
	private static void init() {
		
		pow = new int[N+1]; pow[0] = 1;
		for (int i = 1; i <= N; i++) pow[i] = pow[i-1] << 1;
		
		FULL = pow[N] - 1;
		
		dp = new long[K][pow[N]];
		for (long[] i : dp) Arrays.fill(i, -1);
		
		mods = new int[K][N];
		for (int[] i : mods) Arrays.fill(i, -1);
		
		facts = new long[N+1];
		fact(N);
	} // [INIT]
	
} // [CLASS]
