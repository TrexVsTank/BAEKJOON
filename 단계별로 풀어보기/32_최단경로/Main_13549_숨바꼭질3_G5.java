import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 클래스
public class Main_13549_숨바꼭질3_G5 {
	
	static int length;
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 수빈 0 ~ 10만
		int N = Integer.parseInt(st.nextToken());
		// 동생 0 ~ 10만
		int M = Integer.parseInt(st.nextToken());
		
		if (N == M) {
			System.out.println(0);
			System.exit(0);
		}
		if (N > M) {
			System.out.println(N-M);
			System.exit(0);
		}
		
		// 최소시간배열
		int[] arr = new int[M*2];
		length = arr.length;
		for (int i = 0; i < length; i++) {
			arr[i] = Integer.MAX_VALUE;
		}
		
		// 방문여부배열
		boolean[] visited = new boolean[length];
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(N);
		arr[N] = 0;
		visited[N] = true;
		while (!queue.isEmpty()) {
			int S = queue.size();
			for (int s = 0; s < S; s++) {
				int q = queue.poll();
				int idx = q*2;
				while (idx < length && idx != 0) {
					if (checker(idx) && !visited[idx]) {
						arr[idx] = arr[q];
						visited[idx] = true;
						queue.offer(idx);
					}
					idx *= 2;
				}
				for (int i : new int[] {q-1, q+1}) {
					if (checker(i) && !visited[i]) {
						visited[i] = true;
						arr[i] = arr[q]+1;
						queue.offer(i);
					}
				}
			}
		}
		
		System.out.println(arr[M]);
		
	} // 메인 끝
	
	// 체커
	static boolean checker(int index) {
		return 0 <= index && index < length;
	} // 체커 끝
	
} // 클래스 끝
