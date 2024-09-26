import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 클래스
public class Main_24444_알고리즘수업너비우선탐색1_S2 {
	
	// 메인
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int M;
	static int R;
	
	static List<List<Integer>> list;
	static Queue<Integer> queue = new ArrayDeque<>();
	static int visited[];
	static int order = 1;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 1 ~ 100,000
		M = Integer.parseInt(st.nextToken()); // 1 ~ 200,000
		R = Integer.parseInt(st.nextToken()); // 1 ~ N
		
		visited = new int[N+1];
		
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int index = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			list.get(index).add(value);
			list.get(value).add(index);
		}
		for (int i = 1; i < N; i++) {
			Collections.sort(list.get(i));
		}
		
		bfs(list, R);
		
		for (int i = 1; i <= N; i++) {
			sb.append(visited[i]).append("\n");
		}
		
		System.out.println(sb);
		
	} // 메인 끝
	
	
	// 넓이우선탐색
	static void bfs(List<List<Integer>> list, int index) {
		if (visited[index] == 0) {
			visited[index] = order++;
		}
		for (int i = 0; i < list.get(index).size(); i++) {
			if (visited[list.get(index).get(i)] == 0) {
				visited[list.get(index).get(i)] = order++;
				queue.offer(list.get(index).get(i));
			}
		}
		while (!queue.isEmpty()) {
			bfs(list, queue.poll());
		}
	} // 넓이우선탐색 끝
	
} // 클래스 끝