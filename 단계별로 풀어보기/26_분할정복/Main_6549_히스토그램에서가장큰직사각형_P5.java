import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// [클래스] 메인
public class Main_6549_히스토그램에서가장큰직사각형_P5 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	// [메서드] 메인
	public static void main(String[] args) throws IOException {
		
		String input = br.readLine();
		
		// 테스트케이스
		while (!input.equals("0")) {
			st = new StringTokenizer(input, " ");
			
			int N = Integer.parseInt(st.nextToken()); // 막대의 수 (1 <= N <= 100,000)
			
			long max_Extent = 0;
			
			Stack<long[]> stack = new Stack<>();
			for (int idx = 1; idx <= N; idx++) {
				long curr_Height = Integer.parseInt(st.nextToken()); // 막대의 높이 (0 <= h <= 10^9)
				
				while (!stack.isEmpty() && stack.peek()[0] >= curr_Height) {
					
					long[] popped = stack.pop();
					long popped_Height = popped[0]; // 높이
					long width = stack.isEmpty() ? // 넓이
						idx-1 :
						idx-1 - stack.peek()[1];
					max_Extent = Math.max(max_Extent, popped_Height * width);
				}
				stack.push(new long[] {curr_Height, idx});
			}
			
			while (!stack.isEmpty()) {
				long[] popped = stack.pop();
				long popped_Height = popped[0]; // 높이
				long width = stack.isEmpty() ?
					N :
					N - stack.peek()[1]; // 넓이
				max_Extent = Math.max(max_Extent, popped_Height * width);
			}
			
			sb.append(max_Extent).append("\n");
			
			input = br.readLine();
			
		} // 테스트케이스
		
		// 출력
		System.out.println(sb);
		
	} // [메서드] 메인
	
	
} // [클래스] 메인
