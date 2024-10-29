import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

// [CLASS]
public class Main_3977_축구전술_P4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int T;
	
	static int N;
	static int M;
	
	static List<List<Integer>> link;
	
	static Stack<Integer> stack;
	static int id;
	static int[] idArray;
	static int[] sccArray;
	static boolean[] dead;
	
	static List<List<Integer>> SCC;
	static int S;
	static List<Set<Integer>> linkAt;
	static List<Set<Integer>> linkTo;
	
	// [MAIN]
	public static void main(String[] args) throws IOException {
		
		T = Integer.parseInt(br.readLine());
		
		// TEST CASE
		for (int t = 0; t < T; t++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			
			M = Integer.parseInt(st.nextToken());
			
			link = new ArrayList<>();
			for (int n = 0; n < N; n++) {
				link.add(new ArrayList<>());
			}
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				int at = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				link.get(at).add(to);
			}
			br.readLine();
			
			stack = new Stack<>();
			
			id = 0;
			
			idArray = new int[N];
			
			dead = new boolean[N];
			
			SCC = new ArrayList<>();
			
			// GET SCC
			for (int n = 0; n < N; n++) {
				if (!dead[n]) {
					getSCC(n);
				}
			}
			
			S = SCC.size();
			
			sccArray = new int[N];
			
			for (int s = 0; s < S; s++) {
				for (int num : SCC.get(s)) {
					sccArray[num] = s;
				}
			}
			
			linkAt = new ArrayList<>();
			
			linkTo = new ArrayList<>();
			
			for (int s = 0; s < S; s++) {
				linkAt.add(new HashSet<>());
				linkTo.add(new HashSet<>());
			}
			
			for (int at = 0; at < N; at++) {
				int AT = sccArray[at];
				for (int to : link.get(at)) {
					int TO = sccArray[to];
					if (AT == TO) {
						continue;
					}
					linkAt.get(TO).add(AT);
					linkTo.get(AT).add(TO);
				}
			}
			
			dead = new boolean[S];
			
			int startSCC = 0;
			
			while (!linkAt.get(startSCC).isEmpty()) {
				for (int next : linkAt.get(startSCC)) {
					startSCC = next;
					break;
				}
			}
			
			// SCC DOMINO
			sccDomino(startSCC);
			
			if (S == 0) {
				Collections.sort(SCC.get(startSCC));
				for (int num : SCC.get(startSCC)) {
					sb.append(num).append("\n");
				}
			} else {
				sb.append("Confused\n");
			}
			sb.append("\n");
			
		} // TEST CASE
		
		// PRINT
		System.out.println(sb);
		
	} // [MAIN]
	
	// [SCC DOMINO]
	private static void sccDomino(int sccNum) {
		S--;
		dead[sccNum] = true;
		for (int next : linkTo.get(sccNum)) {
			if (!dead[next]) {
				sccDomino(next);
			}
		}
	} // [SCC DOMINO]
	
	// [GET SCC]
	private static int getSCC(int at) {
		stack.push(at);
		idArray[at] = ++id;
		int result = idArray[at];
		for (int to : link.get(at)) {
			if (idArray[to] == 0) {
				result = Math.min(result, getSCC(to));
			} else if (!dead[to]) {
				result = Math.min(result, idArray[to]);
			}
		}
		if (result == idArray[at]) {
			List<Integer> scc = new ArrayList<>();
			while (true) {
				int curr = stack.pop();
				dead[curr] = true;
				idArray[curr] = idArray[at];
				scc.add(curr);
				if (curr == at) {
					break;
				}
			}
			SCC.add(scc);
		}
		return result;
	} // [GET SCC]
	
} // [CLASS]
