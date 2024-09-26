import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 클래스
public class Main_1806_부분합_G4 {
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// [입력]
		int N = Integer.parseInt(st.nextToken());
		long S = Integer.parseInt(st.nextToken());
		
		// [입력]
		long[] arr = new long[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
//		System.out.println(Arrays.toString(arr));
		for (int i = 1; i <= N; i++) {
			arr[i] += arr[i-1];
		}
//		System.out.println(Arrays.toString(arr));
		
		int left = 1;
		int right = 1;
		int INF = 1_000_000_000;
		int MIN = INF;
		while (right <= N && left <= N) {
			if (left > right) {
				int temp = left;
				left = right;
				right = temp;
			}
			if (arr[right]- arr[left-1] >= S) {
				left++;
				MIN = Math.min(MIN, right-left+2);
				continue;
			}
			if (arr[right] - arr[left-1] < S) {
				right++;
				continue;
			}
		}
		
		System.out.println(MIN != INF ? MIN : 0);
		
	} // 메인 끝
	
} // 클래스 끝
