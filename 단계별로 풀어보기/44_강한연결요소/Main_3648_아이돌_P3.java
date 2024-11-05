import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

// [CLASS]
public class Main_3648_아이돌_P3 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String firstInput;
	
	static int N;
	static int M;
	
	static List<List<Integer>> link;
	
	static Stack<Integer> stack;
	static int id;
	static int[] idArray;
	static boolean[] deadArray;
	static int sccCount;
	static int[] sccArray;
	static List<List<Integer>> sccList;
	
	static int[] resultArray;
	
	// [MAIN]
	public static void main(String[] args) throws IOException {
		
		firstInput = br.readLine();
		
		
		while (firstInput != null && !firstInput.equals("")) {
			
			// input
			st = new StringTokenizer(firstInput, " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			// input & connect link
			link = new ArrayList<>();
			for (int n = 0; n <= N * 2; n++)
				link.add(new ArrayList<>());
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = converted(Integer.parseInt(st.nextToken()));
				int b = converted(Integer.parseInt(st.nextToken()));
				link.get(not(a)).add(b);
				link.get(not(b)).add(a);
			}
			
			// set for TARJAN
			stack = new Stack<>();
			id = 0;
			idArray = new int[N * 2 + 1];
			deadArray = new boolean[N * 2 + 1];
			sccCount = 0;
			sccArray = new int[N * 2 + 1];
			sccList = new ArrayList<>();
			
			// get SCC
			for (int i = 1; i <= N * 2; i++) {
				if (idArray[i] == 0) {
					tarjan(i);
				}
			}
			
			// get result & append
			String result = "yes\n";
			for (int n = 1; n <= N; n++) {
				if (sccArray[n] == sccArray[n + N]) {
					result = "no\n";
				}
			}
			if (result.equals("no\n")) {
				sb.append(result);
			} else {
				resultArray = new int[N + 1];
				Arrays.fill(resultArray, -1);
				if (sccArray[1] > sccArray[1 + N]) {
					result = "no\n";
				}
				sb.append(result);
			}
			
			firstInput = br.readLine();
		}
		
		// print
		System.out.println(sb);
		
	} // [MAIN]
	
	// [CONVERTED]
	private static int converted (int num) {
		return 0 < num ? num : -num + N;
	} // [CONVERTED]
	
	// [NOT]
	private static int not(int num) {
		return num <= N ? num + N : num - N;
	} // [NOT]
	
	// [TARJAN]
	private static int tarjan(int at) {
		stack.push(at);
		int result = idArray[at] = ++id;
		// go go next
		for (int to : link.get(at)) {
			if (idArray[to] == 0) {
				result = Math.min(result, tarjan(to));
			} else if (!deadArray[to]) {
				result = Math.min(result, idArray[to]);
			}
		}
		// pop pop
		if (result == idArray[at]) {
			sccCount++;
			List<Integer> scc = new ArrayList<>();
			while (!stack.isEmpty()) {
				int curr = stack.pop();
				deadArray[curr] = true;
				sccArray[curr] = sccCount;
				scc.add(curr);
				if (curr == at) {
					break;
				}
			}
			sccList.add(scc);
		}
		return result;
	} // [TARJAN]
	
} // [CLASS]
