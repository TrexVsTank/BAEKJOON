import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

// [CLASS]
public class Main_4013_ATM_P2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static List<List<Integer>> linkList;
	static int[] moneyArray;
	static int S;
	static int P;
	static boolean[] outbackArray;
	
	static int id;
	static int[] idArray;
	static boolean[] deadArray;
	static int[] sccArray;
	static Stack<Integer> stack;
	
	static List<List<Integer>> sccList;
	static int size;
	static int[] sccMoneyArray;
	static boolean[] sccOutbackArray;
	static List<Set<Integer>> sccLinkList;
	static int[] dp;
	
	// [MAIN]
	public static void main(String[] args) throws IOException {
		
		input();
		
		// TARZAN
		for (int n = 1; n <= N; n++) {
			if (idArray[n] == 0) {
				tarzan(n);
			}
		}
		
		S = sccArray[S];
		
		sccMoneyArray = new int[size+1];
		sccOutbackArray = new boolean[size+1];
		
		for (int n = 1; n <= N; n++) {
			int s = sccArray[n];
			sccMoneyArray[s] += moneyArray[n];
			if (outbackArray[n]) {
				sccOutbackArray[s] = true;
			}
		}
		
		sccLinkList = new ArrayList<>();
		
		for (int s = 0; s <= size; s++) {
			sccLinkList.add(new HashSet<>());
		}
		for (int at = 1; at <= N; at++) {
			int AT = sccArray[at];
			for (int to : linkList.get(at)) {
				int TO = sccArray[to];
				if (AT == TO) {
					continue;
				}
				sccLinkList.get(AT).add(TO);
			}
		}
		
		dp = new int[size+1];
		Arrays.fill(dp, -1);
		
		// PRINT
		System.out.println(atm(S));
		
	} // [MAIN]
	
	// [INPUT]
	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		linkList = new ArrayList<>();
		for (int n = 0; n <= N; n++) {
			linkList.add(new ArrayList<>());
		}
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int at = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			linkList.get(at).add(to);
		}
		
		moneyArray = new int[N+1];
		for (int n = 1; n <= N; n++) {
			moneyArray[n] = Integer.parseInt(br.readLine());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		outbackArray = new boolean[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int p = 0; p < P; p++) {
			int index = Integer.parseInt(st.nextToken());
			outbackArray[index] = true;
		}
		
		id = 0;
		idArray = new int[N+1];
		deadArray = new boolean[N+1];
		sccArray = new int[N+1];
		stack = new Stack<>();
		
		sccList = new ArrayList<>();
		sccList.add(new ArrayList<>());
		size = 0;
	} // [INPUT]
	
	// [TARZAN]
	private static int tarzan(int at) {
		stack.push(at);
		idArray[at] = ++id;
		int result = idArray[at];
		for (int to : linkList.get(at)) {
			if (idArray[to] == 0) {
				result = Math.min(result, tarzan(to));
			} else if (!deadArray[to]) {
				result = Math.min(result, idArray[to]);
			}
		}
		if (result == idArray[at]) {
			size++;
			List<Integer> scc = new ArrayList<>();
			while (true) {
				int curr = stack.pop();
				scc.add(curr);
				idArray[curr] = idArray[at];
				deadArray[curr] = true;
				sccArray[curr] = size;
				if (curr == at) {
					break;
				}
			}
			Collections.sort(scc);
			sccList.add(scc);
		}
		return result;
	} // [TARZAN]
	
	// [ATM]
	private static int atm(int s) {
		if (dp[s] != -1) {
			return dp[s];
		}
		int result = sccMoneyArray[s];
		for (int next : sccLinkList.get(s)) {
			result = Math.max(result, sccMoneyArray[s] + atm(next));
		}
		if (!sccOutbackArray[s] && result == sccMoneyArray[s]) {
			result = 0;
		}
		return dp[s] = result;
	} // [ATM]
	
} // [CLASS]
