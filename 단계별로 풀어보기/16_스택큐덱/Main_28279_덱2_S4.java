import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_28279_덱2_S4 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> D = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int input = Integer.parseInt(st.nextToken());
			if (input == 1) {
				int val = Integer.parseInt(st.nextToken());
				D.offerFirst(val);
			} else if (input == 2) {
				int val = Integer.parseInt(st.nextToken());
				D.offerLast(val);
			} else if (input == 3) {
				if (D.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(D.pollFirst()).append("\n");
				}
			} else if (input == 4) {
				if (D.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(D.pollLast()).append("\n");
				}
			} else if (input == 5) {
				sb.append(D.size()).append("\n");
			} else if (input == 6) {
				if (D.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			} else if (input == 7) {
				if (D.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(D.peekFirst()).append("\n");
				}
			} else {
				if (D.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(D.peekLast()).append("\n");
				}
			}
		}
		
		System.out.println(sb);
		
	}
}