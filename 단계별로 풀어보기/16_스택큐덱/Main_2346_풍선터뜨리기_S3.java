import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_2346_풍선터뜨리기_S3 {
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<int[]> russian = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int[] man = {i+1, Integer.parseInt(st.nextToken())};
			russian.offerLast(man);
		}
		// 입력
		
		// 처형
		while (russian.size() != 1) {
			int nextTarget = russian.peekFirst()[1];
			sb.append(russian.pollFirst()[0]).append(" ");
			// 양수시체
			if (0 < nextTarget) {
				for (int i = 0; i < nextTarget-1; i++) {
					russian.offerLast(russian.pollFirst());
				}
			// 음수시체
			} else {
				for (int i = 0; i > nextTarget; i--) {
					russian.offerFirst(russian.pollLast());
				}
			}
		}
		sb.append(russian.poll()[0]);
		
		// 출력
		System.out.println(sb);
	}
}