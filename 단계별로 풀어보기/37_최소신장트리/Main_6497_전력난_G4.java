import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// [클래스] Main
public class Main_6497_전력난_G4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int[] group;
	
	// [메서드] main
	public static void main(String[] args) throws IOException {
		
		String input = br.readLine();
		
		while (!input.equals("0 0")) {
			
			st = new StringTokenizer(input, " ");
			// [N]
			int N = Integer.parseInt(st.nextToken());
			// [M]
			int M = Integer.parseInt(st.nextToken());
			
			// [group]
			group = new int[N];
			for (int i = 0; i < N; i++) {
				group[i] = i;
			}
			
			// [counter]
			int counter = 1;
			
			// [sum]
			long sum = 0;
			
			// [new_sum]
			long new_sum = 0;
			
			// [PQ]
			PriorityQueue<Node> PQ = new PriorityQueue<>();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				long cost = Long.parseLong(st.nextToken());
				sum += cost;
				PQ.offer(new Node(a, b, cost));
			}
			
			while (counter < N) {
				Node curr = PQ.poll();
				int a = curr.from;
				int b = curr.to;
				long dist = curr.dist;
				if (find(a) == find(b)) {
					continue;
				} else {
					union(a, b);
					counter++;
					new_sum += dist;
				}
			}
			
			sb.append(sum-new_sum).append("\n");
			
			input = br.readLine();
		}
		
		//print
		System.out.println(sb);
		
	} // [메서드] main
	
	// [클래스] Node
	private static class Node implements Comparable<Node> {
		int from;
		int to;
		long dist;
		public Node() {
		}
		public Node(int from, int to, long dist) {
			super();
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
		@Override
		public int compareTo(Node o) {
			return (int) (this.dist - o.dist);
		}
	} // [클래스] Node
	
	// [메서드] find
	private static int find(int num) {
		if (group[num] == num) {
			return num;
		}
		return group[num] = find(group[num]);
	} // [메서드] find
	
	// [메서드] union
	private static void union(int a, int b) {
		group[find(b)] = find(a);
	} // [메서드] union
	
} // [클래스] Main
