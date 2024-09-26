import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 클래스
public class Main_3273_두수의합_S3 {
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// [입력]
		int N = Integer.parseInt(br.readLine());
		
		// [입력]
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		// [입력]
		int X = Integer.parseInt(br.readLine());
		
		// 계산 출력
		int result = 0;
		int left = 0;
		int right = arr.length-1;
		
		while (left < right) {
			if (arr[left] + arr[right] == X) {
				result++;
				left++;
				right--;
				continue;
			}
			if (arr[left] + arr[right] > X) {
				right--;
				continue;
			}
			if (arr[left] + arr[right] < X) {
				left++;
				continue;
			}
		}
		
		System.out.println(result);
		
	} // 메인 끝
	
} // 클래스 끝
