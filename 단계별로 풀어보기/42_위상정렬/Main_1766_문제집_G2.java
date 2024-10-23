import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// [CLASS]
public class Main_1766_문제집_G2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int M;
	
	static int[] defNum;
	static List<Integer>[] conn;
	
	// [MAIN]
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		defNum = new int[N + 1];
		conn = new List[N + 1];
		for (int n = 1; n <= N; n++) {
			conn[n] = new ArrayList<>();
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int prev = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			defNum[next]++;
			conn[prev].add(next);
		}
		
		topologySort();
		
		System.out.println(sb);
		
	} // [MAIN]
	
	// [TOPOLOGY SORT]
	private static void topologySort() {
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();
		for (int n = 1; n <= N; n++) {
			if (defNum[n] == 0) {
				pQueue.offer(n);
			}
		}
		while (!pQueue.isEmpty()) {
			int curr = pQueue.poll();
			for (int c : conn[curr]) {
				defNum[c]--;
				if (defNum[c] == 0) {
					pQueue.offer(c);
				}
			}
			sb.append(curr).append(" ");
		}
	} // [TOPOLOGY SORT]
	
} // [CLASS]
