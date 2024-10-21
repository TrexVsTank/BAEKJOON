import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// [CLASS]
public class Main_2482_색상환_G3 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int K;
	static long BIG = 1_000_000_003;
	static long count;
	static long[][] dp;
	static long temp;
	
	// [MAIN]
	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(br.readLine());
		
		K = Integer.parseInt(br.readLine());
		
		dp = new long[K+1][N+1];
		for (int i = 0; i <= K; i++) {
			Arrays.fill(dp[i], -1);
		}
		count = munsell(K, 1, N-1) % BIG;
		
		dp = new long[K+1][N+1];
		for (int i = 0; i <= K; i++) {
			Arrays.fill(dp[i], -1);
		}
		for (int start = 2; start <= N - ((K - 1) * 2); start++) {
			count = (count + munsell(K, start, N) ) % BIG;
		}
		System.out.println(count);
		
	} // [MAIN]
	
	// [MUNSELL]
	private static long munsell(int remain, int index, int end) {
		if (dp[remain][index] != -1) {
			return dp[remain][index];
		}
		if (remain == 1) {
			return dp[remain][index] = 1;
		}
		if (end - index < (remain - 1) * 2) {
			return 0;
		}
		temp = 0;
		for (int next = index + 2; next <= end; next++) {
			temp = (temp + munsell(remain - 1, next, end) ) % BIG;
		}
		return dp[remain][index] = temp;
	} // [MUNSELL]
	
} // [CLASS]
