import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 클래스
public class Main_9252_LCS2_G4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static String str_A;
	static String str_B;	
	static int dp[][];
	
	// 메인
	public static void main(String[] args) throws IOException {
		str_A = br.readLine();
		str_B = br.readLine();
		
		dp = new int[str_A.length()+1][str_B.length()+1];
		for (int i = 0; i < str_A.length()+1; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		sb.append(LCS2(0, 0)).append("\n");
		if (LCS2(0, 0) == 0) {
			System.out.println(sb);
			System.exit(0);
		}
		int idx_A = 0;
		int idx_B = 0;
		while (idx_A < str_A.length() && idx_B < str_B.length()) {
			if (dp[idx_A][idx_B] == 0) {
				break;
			}
			if (dp[idx_A][idx_B] == dp[idx_A+1][idx_B]) {
				idx_A++;
			} else if (dp[idx_A][idx_B] == dp[idx_A][idx_B+1]) {
				idx_B++;
			} else {
				sb.append(str_A.charAt(idx_A));
				idx_A++;
				idx_B++;
			}
		}
		System.out.println(sb);
	} // 메인
	
	// LCS2
	static int LCS2(int idx_a, int idx_b) {
		if (idx_a == str_A.length() || idx_b == str_B.length()) {
			return 0;
		}
		if (dp[idx_a][idx_b] != -1) {
			return dp[idx_a][idx_b];
		}
		if (str_A.charAt(idx_a) == str_B.charAt(idx_b)) {
			return dp[idx_a][idx_b] = LCS2(idx_a+1, idx_b+1) + 1;
		} else {
			return dp[idx_a][idx_b] = Math.max(LCS2(idx_a, idx_b+1), LCS2(idx_a+1, idx_b));
		}
	} // LCS2
	
} // 클래스
