import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 클래스
public class Main_1725_히스토그램_P5 {
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1 ~ 100,000
		int N = Integer.parseInt(br.readLine());
		
		// 1 ~ 1,000,000,000
		long[] hist = new long[N];
		for (int i = 0; i < N; i++) {
			hist[i] = Long.parseLong(br.readLine());
		}
		
		long max = 0;
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && hist[stack.peek()] >= hist[i]) {
				int idx = stack.pop();
				long height = hist[idx];
				long width = 0;
				width = stack.isEmpty() ? i : i-stack.peek()-1;
				long extent = width*height;
				if (max < extent) {
					max = extent;
				}
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int idx = stack.pop();
			long height = hist[idx];
			long width = 0;
			width = stack.isEmpty() ? N : N-stack.peek()-1;
			long extent = width*height;
			if (max < extent) {
				max = extent;
			}
		}
		
		System.out.println(max);
		
	} // 메인 끝
	
} // 클래스 끝