import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// {클래스} 메인
public class Main_11725_트리의부모찾기_S2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	// {메서드} 메인
	public static void main(String[] args) throws IOException {
		
		// [N] 노드의 수 (2 ~ 100,000)
		int N = Integer.parseInt(br.readLine());
		
		// [parent]
		int[] parent = new int[N+1];
		parent[1] = 1;
		
		// [visited]
		boolean[] visited = new boolean[N+1];
		visited[1] = true;
		
		// [link]
		List<List<Integer>> link = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			link.add(new ArrayList<>());
		}
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			link.get(a).add(b);
			link.get(b).add(a);
		}
		
		// [queue]
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			for (int i : link.get(curr)) {
				if (!visited[i]) {
					visited[i] = true;
					parent[i] = curr;
					queue.offer(i);
				}
			}
		}
		
		// 출력
		for (int i = 2; i <= N; i++) {
			sb.append(parent[i]).append("\n");
		}
		System.out.println(sb);
		
	} // {메서드} 메인
	
} // {클래스} 메인
