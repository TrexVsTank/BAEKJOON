import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 클래스
public class Main_9370_미확인도착지_G2 {
	
	static int N;
	static int M;
	static int T;
	static int S;
	static int G;
	static int H;
	
	static int dist[];
	static int ends[];
	static boolean visited[];
	static List<List<int[]>> link;
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// [입력] 테케 수
		int TestCase = Integer.parseInt(br.readLine());
		
		// 테케
		for (int tc = 0; tc < TestCase; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// [입력] 정점수 / 간선수 / 후보지수
			N = Integer.parseInt(st.nextToken()); // 2 ~ 2,000
			M = Integer.parseInt(st.nextToken()); // 1 ~ 50,000
			T = Integer.parseInt(st.nextToken()); // 1 ~ 100
			
			st = new StringTokenizer(br.readLine(), " ");
			// [입력] 출발지 / 경유지1 / 경유지2
			S = Integer.parseInt(st.nextToken()); // 1 ~ N
			G = Integer.parseInt(st.nextToken()); // 1 ~ N
			H = Integer.parseInt(st.nextToken()); // 1 ~ N
			
			// 거리
			dist = new int[N+1];
			Arrays.fill(dist, 100_000_000);
			dist[S] = 0;
			
			// 방문여부
			visited = new boolean[N+1];
			
			// [입력] 링크 : 출발지 -> 도착지, 거리
			link = new ArrayList<>();
			for (int i = 0; i < N+1; i++)
				link.add(new ArrayList<>());
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				if ((a == G && b == H) || (a == H && b == G)) {
					link.get(a).add(new int[] {b, c * 2 - 1});
					link.get(b).add(new int[] {a, c * 2 - 1});
				} else {
					link.get(a).add(new int[] {b, c * 2});
					link.get(b).add(new int[] {a, c * 2});
				}
			}
			
			// [입력] 후보지
			ends = new int[T];
			for (int t = 0; t < T; t++) 
				ends[t] = Integer.parseInt(br.readLine());
			
			// 다익스트라 ㄱㄱ
			dijkstra();
			
			// 어펜드 (홀수인 경우 오름차순)
			Arrays.sort(ends);
			for (int idx : ends) {
				if (dist[idx] % 2 == 1) {
					sb.append(idx).append(" ");
				}
			}
			sb.append("\n");
			
		} // 테케 끝
		
		// 출력
		System.out.println(sb);
		
	} // 메인 끝
	
	// 다익스트라
	static void dijkstra() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(S);
		while (!queue.isEmpty()) {
			int start = queue.poll();
			for (int[] l : link.get(start)) {
				int end = l[0];
				int length = l[1];
				if (!visited[end] && dist[end] > dist[start] + length) {
					dist[end] = dist[start] + length;
				}
			}
			visited[start] = true;
			int min_dist = 100_000_000;
			int min_index = 0;
			for (int idx = 1; idx <= N; idx++) {
				if (!visited[idx] && min_dist > dist[idx]) {
					min_dist = dist[idx];
					min_index = idx;
				}
			}
			if (min_index != 0) {
				queue.offer(min_index);
			}
		}
	} // 다익스트라 끝
	
} // 클래스 끝
