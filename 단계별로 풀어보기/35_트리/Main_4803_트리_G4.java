import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// [클래스] Main
public class Main_4803_트리_G4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static boolean visited[];
	static boolean visited2[];
	static boolean notTree;
	static List<List<Integer>> link;
	
	// [메서드] main
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		
		// [testCase]
		int testCase = 1;
		
		// TC
		while (true) {
			
			// [N]
			int N = Integer.parseInt(st.nextToken());
			if (N == 0) {
				break;
			}
			
			// [result]
			int result = 0;
			
			// [visited]
			visited = new boolean[N+1];
			visited2 = new boolean[N+1];
			
			// [M]
			int M = Integer.parseInt(st.nextToken());
			
			// [link]
			link = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				link.add(new ArrayList<>());
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				link.get(a).add(b);
				link.get(b).add(a);
			}
			
			// DFS
			for (int i = 1; i <= N; i++) {
				if (visited[i] == false) {
					notTree = false;
					visited[i] = true;
					DFS(i);
					if (!notTree) {
						result++;
					}
				}
			}
			
			// 어펜드
			switch (result) {
			case 0:
				sb.append("Case " + testCase + ": No trees.").append("\n");
				break;
			case 1:
				sb.append("Case " + testCase + ": There is one tree.").append("\n");
				break;
			default:
				sb.append("Case " + testCase + ": A forest of " + result + " trees.").append("\n");
				break;
			}
			
			// next TC
			testCase++;
			st = new StringTokenizer(br.readLine(), " ");
		} // TC
		
		// 출력
		System.out.println(sb);
		
	} // [메서드] main
	
	// [메서드] DFS
	private static void DFS(int s) {
		for (Integer e : link.get(s)) {
			if (visited[e]) {
				notTree = true;
			}
			if (!visited[e]) {
				visited[e] = true;
				for (int i = 0; i < link.get(e).size(); i++) {
					if (link.get(e).get(i).equals(s)) {
						link.get(e).remove(i);
						break;
					}
				}
				DFS(e);
			}
		}
	} // [메서드] DFS
	
} // [클래스] Main
