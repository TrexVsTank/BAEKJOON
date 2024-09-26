import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// class
public class Main_1463_1로만들기_S3 {
	
	// main
	public static void main(String[] args) throws IOException {
		
		// br
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N
		int N = Integer.parseInt(br.readLine());
		
		// dp
		int[] dp = new int[N+1];
		
		dp[1] = 0;
		
		for (int i = 2; i <= N; i++) {
			if (i <= 3) {
				dp[i] = 1;
			} else {
				dp[i] = dp[i-1]+1;
				if (i % 2 == 0) {
					dp[i] = Math.min(dp[i], dp[i/2]+1);
				}
				if (i % 3 == 0) {
					dp[i] = Math.min(dp[i], dp[i/3]+1);
				}
			}
			
		}
		
		System.out.println(dp[N]);
		
	} // end of main
	
} // end of class