import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 클래스
public class Main_2470_두용액_G5 {
	
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
		
		int left = 0;
		int right = arr.length-1;
		int MIN = Math.abs(arr[left]+arr[right]);
		int LEF = left;
		int RIG = right;
		
		while (left < right) {
			if (arr[left] + arr[right] == 0) {
				LEF = left;
				RIG = right;
				break;
			}
			if (Math.abs(arr[left] + arr[right]) < MIN) {
				MIN = Math.abs(arr[left] + arr[right]);
				LEF = left;
				RIG = right;
			}
			if (arr[left] + arr[right] > 0) {
				right--;
			}
			if (arr[left] + arr[right] < 0) {
				left++;
			}
		}
		
		System.out.println(arr[LEF] + " " + arr[RIG]);
		
	} // 메인 끝
	
}// 클래스 끝
