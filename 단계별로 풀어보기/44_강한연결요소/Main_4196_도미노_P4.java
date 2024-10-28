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
public class Main_4196_도미노_P4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int T;
	static int N;
	static int M;
	
	static int id;
	static int[] idArray;
	static boolean[] dead;
	static List<List<Integer>> link;
	static Stack<Integer> stack;
	static List<List<Integer>> SCC;
	
	static int S;
	static int[] sccArray;
	static List<Set<Integer>> sccLinkAt;
	static List<Set<Integer>> sccLinkTo;
	
	static int count;
	static boolean[] deadSCC;
	
	// [MAIN]
	public static void main(String[] args) throws IOException {
		
		T = Integer.parseInt(br.readLine());
		
		// TEST CASE
		for (int t = 0; t < T; t++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			
			M = Integer.parseInt(st.nextToken());
			
			id = 0;
			
			idArray = new int[N+1];
			
			dead = new boolean[N+1];
			
			link = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				link.add(new ArrayList<>());
			}
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				int at = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				link.get(at).add(to);
			}
			
			stack = new Stack<>();
			
			SCC = new ArrayList<>();
			
			// DO TARJAN SCC DFS
			for (int n = 1; n <= N; n++) {
				if (idArray[n] == 0) {
					tarjan(n);
				}
			}
			
			S = SCC.size();
			
			sccArray = new int[N+1];
			for (int s = 0; s < S; s++) {
				for (int n : SCC.get(s)) {
					sccArray[n] = s+1;
				}
			}
			
			sccLinkAt = new ArrayList<>();
			
			sccLinkTo = new ArrayList<>();
			
			for (int s = 0; s <= S; s++) {
				sccLinkAt.add(new HashSet<>());
				sccLinkTo.add(new HashSet<>());
			}
			for (int at = 1; at <= N; at++) {
				for (int to : link.get(at)) {
					if (sccArray[at] != sccArray[to]) {
						sccLinkAt.get(sccArray[to]).add(sccArray[at]);
						sccLinkTo.get(sccArray[at]).add(sccArray[to]);
					}
				}
			}
			
			deadSCC = new boolean[S+1];
			
			count = 0;
			
			for (int s = 1; s <= S; s++) {
				if (!deadSCC[s]) {
					int start = s;
					while (!sccLinkAt.get(start).isEmpty()) {
						for (int i : sccLinkAt.get(start)) {
							start = i;
							break;
						}
					}
					domino(start);
					count++;
				}
			}
			
			sb.append(count).append("\n");
			
		} // TEST CASE
		
		// PRINT
		System.out.println(sb);
		
	} // [MAIN]
	
	// [DOMINO]
	private static void domino(int s) {
		deadSCC[s] = true;
		for (int to : sccLinkTo.get(s)) {
			if (!deadSCC[to]) {
				domino(to);
			}
		}
	} // [DOMINO]
	
	// [tarjanSCC]
	private static int tarjan(int at) {
		stack.push(at);
		idArray[at] = ++id;
		int result = idArray[at];
		for (int to : link.get(at)) {
			if (idArray[to] == 0) {
				result = Math.min(result, tarjan(to));
			} else if (!dead[to]) {
				result = Math.min(result, idArray[to]);
			}
		}
		if (result == idArray[at]) {
			List<Integer> list = new ArrayList<>();
			while (true) {
				int curr = stack.pop();
				dead[curr] = true;
				idArray[curr] = idArray[at];
				list.add(curr);
				if (curr == at) {
					break;
				}
			}
			SCC.add(list);
		}
		return result;
	} // [tarjanSCC]
	
} // [CLASS]
