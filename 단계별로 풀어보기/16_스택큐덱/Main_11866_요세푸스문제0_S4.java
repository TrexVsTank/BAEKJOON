import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_11866_요세푸스문제0_S4 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Deque<Integer> heads = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			heads.offerLast(i);
		}
		
		sb.append("<");
		int killSwitch = 0;
		while (heads.size() != 1) {
			if (killSwitch == K-1) {
				sb.append(heads.pollFirst()).append(", ");
			} else {
				heads.offerLast(heads.pollFirst());
			}
			
			killSwitch = (killSwitch + 1) % K;
		}
		
		sb.append(heads.peek()).append(">");
		
		System.out.println(sb);
		
	}
}