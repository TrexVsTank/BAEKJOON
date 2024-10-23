import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// [CLASS]
public class Main_3665_최종순위_G1 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int T;
	static int N;
	static int M;
	static Set<Integer>[] conn;
	static int[] defNum;
	static List<Integer> prev;
	static int[] lastYear;
	
	static int count;
	static String result;
	static Queue<Integer> queue;
	static boolean checker;
	
	// [MAIN]
	public static void main(String[] args) throws IOException {
		
		T = Integer.parseInt(br.readLine());
		
		// [TEST CASE]
		for (int tc = 0; tc < T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			
			conn = new Set[N + 1];
			for (int i = 1; i <= N; i++) {
				conn[i] = new HashSet<>();
			}
			
			defNum = new int[N+1];
			prev = new ArrayList<>();
			lastYear = new int[N+1];
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int n = 1; n <= N; n++) {
				int curr = Integer.parseInt(st.nextToken());
				lastYear[curr] = n;
				for (int p : prev) {
					conn[p].add(curr);
					defNum[curr]++;
				}
				prev.add(curr);
			}
			
			M = Integer.parseInt(br.readLine());
			
			if (M != 0) {
				for (int m = 0; m < M; m++) {
					st = new StringTokenizer(br.readLine(), " ");
					int prev = Integer.parseInt(st.nextToken());
					int next = Integer.parseInt(st.nextToken());
					if (lastYear[prev] < lastYear[next]) {
						int temp = prev;
						prev = next;
						next = temp;
					}
					conn[next].remove(prev);
					conn[prev].add(next);
					defNum[prev]--;
					defNum[next]++;
				}
			}
			
			sb.append(topologySort());
			
		} // [TEST CASE]
		
		System.out.println(sb);
		
	} // [MAIN]
	
	// [TOPOLOGY SORT]
	private static String topologySort() {
		checker = true;
		count = N;
		result = "";
		queue = new ArrayDeque<>();
		for (int n = 1; n <= N; n++) {
			if (defNum[n] == 0) {
				queue.offer(n);
			}
		}
		if (queue.size() != 1) {
			checker = false;
		}
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			if (!queue.isEmpty()) {
				checker = false;
			}
			count--;
			for (int c : conn[curr]) {
				defNum[c]--;
				if (defNum[c] == 0) {
					queue.offer(c);
				}
			}
			result += curr + " ";
		}
		if (!checker) {
			result = "?";
		}
		if (count != 0) {
			result = "IMPOSSIBLE";
		}
		result += "\n";
		return result;
	} // [TOPOLOGY SORT]
	
} // [CLASS]
