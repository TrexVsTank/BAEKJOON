import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// [클래스] Main
public class Main_15681_트리와쿼리_G5 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static List<List<Integer>> link;
	static int[] size;
	
	// [메서드] main
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		// [N]
		int N = Integer.parseInt(st.nextToken());
		// [R]
		int R = Integer.parseInt(st.nextToken());
		// [Q]
		int Q = Integer.parseInt(st.nextToken());
		
		// [link]
		link = new ArrayList();
		for (int i = 0; i <= N; i++) {
			link.add(new ArrayList());
		}
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			link.get(a).add(b);
			link.get(b).add(a);
		}
		
		// [size]
		size = new int[N+1];
		Arrays.fill(size, 1);
		
		// makeTree
		makeTree(R, -1);
		
		// QUERY
		for (int i = 0; i < Q; i++) {
			int q = Integer.parseInt(br.readLine());
			sb.append(size[q]).append("\n");
		}
		
		// PRINT
		System.out.println(sb);
		
	} // [메서드] main
	
	// [메서드] makeTree
	static void makeTree(int num, int par) {
		for (int i : link.get(num)) {
			if (i != par) {
				makeTree(i, num);
				size[num] += size[i];
			}
		}
	} // [메서드] makeTree
	
} // [클래스] Main
