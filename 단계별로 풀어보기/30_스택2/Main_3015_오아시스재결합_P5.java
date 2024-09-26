import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// [클래스] 메인
public class Main_3015_오아시스재결합_P5 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static long result = 0; // 125_000_250_000 까지 가능 하므로 long타입 (같은 키 50만명)
	
	// [메서드] 메인
	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine()); // 사람의 수 (1 ~ 500,000)
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < N; i++) { // 키 (2^31 이하)
			int curr_Num = Integer.parseInt(br.readLine());
			while (!stack.isEmpty() && stack.peek() < curr_Num) {
				int pop_Num = stack.pop();
				int pop_Count = 1; // 동일한 키 카운트
				while (!stack.isEmpty() && stack.peek() == pop_Num) {
					stack.pop();
					pop_Count++;
				}
				while (pop_Count != 0) {
					result += stack.isEmpty() ? pop_Count : pop_Count+1;
					pop_Count--;
				}
			}
			stack.push(curr_Num);
		}
		
		while (!stack.isEmpty()) { // 잔여스택 처리
			int pop_Num = stack.pop();
			int pop_Count = 1; // 동일한 키 카운트
			while (!stack.isEmpty() && stack.peek() == pop_Num) {
				stack.pop();
				pop_Count++;
			}
			while (pop_Count != 0) {
				result += stack.isEmpty() ? pop_Count-1 : pop_Count;
				pop_Count--;
			}
		}
		
		// 출력
		System.out.println(result);
		
	} // [메서드] 메인
	
	
} // [클래스] 메인
