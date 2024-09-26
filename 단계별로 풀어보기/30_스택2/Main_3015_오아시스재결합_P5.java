import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 클래스
public class Main_3015_오아시스재결합_P5 {
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1 ~ 500,000
		int N = Integer.parseInt(br.readLine());
		
		// 1 ~ 2^31
		long[] arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		long result = 0;
		
		Stack<Long> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && stack.peek() < arr[i]) {
				long num = stack.pop();
				long count = 1;
				while (!stack.isEmpty() && stack.peek() == num) {
					stack.pop();
					count++;
				}
				if (count == 1) {
					result += stack.isEmpty()? 1 : 2;
				} else {
					result += stack.isEmpty()? counter(1, count) : counter(2, count);
				}
			}
			stack.push(arr[i]);
		}
		
		while (!stack.isEmpty()) {
			long num = stack.pop();
			long count = 1;
			while (!stack.isEmpty() && stack.peek() == num) {
				stack.pop();
				count++;
			}
			if (count == 1) {
				result += stack.isEmpty()? 0 : 1;
			} else {
				result += stack.isEmpty()? counter(1, count-1) : counter(1, count);
			}
		}
		
		System.out.println(result);
		
	} // 메인 끝
	
	static long counter(long num, long count) {
		if (count == 1) {
			return num;
		}
		return counter(num, count-1) + (count+num-1);
	}
	
} // 클래스 끝