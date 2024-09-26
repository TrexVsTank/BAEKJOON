import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// class
public class Main_12865_평범한배낭_G5 {
	
	static int N;
	static int K;
	static int dp[];
	
	// main
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[K+1];
		int weight = 0;
		int value = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			weight = Integer.parseInt(st.nextToken());
			value = Integer.parseInt(st.nextToken());
			for (int j = K-weight; j >= 0; j--) {
				if (dp[weight+j] < dp[j] + value) {
					dp[weight+j] = dp[j] + value;
				}
			}
		}
		
		System.out.println(dp[K]);
		
	} // end of main
	
} // end of class