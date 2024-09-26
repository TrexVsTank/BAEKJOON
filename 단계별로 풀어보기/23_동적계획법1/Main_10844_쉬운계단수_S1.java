import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// class
public class Main_10844_쉬운계단수_S1 {
	
	// main
	public static void main(String[] args) throws IOException {
		
		// br
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N
		int N = Integer.parseInt(br.readLine());
		
		// dp
		long dp[][] = new long[N][10];
		
		for (int i = 1; i < 10; i++) {
			dp[0][i] = 1;
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					dp[i][j] = dp[i-1][1];
				} else if (j == 9) {
					dp[i][j] = dp[i-1][8];
				} else {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
				}
				if (dp[i][j] >= 1000000000) {
					dp[i][j] %= 1000000000;
				}
			}
		}
		
		// sum
		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += dp[N-1][i];
		}
		if (sum >= 1000000000) {
			sum %= 1000000000;
		}
		
		System.out.println(sum);
		
	} // end of main
	
} // end of class