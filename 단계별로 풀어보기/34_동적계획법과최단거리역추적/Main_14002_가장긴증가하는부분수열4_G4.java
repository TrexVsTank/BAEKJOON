import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 클래스
public class Main_14002_가장긴증가하는부분수열4_G4 {
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 1 ~ 1,000
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // 1 ~ 1,000
		}
		
		// 연산
		int result = 0;
		int[] dp = new int[N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= i; j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
					result = Math.max(result, dp[i]);
				}
			}
		}
		
		// 출력
		int value = result;
		Stack<Integer> stack = new Stack<>();
		for (int i = N; i >= 1; i--) {
			if (value == dp[i]) {
				stack.push(arr[i]);
				value--;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(result).append("\n");
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb);
		
	} // 메인
	
} // 클래스