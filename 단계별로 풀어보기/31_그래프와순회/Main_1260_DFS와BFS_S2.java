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
public class Main_1260_DFS와BFS_S2 {
	
	static int N;
	static int M;
	static int R;
	
	static int arr[];
	static List<List<Integer>> list = new ArrayList<>();
	static int visited[];
	static int order;
	static Queue<Integer> queue = new ArrayDeque<>();
	
	static StringBuilder sb = new StringBuilder();
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			list.get(num1).add(num2);
			list.get(num2).add(num1);
		}
		for (int i = 0; i <= N; i++) {
			Collections.sort(list.get(i));
		}
		
		order = 1;
		visited = new int[N+1];
		DFS(R);
		sb.append("\n");
		
		order = 1;
		visited = new int[N+1];
		BFS(R);
		
		System.out.println(sb);
		
	} // 메인 끝
	
	// DFS
	static void DFS(int index) {
		if (visited[index] == 0) {
			sb.append(index).append(" ");
			visited[index] = order++;
		}
		for (int i = 0; i < list.get(index).size(); i++) {
			if (visited[list.get(index).get(i)] == 0) {
				DFS(list.get(index).get(i));
			}
		}
	} // DFS 끝
	
	// BFS
	static void BFS(int index) {
		if (visited[index] == 0) {
			sb.append(index).append(" ");
			visited[index] = order++;
		}
		for (int i = 0; i < list.get(index).size(); i++) {
			if (visited[list.get(index).get(i)] == 0) {
				queue.offer(list.get(index).get(i));
			}
		}
		while (!queue.isEmpty()) {
			BFS(queue.poll());
		}
	} // BFS 끝
	
} // 클래스 끝