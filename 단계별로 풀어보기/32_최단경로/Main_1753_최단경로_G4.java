import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 클래스
public class Main_1753_최단경로_G4 {
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// [입력] 정점 수 2만 이하
		int N = Integer.parseInt(st.nextToken());
		// [입력] 간선 수 30만 이하
		int L = Integer.parseInt(st.nextToken());
		
		// [입력] 출발 좌표
		int start = Integer.parseInt(br.readLine());
		
		// 간선
		List<List<int[]>> list = new ArrayList<>();
		for (int i = 0; i < N+1; i++) {
			list.add(new ArrayList<>());
		}
		// [입력] 간선
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			list.get(S).add(new int[] {E, C});
		}
		
		// 출발지부터 최단거리
		int[] cost = new int[N+1];
		for (int i = 0; i <= N; i++) {
			cost[i] = Integer.MAX_VALUE;
		}
		
		// 방문여부
		boolean[] visited = new boolean[N+1];
		
		// BFS
		Queue<Integer> queue = new ArrayDeque<>();
		cost[start] = 0;
		queue.add(start);
		while (!queue.isEmpty()) {
			int q = queue.poll();
			for (int i = 0; i < list.get(q).size(); i++) { // 출발지의 간선수
				int E = list.get(q).get(i)[0]; // 도착지
				int C = list.get(q).get(i)[1]; // 비용
				if (cost[q] + C < cost[E]) {
					cost[E] = cost[q] + C;
				}
			}
			visited[q] = true;
			
			int min_cost = Integer.MAX_VALUE;
			int min_index = 0;
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && cost[i] < min_cost) {
					min_cost = cost[i];
					min_index = i;
				}
			}
			if (min_index != 0) {
				queue.offer(min_index);
			}
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (cost[i] == Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
				continue;
			}
			sb.append(cost[i]).append("\n");
		}
		System.out.println(sb);
		
	} // 메인 끝
	
} // 클래스 끝