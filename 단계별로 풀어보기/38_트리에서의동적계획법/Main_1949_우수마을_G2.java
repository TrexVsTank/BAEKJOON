import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// [클래스] main
public class Main_1949_우수마을_G2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static Node[] nodes;
	static boolean[] visited;
	static int[][] memo;
	
	// [메서드] main
	public static void main(String[] args) throws IOException {
		
		// [N]
		int N = Integer.parseInt(br.readLine());
		
		// [nodes]
		nodes = new Node[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			nodes[i] = new Node(Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nodes[a].linked.add(b);
			nodes[b].linked.add(a);
		}
		
		// [visited]
		visited = new boolean[N+1];
		
		// [memo]
		memo = new int[N+1][2];
		
		// DFS
		DFS(1, 0);
		
		// PRINT
		System.out.println(Math.max(memo[1][0], memo[1][1]));
		
	} // [메서드] main
	
	// [메서드] DFS
	private static void DFS(int s, int p) {
		visited[s] = true;
		memo[s][0] = 0;
		memo[s][1] = nodes[s].weight;
		for (int e : nodes[s].linked) {
			if (!visited[e]) {
				DFS(e, p);
				memo[s][0] += Math.max(memo[e][0], memo[e][1]);
				memo[s][1] += memo[e][0];
			}
		}
	} // [메서드] DFS
	
	// [클래스] Node
	private static class Node{
		int weight;
		List<Integer> linked;
//		public Node() {}
		public Node(int w) {
			this.weight = w;
			this.linked = new ArrayList<>();
		}
	} // [클래스] Node
	
} // [클래스] main
