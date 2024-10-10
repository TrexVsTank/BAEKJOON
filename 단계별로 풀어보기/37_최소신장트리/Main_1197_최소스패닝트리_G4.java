import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// [클래스] Main
public class Main_1197_최소스패닝트리_G4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int[] group;
	static int N;
	
	// [메서드] main
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		
		// [N]
		N = Integer.parseInt(st.nextToken());
		
		// [group]
		group = new int[N+1];
		for (int i = 1; i <= N; i++) {
			group[i] = i;
		}
		
		// [M]
		int M = Integer.parseInt(st.nextToken());
		
		// [counter]
		int counter = 1;
		
		// [sum]
		long sum = 0;
		
		// [PQ]
		PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> {return a[2]-b[2]; });
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			PQ.offer(new int[] {a, b, cost});
		}
		
		while (counter < N) {
			int[] curr = PQ.poll();
			int a = curr[0];
			int b = curr[1];
			int cost = curr[2];
			if (find(a) == find(b)) {
				continue;
			} else {
				union(a, b);
				counter++;
				sum += cost;
			}
		}
		
		System.out.println(sum);
		
	} // [메서드] main
	
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
