import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

// [CLASS]
public class Main_16367_TVShowGame_P2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int M;
	
	static List<Set<Integer>> link;
	
	static Stack<Integer> stack;
	static int id;
	static int[] idArray;
	static boolean[] deadArray;
	static int sccCount;
	static int[] sccArray;
	static int[] resultArray;
	
	// [MAIN]
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		link = new ArrayList<>();
		for (int n = 0; n <= N * 2 + 1; n++) {
			link.add(new HashSet<>());
		}
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			if (st.nextToken().equals("R")) a += N;
			int b = Integer.parseInt(st.nextToken());
			if (st.nextToken().equals("R")) b += N;
			int c = Integer.parseInt(st.nextToken());
			if (st.nextToken().equals("R")) c += N;
			link.get(not(a)).add(b);
			link.get(not(a)).add(c);
			link.get(not(b)).add(a);
			link.get(not(b)).add(c);
			link.get(not(c)).add(a);
			link.get(not(c)).add(b);
		}
		
		stack = new Stack<>();
		id = 0;
		idArray = new int[N * 2 + 1];
		deadArray = new boolean[N * 2 + 1];
		sccCount = 0;
		sccArray = new int[N * 2 + 1];
		resultArray = new int[N + 1];
		
		for (int n = 1; n <= N * 2; n++) {
			if (idArray[n] == 0) {
				tarjan(n);
			}
		}
		
		for (int n = 1; n <= N; n++) {
			if (sccArray[n] == sccArray[n + N]) {
				System.out.println(-1);
				System.exit(0);
			}
		}
		for (int n = 1; n <= N; n++) {
			sb.append(sccArray[n] < sccArray[n + N] ? "B" : "R");
		}
		System.out.println(sb);
		
	} // [MAIN]
	
	// [NOT]
	private static int not(int num) {
		return num <= N ? num + N : num - N;
	} // [NOT]
	
	// [TARJAN]
	private static int tarjan(int at) {
		stack.push(at);
		int result = idArray[at] = ++id;
		for (int next : link.get(at)) {
			if (idArray[next] == 0) {
				result = Math.min(result, tarjan(next));
			} else if (!deadArray[next]) {
				result = Math.min(result, idArray[next]);
			}
		}
		if (result == idArray[at]) {
			sccCount++;
			while (!stack.isEmpty()) {
				int curr = stack.pop();
				sccArray[curr] = sccCount;
				deadArray[curr] = true;
				if (curr == at) {
					break;
				}
			}
		}
		return result;
	} // [TARJAN]
	
} // [CLASS]
