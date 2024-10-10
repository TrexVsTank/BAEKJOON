import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// [클래스] Main
public class Main_1774_우주신과의교감_G3 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int[] group;
	
	// [메서드] main
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		
		// [N]
		int N = Integer.parseInt(st.nextToken());
		
		// [M]
		int M = Integer.parseInt(st.nextToken());
		
		// [group]
		group = new int[N+1];
		for (int i = 1; i <= N; i++) {
			group[i] = i;
		}
		
		// [god]
		double[][] god = new double[N+1][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			god[i][0] = Double.parseDouble(st.nextToken());
			god[i][1] = Double.parseDouble(st.nextToken());
		}
		
		// [counter]
		int counter = 1;
		
		// [sum]
		double sum = 0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (find(a) == find(b)) {
				continue;
			} else {
				union(a, b);
				counter++;
			}
		}
		
		// [PQ]
		PriorityQueue<Node> PQ = new PriorityQueue<>();
		for (int s = 1; s <= N-1; s++) {
			for (int e = s+1; e <= N; e++) {
				double dist = Math.sqrt((god[s][0] - god[e][0]) * (god[s][0] - god[e][0]) + (god[s][1] - god[e][1]) * (god[s][1] - god[e][1]));
				PQ.offer(new Node(s, e, dist));
			}
		}
		
		while (counter < N) {
			Node curr = PQ.poll();
			int a = curr.from;
			int b = curr.to;
			double dist = curr.dist;
			if (find(a) == find(b)) {
				continue;
			} else {
				union(a, b);
				counter++;
				sum += dist;
			}
		}
		
		sum = Math.round(sum * 100);
		System.out.printf("%.2f", sum/100);
		
	} // [메서드] main
	
	// [클래스] Node
	private static class Node implements Comparable<Node> {
		int from;
		int to;
		double dist;
		public Node() {
		}
		public Node(int from, int to, double dist) {
			super();
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
		@Override
		public int compareTo(Node o) {
			return (int) (this.dist*10000 - o.dist*10000);
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
