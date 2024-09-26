import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// class
public class Main_2579_계단오르기_S3 {
	
	// main
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N
		int N = Integer.parseInt(br.readLine());
		
		// dp
		int[][] dp = new int[N][2];
		
		// num
		int num;
		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(br.readLine());
			if (i == 0) {
				dp[i][1] = num;
			} else if (i == 1) {
				dp[i][0] = num;
				dp[i][1] = dp[i-1][1] + num;
			} else {
				dp[i][0] = Math.max(dp[i-2][0]+num, dp[i-2][1]+num);
				dp[i][1] = dp[i-1][0]+num;
			}
		}
		
		if (dp[N-1][0] < dp[N-1][1]) {
			System.out.println(dp[N-1][1]);
		} else {
			System.out.println(dp[N-1][0]);
		}
		
	} // end of main
	
} // end of class