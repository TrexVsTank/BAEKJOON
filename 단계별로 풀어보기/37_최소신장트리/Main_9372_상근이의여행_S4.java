import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [클래스] Main
public class Main_9372_상근이의여행_S4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	// [메서드] main
	public static void main(String[] args) throws IOException {
		
		// [T]
		int T = Integer.parseInt(br.readLine());
		
		// (TestCase)
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			// [N]
			int N = Integer.parseInt(st.nextToken());
			
			// [M]
			int M = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
			}
			
			sb.append(N-1).append("\n");
			
		} // (TestCase)
		
		// print
		System.out.println(sb);
		
	} // [메서드] main
	
} // [클래스] Main
