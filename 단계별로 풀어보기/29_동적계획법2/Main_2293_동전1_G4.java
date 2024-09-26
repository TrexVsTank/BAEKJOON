import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 클래스
public class Main_2293_동전1_G4 {
	
	static int N;
	static int K;
	static int coin[];
	static int dp[][];
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 1 ~ 100
		K = Integer.parseInt(st.nextToken()); // 1 ~ 10,000
		
		coin = new int[N]; // 1 ~ 100,000
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new int[N][K+1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= K; j++) {
				dp[i][j] = -1;
			}
		}
		
		System.out.println(calculate(N-1, K));
		
	} // 메인 끝
	
	// 계산
	static int calculate(int n, int k) {
		if (dp[n][k] != -1) {
			return dp[n][k];
		}
		if (n == 0) {
			if (k % coin[n] == 0) {
				return dp[n][k] = 1;
			} else {
				return dp[n][k] = 0;
			}
		}
		dp[n][k] = 0;
		int num = 0;
		while (k >= coin[n]*num) {
			dp[n][k] += calculate(n-1, k-coin[n]*num);
			num++;
		}
		return dp[n][k];
	} // 계산 끝
	
} // 클래스 끝