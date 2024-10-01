import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

// [클래스] 메인
public class Main_11780_플로이드2_G2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int INF = 1_000_000_000;
	
	static int N;
	static List<List<int[]>> bus;
	static int dist[][];
	static int hist[][];
	
	// [메서드] 메인
	public static void main(String[] args) throws IOException {
		
		// 도시의 수 (1 ~ 100)
		N = Integer.parseInt(br.readLine());
		
		// 버스의 수 (1 ~ 100,000)
		int M = Integer.parseInt(br.readLine());
		
		// 노선
		bus = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			bus.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()); // 출발
			int to = Integer.parseInt(st.nextToken()); // 도착
			int cost = Integer.parseInt(st.nextToken()); // 비용 (1 ~ 100,000)
			bus.get(from).add(new int[] {to, cost});
		}
		
		// 거리
		dist = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}
		
		// 기록
		hist = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(hist[i], -1);
		}
		
		// 다익스트라 실행
		for (int i = 1; i <= N; i++) {
			Dijkstra(i);
		}
		
		// 어펜드 (거리배열)
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sb.append(dist[i][j] == INF ? 0 : dist[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		// 어펜드 (역추적)
		for (int s = 1; s <= N; s++) {
			for (int e = 1; e <= N; e++) {
				if (hist[s][e] == -1 || dist[s][e] == INF) {
					sb.append(0);
				} else {
					Stack<Integer> stack = new Stack<>();
					int val = e;
					stack.push(val);
					while (val != s) {
						val = hist[s][val];
						stack.push(val);
					}
					sb.append(stack.size()).append(" ");
					while (!stack.isEmpty()) {
						sb.append(stack.pop()).append(" ");
					}
				}
				sb.append("\n");
			}
		}
		
		// 출력
		System.out.println(sb);
		
	} // [메서드] 메인
	
	// [메서드] 다익스트라
	private static void Dijkstra(int start) {
		boolean[] visited = new boolean[N+1];
		PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> { return a[1] - b[1]; });
		PQ.offer(new int[] {start, 0});
		while (!PQ.isEmpty()) {
			int[] curr = PQ.poll();
			int S = curr[0];
			if (visited[S]) {
				continue;
			}
			visited[S] = true;
			for (int[] i : bus.get(S)) {
				int E = i[0];
				int C = i[1];
				if (dist[start][E] > dist[start][S] + C) {
					dist[start][E] = dist[start][S] + C;
					hist[start][E] = S;
					PQ.offer(new int[] {E, dist[start][E]});
				}
			}
		}
	} // [메서드] 다익스트라
	
} // [클래스] 메인
