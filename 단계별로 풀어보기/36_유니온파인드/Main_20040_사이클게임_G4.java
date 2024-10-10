import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [클래스] Main
public class Main_20040_사이클게임_G4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int group[];
	
	// [메서드] main
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		
		// [N]
		int N = Integer.parseInt(st.nextToken());
		
		// [group]
		group = new int[N];
		for (int i = 0; i < N; i++) {
			group[i] = i;
		}
		
		// [M]
		int M = Integer.parseInt(st.nextToken());
		
		// [result]
		int result = 0;
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (!union(a, b)) {
				result = i;
				break;
			}
		}
		
		// print
		System.out.println(result);
		
	} // [메서드] main
	
	// [메서드] find
	static int find(int num) {
		if (group[num] == num) {
			return num;
		}
		return group[num] = find(group[num]);
	} // [메서드] find
	
	// [메서드] union
	static boolean union(int a, int b) {
		if (find(a) == find(b)) {
			return false;
		}
		group[find(b)] = find(a);
		return true;
	} // [메서드] union
	
} // [클래스] Main
