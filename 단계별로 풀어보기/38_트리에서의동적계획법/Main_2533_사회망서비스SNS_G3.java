import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// [클래스] Main
public class Main_2533_사회망서비스SNS_G3 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static List<List<Integer>> link;
	static boolean[] visited;
	static int[][] dp;
	
	// [메서드] main
	public static void main(String[] args) throws IOException {
		
		// [N]
		int N = Integer.parseInt(br.readLine());
		
		// [link]
		link = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			link.add(new ArrayList<>());
		}
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			link.get(a).add(b);
			link.get(b).add(a);
		}
		
		// [visited]
		visited = new boolean[N+1];
		
		// [dp]
		dp = new int[N+1][2];
		
		// RUN
		run(1);
		
		// PRINT
		System.out.println(Math.min(dp[1][0], dp[1][1]));
		
	} // [메서드] main
	
	// [클래스] run
	static void run(int n) {
		visited[n] = true;
		dp[n][0] = 0;
		dp[n][1] = 1;
		for (int l : link.get(n)) {
			if (!visited[l]) {
				run(l);
				dp[n][0] += dp[l][1];
				dp[n][1] += Math.min(dp[l][0], dp[l][1]);
			}
		}
	} // [클래스] run
	
} // [클래스] Main
