import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 클래스 시작
public class Main_11066_파일합치기_G3 {
	
	static int K;
	static int arr[];
	static int sum[];
	static int dp[][];
	
	// 메인 시작
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			
			K = Integer.parseInt(br.readLine()); // 3 ~ 500
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr = new int[K+1]; // 1 ~ 10,000
			sum = new int[K+1];
			dp = new int[K+1][K+1];
			for (int i = 1; i <= K; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum[i] = arr[i] + sum[i-1];
			}
			
//			System.out.println(Arrays.toString(arr));
//			System.out.println(Arrays.toString(sum));
			System.out.println(merge_file(1, K));
		}
		
	} // 메인 끝
	
	// 파입합치기 시작
	static int merge_file(int left, int right) {
		if (left >= right) {
			return 0;
		}
		if (dp[left][right] != 0) {
			return dp[left][right];
		}
		if (left+1 == right) {
			return dp[left][right] = arr[left]+arr[right];
		}
		
		int L = left;
		int mid = left;
		int R = right;
		
		int minimum = Integer.MAX_VALUE;
		for (int i = left; i < right; i++) {
			if (minimum > merge_file(left, i) + merge_file(i+1, right)) {
				minimum = merge_file(left, i) + merge_file(i+1, right);
				mid = i;
			}
		}
		
		return dp[left][right] = minimum + sum[right]-sum[left-1];
	} // 파일합치기 끝
	
} // 클래스 끝