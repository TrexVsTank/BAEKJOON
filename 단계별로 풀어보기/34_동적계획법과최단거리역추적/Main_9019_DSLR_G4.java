import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// [클래스] 메인
public class Main_9019_DSLR_G4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static char[] command = {'D', 'S', 'L', 'R'};
	
	// [메서드] 메인
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine()); // 테케 수
		
		// 테케
		for (int t = 0; t < T; t++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken()); // 출발
			int B = Integer.parseInt(st.nextToken()); // 도착
			
			int[] trace_int = new int[10000]; // 인덱스 역추적 배열
			Arrays.fill(trace_int, -1);
			char[] trace_char = new char[10000]; // 명령 기록용 배열
			
			// BFS
			Queue<Integer> queue = new ArrayDeque<>();
			queue.offer(A);
			while (!queue.isEmpty()) {
				int curr = queue.poll();
				if (curr == B) {
					break;
				}
				for (char c : command) {
					int next = command_DSLR(curr, c);
					if (trace_int[next] == -1) {
						trace_int[next] = curr;
						trace_char[next] = c;
						queue.offer(next);
					}
				}
			}
			
			// 역추적
			Stack<Character> stack = new Stack<>();
			int val = B;
			while (val != A) {
				stack.push(trace_char[val]);
				val = trace_int[val];
			}
			
			// 어펜드
			while (!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			sb.append("\n");
			
		} // 테케
		
		// 출력
		System.out.println(sb);
		
	} // [메서드] 메인
	
	// [메서드] command_DSLR
	static int command_DSLR(int n, char c) {
		switch (c) {
		case 'D':
			return command_D(n);
		case 'S':
			return command_S(n);
		case 'L':
			return command_L(n);
		case 'R':
			return command_R(n);
		}
		return 0;
	} // [메서드] command_DSLR
	
	// [메서드] command_D
	static int command_D(int num) {
		return (num * 2)%10000;
	} // [메서드] command_D
	
	// [메서드] command_S
	static int command_S(int num) {
		return num == 0 ? 9999 : num-1; // num-1이 0이면 X | num이 0이면 O
	} // [메서드] command_S
	
	// [메서드] command_L
	static int command_L(int num) {
		int n = num;
		int a = n/1000; n %= 1000;
		int b = n/100; n %= 100;
		int c = n/10; n %= 10;
		int d = n/1;
		return 1000*b + 100*c + 10*d + a;
	} // [메서드] command_L
	
	// [메서드] command_R
	static int command_R(int num) {
		int n = num;
		int a = n/1000; n %= 1000;
		int b = n/100; n %= 100;
		int c = n/10; n %= 10;
		int d = n/1;
		return 1000*d + 100*a + 10*b + c;
	} // [메서드] command_R
	
} // [클래스] 메인
