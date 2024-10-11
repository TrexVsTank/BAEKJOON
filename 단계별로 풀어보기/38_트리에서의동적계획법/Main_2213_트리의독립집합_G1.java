import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// [클래스] Main
public class Main_2213_트리의독립집합_G1 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static Node[] nodes;
	static boolean[] visited;
	static int[][] dp_Sum;
	static List<Integer>[][] dp_List;
	
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
		
		// [dp_Sum]
		dp_Sum = new int[N+1][2];
		
		// [dp_List]
		dp_List = new List[N+1][2];
		
		// RUN
		run(1);
		
		// APPEND
		if (dp_Sum[1][0] > dp_Sum[1][1]) {
			sb.append(dp_Sum[1][0]).append("\n");
			Collections.sort(dp_List[1][0]);
			for (int i : dp_List[1][0]) {
				sb.append(i).append(" ");
			}
		} else {
			sb.append(dp_Sum[1][1]).append("\n");
			Collections.sort(dp_List[1][1]);
			for (int i : dp_List[1][1]) {
				sb.append(i).append(" ");
			}
		}
		
		// PRINT
		System.out.println(sb);
		
	} // [메서드] main
	
	// [메서드] run
	private static void run(int n) {
		visited[n] = true;
		dp_List[n][0] = new ArrayList<>();
		dp_List[n][1] = new ArrayList<>(); dp_List[n][1].add(n);
		dp_Sum[n][0] = 0;
		dp_Sum[n][1] = nodes[n].weight;
		for (int l : nodes[n].linked) {
			if (!visited[l]) {
				run(l);
				if (dp_Sum[l][0] > dp_Sum[l][1]) {
					dp_Sum[n][0] += dp_Sum[l][0];
					for (int li : dp_List[l][0]) {
						dp_List[n][0].add(li);
					}
				} else {
					dp_Sum[n][0] += dp_Sum[l][1];
					for (int li : dp_List[l][1]) {
						dp_List[n][0].add(li);
					}
				}
				dp_Sum[n][1] += dp_Sum[l][0];
				for (int li : dp_List[l][0]) {
					dp_List[n][1].add(li);
				}
			}
		}
	} // [메서드] run
	
	// [클래스] Node
	private static class Node{
		int weight;
		List<Integer> linked;
		public Node() {}
		public Node(int n) {
			this.weight = n;
			this.linked = new ArrayList();
		}
	} // [클래스] Node
	
} // [클래스] Main
