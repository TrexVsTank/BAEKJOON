import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 클래스
public class Main_1504_특정한최단경로_G4 {
	
	static int N;
	static int E;
	
	static List<List<int[]>> list;
	static int[][] dist;
	
	static int start;
	static int end;
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// [입력] 정점 수 2 ~ 800
		N = Integer.parseInt(st.nextToken());
		// [입력] 간선 수 0 ~ 20만
		E = Integer.parseInt(st.nextToken());
		
		// [입력]양방향 간선
		list = new ArrayList<>();
		for (int i = 0; i < N+1; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken()); // 정점1
			int n2 = Integer.parseInt(st.nextToken()); // 정점2
			int n3 = Integer.parseInt(st.nextToken()); // 비용
			list.get(n1).add(new int[] {n2, n3});
			list.get(n2).add(new int[] {n1, n3});
		}
		
		// [입력] 두 경유지
		st = new StringTokenizer(br.readLine(), " ");
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		// 거리 배열
		dist = new int[N+1][N+1];
		for (int i = 0; i < N+1; i++) {
			for (int j = 0; j < N+1; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
			dist[i][i] = 0;
		}
		
		// 겟코스트 ㄱㄱ
		get_cost(1);
		get_cost(v1);
		get_cost(v2);
		
		// 결과 출력
		int result1;
		if (dist[1][v1] == Integer.MAX_VALUE || dist[v1][v2] == Integer.MAX_VALUE || dist[v2][N] == Integer.MAX_VALUE) {
			result1 = -1;
		} else {
			result1 = dist[1][v1] + dist[v1][v2] + dist[v2][N];
		}
		int result2;
		if (dist[1][v2] == Integer.MAX_VALUE || dist[v2][v1] == Integer.MAX_VALUE || dist[v1][N] == Integer.MAX_VALUE) {
			result2 = -1;
		} else {
			result2 = dist[1][v2] + dist[v2][v1] + dist[v1][N];
		}
		System.out.println(Math.min(result1, result2));
		
	} // 메인 끝
	
	// 겟코스트
	static void get_cost(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		
		boolean[] visited = new boolean[N+1];
		
		while (!queue.isEmpty()) {
			int q = queue.poll();
			for (int i = 0; i < list.get(q).size(); i++) {
				int E = list.get(q).get(i)[0];
				int C = list.get(q).get(i)[1];
				if (dist[start][q] + C < dist[start][E]) {
					dist[start][E] = dist[start][q] + C;
					dist[E][start] = dist[start][q] + C;
				}
			}
			visited[q] = true;
			int min_index = 0;
			int min_cost = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && dist[start][i] < min_cost) {
					min_cost = dist[start][i];
					min_index = i;
				}
			}
			if (min_index != 0) {
				queue.offer(min_index);
			}
		}
	} // 겟코스트 끝
	
} // 클래스 끝
