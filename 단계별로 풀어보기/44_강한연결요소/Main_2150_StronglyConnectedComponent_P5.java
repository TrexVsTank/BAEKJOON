import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

// [CLASS]
public class Main_2150_StronglyConnectedComponent_P5 {
	
	// [MAIN]
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int M;
	
	static int id;
	static int[] idArray;
	static boolean[] dead;
	static List<Integer>[] link;
	static Stack<Integer> stack;
	
	static int count;
	static List<List<Integer>> group;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		
		id = 0;
		
		idArray = new int[N+1];
		
		dead = new boolean[N+1];
		
		link = new List[N+1];
		for (int i = 0; i <= N; i++) {
			link[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			link[from].add(to);
		}
		for (int i = 0; i <= N; i++) {
			Collections.sort(link[i]);
		}
		
		stack = new Stack<>();
		
		count = 0;
		
		group = new ArrayList<>();
		
		for (int n = 1; n <= N; n++) {
			if (idArray[n] == 0) {
				dfs(n);
			}
		}
		
		for (int i = 0; i < group.size(); i++) {
			Collections.sort(group.get(i));
		}
		Collections.sort(group, (a, b) -> {
			return a.get(0) - b.get(0);
		});
		
		sb.append(count).append("\n");
		for (int i = 0; i < group.size(); i++) {
			for (int j = 0; j < group.get(i).size(); j++) {
				sb.append(group.get(i).get(j)).append(" ");
			}
			sb.append(-1).append("\n");
		}
		
		System.out.println(sb);
		
	} // [MAIN]
	
	// [DFS]
	private static int dfs(int num) {
		idArray[num] = ++id;
		stack.push(num);
		int result = idArray[num];
		for (int next : link[num]) {
			if (idArray[next] == 0) {
				result = Math.min(result, dfs(next));
			} else if (!dead[next]) {
				result = Math.min(result, idArray[next]);
			}
		}
		if (result == idArray[num]) {
			count++;
			group.add(new ArrayList<>());
			while (true) {
				int curr = stack.pop();
				group.get(group.size()-1).add(curr);
				dead[curr] = true;
				if (curr == num) {
					break;
				}
			}
		}
		return result;
	}
	// [DFS]
	
} // [CLASS]
