import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 6549_히스토그램에서 가장 큰 직사각형

public class Main_6549_히스토그램에서가장큰직사각형_P5 {
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// N (1 ~ 100,000)
			int N = Integer.parseInt(st.nextToken());
			// 0을 입력받으면 종료
			if (N == 0) {
				break;
			}
			// hist (0 ~ 1,000,000,000)
			long[] hist = new long[N];
			for (int i = 0; i < N; i++) {
				hist[i] = Long.parseLong(st.nextToken());
			}
			
//			N = 100;
//			hist = new long[N];
//			for (int i = 0; i < N; i++) {
//				hist[i] = i+1;
//			}
			
			Stack<Integer> stack = new Stack<>();
			
			long max_extent = 0;
			
			for (int i = 0; i < N; i++) {
				while (!stack.isEmpty() && hist[stack.peek()] >= hist[i]) {
					long height = hist[stack.pop()];
					long width = 0;
					if (stack.isEmpty()) {
						width = i;
					} else {
						width = i-stack.peek()-1;
					}
					long extent = height * width;
					if (max_extent < extent) {
						max_extent = extent;
					}
				}
				stack.push(i);
			}
			
//			System.out.println(Arrays.toString(hist));
//			System.out.println(stack);
			
			while (!stack.isEmpty()) {
				int index = stack.pop();
				long height = hist[index];
				long width = 0;
				if (stack.isEmpty()) {
					width = N;
				} else {
					width = N-stack.peek()-1;
				}
				long extent = height * width;
				if (max_extent < extent) {
					max_extent = extent;
				}
			}
			
			sb.append(max_extent).append("\n");
		}
		
		System.out.println(sb);
	}
}