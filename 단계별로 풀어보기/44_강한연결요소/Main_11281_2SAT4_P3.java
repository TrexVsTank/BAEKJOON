import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

// [CLASS]
public class Main_11281_2SAT4_P3 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int M;
	
	static List<Set<Integer>> link;
	
	static int id;
	static int[] idArray;
	static boolean[] deadArray;
	static Stack<Integer> stack;
	static int[] resultArray;
	
	static List<List<Integer>> sccList;
	static int sccNum;
	
	// [MAIN]
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		link = new ArrayList<>();
		for (int i = 0; i <= N * 2; i++) {
			link.add(new HashSet<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a < 0) a = -a + N;
			if (b < 0) b = -b + N;
			link.get(fal(a)).add(b);
			link.get(fal(b)).add(a);
		}
		
		id = 0;
		idArray = new int[N * 2 + 1];
		deadArray = new boolean[N * 2 + 1];
		stack = new Stack<>();
		
		sccList = new ArrayList<>();
		sccNum = 0;
		
		for (int i = 1; i <= N * 2; i++) {
			if (idArray[i] == 0) {
				tarjan(i);
			}
		}
		
		resultArray = new int[N + 1];
		Arrays.fill(resultArray, -1);
		
		int ANS = 1;
		for (int i = 1; i <= N; i++) {
			if (idArray[i] == idArray[i + N]) {
				ANS = 0;
				break;
			}
		}
		
		if (ANS == 0) {
			System.out.println(0);
		} else {
			sb.append(1).append("\n");
			for (int i = sccNum-1; i >= 0; i--) {
				for (int var : sccList.get(i)) {
					int realVar = var > N ? var - N : var;
					if (resultArray[realVar] == -1) {
						resultArray[realVar] = var > N ? 1 : 0;
					}
				}
			}
			for (int i = 1; i <= N; i++) {
				sb.append(resultArray[i]).append(" ");
			}
			System.out.println(sb);
		}
		
	} // [MAIN]
	
	// [TARJAN]
	private static int tarjan(int at) {
		stack.push(at);
		idArray[at] = ++id;
		int result = idArray[at];
		for (int to : link.get(at)) {
			if (idArray[to] == 0) {
				result = Math.min(result, tarjan(to));
			} else if (!deadArray[to]) {
				result = Math.min(result, idArray[to]);
			}
		}
		if (result == idArray[at]) {
			List<Integer> scc = new ArrayList<>();
			sccNum++;
			while (true) {
				int curr = stack.pop();
				idArray[curr] = idArray[at];
				deadArray[curr] = true;
				scc.add(curr);
				if (curr == at) {
					break;
				}
			}
			sccList.add(scc);
		}
		return result;
	} // [TARJAN]
	
	// [FAL]
	private static int fal(int num) {
		return num > N ? num - N : num + N;
	} // [FAL]
	
} // [CLASS]
