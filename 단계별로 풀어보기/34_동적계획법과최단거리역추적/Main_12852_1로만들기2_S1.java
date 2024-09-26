import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 클래스
public class Main_12852_1로만들기2_S1 {
	
	static StringBuilder sb = new StringBuilder();
	static int dp[];
	static int dp2[];
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// [입력] 1 ~ 10**6
		int N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		dp2 = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			counter(i);
		}
		
		sb.append(counter(N)).append("\n");
		int num = N;
		while (num != 0) {
			sb.append(num).append(" ");
			num = dp2[num];
		}
		System.out.println(sb);
	} // 메인 끝
	
	// 카운터
	static int counter(int num) {
		if (dp[num] != 0) {
			return dp[num];
		}
		if (num <= 1) {
			return dp[1] = 0;
		}
		
		int min = counter(num-1)+1;
		int min_idx = num-1;
		if (num % 2 == 0 && min >= counter(num/2)+1) {
			min = counter(num/2)+1;
			min_idx = num/2;
		}
		if (num % 3 == 0 && min >= counter(num/3)+1) {
			min = counter(num/3)+1;
			min_idx = num/3;
		}
		dp2[num] = min_idx;
		return dp[num] = min;
	} // 카운터 끝
	
} // 클래스 끝
