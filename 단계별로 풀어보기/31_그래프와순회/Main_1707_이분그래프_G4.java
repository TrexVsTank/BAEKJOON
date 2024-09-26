import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 클래스
public class Main_1707_이분그래프_G4 {
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		// 테케
		for (int t = 0; t < T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N+1];
			for (int i = 0; i < N+1; i++) {
				arr[i] = -1;
			}
			
			boolean[] visited = new boolean[N+1];
			
			List<List<Integer>> list = new ArrayList<>();
			for (int i = 0; i < N+1; i++) {
				list.add(new ArrayList<>());
			}
			for (int i = 0; i < L; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());
				list.get(num1).add(num2);
				list.get(num2).add(num1);
			}
			
			Queue<Integer> queue = new ArrayDeque<>();
			
			String result = "YES";
			
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					queue.offer(i);
					arr[i] = 0;
					visited[i] = true;
					w : while (!queue.isEmpty()) {
						int S = queue.size();
						for (int s = 0; s < S; s++) {
							int q = queue.poll();
							for (int l : list.get(q)) {
								if (arr[l] == arr[q]) {
									result = "NO";
									break w;
								}
								if (visited[l] == false) {
									visited[l] = true;
									arr[l] = (arr[q]+1)%2;
									queue.offer(l);
								}
							}
						}
					}
				}
			}
			
			
			
			
			System.out.println(result);
			
		} // 테케 끝
		
	} // 메인 끝
	
} // 클래스 끝