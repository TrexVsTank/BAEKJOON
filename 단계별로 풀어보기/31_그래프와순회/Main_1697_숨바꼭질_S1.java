import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 클래스
public class Main_1697_숨바꼭질_S1 {
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean visited[] = new boolean[100001];
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(N);
		visited[N] = true;
		int time = 0;
		w : while (true) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int q = queue.poll();
				if (q == K) {
					break w;
				}
				if (checker(q-1) && !visited[q-1]) {
					visited[q-1] = true;
					queue.offer(q-1);
				}
				if (checker(q+1) && !visited[q+1]) {
					visited[q+1] = true;
					queue.offer(q+1);
				}
				if (checker(q*2) && !visited[q*2]) {
					visited[q*2] = true;
					queue.offer(q*2);
				}
			}
			time++;
		}
		
		System.out.println(time);
		
	} // 메인 끝
	
	// 체커
	static boolean checker(int index) {
		if (0 <= index && index <= 100000) {
			return true;
		}
		return false;
	}
	
} // 클래스 끝