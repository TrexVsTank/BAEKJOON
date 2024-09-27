import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// [클래스] 메인
public class Main_13913_숨바꼭질4_G4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	// [메서드] 메인
	public static void main(String[] args) throws IOException {
		
		// 입력
		st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken()); // 수빈 (0 ~ 100,000) 
		int B = Integer.parseInt(st.nextToken()); // 동생 (0 ~ 100,000)
		
		// BFS
		Queue<Integer> queue = new ArrayDeque<>(); // BFS Queue
		queue.offer(A);
		int[] trace = new int[100_001]; // 방문처리 & 역추적용 배열
		Arrays.fill(trace, -1);
		trace[A] = 0;
		int time = 0; // 동생을 찾는 가장 빠른 시간
		w : while (!queue.isEmpty()) {
			int QS = queue.size();
			for (int i = 0; i < QS; i++) {
				int curr = queue.poll();
				if (curr == B) {
					break w;
				}
				for (int j : new int[] {curr-1, curr+1, curr*2}) {
					if (inRange(j) && trace[j] == -1) {
						queue.offer(j);
						trace[j] = curr;
					}
				}
			}
			time++;
		}
		
		// 역추적
		Stack<Integer> stack = new Stack<>(); // 역추적 Stack
		int val = B;
		stack.push(val);
		while (val != A) {
			val = trace[val];
			stack.push(val);
		}
		
		// 출력
		sb.append(time).append("\n");
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb);
		
	} // [메서드] 메인
	
	// [메서드] 범위체커
	private static boolean inRange(int index) {
		return 0 <= index && index <= 100_000;
	} // [메서드] 범위체커
	
} // [클래스] 메인
