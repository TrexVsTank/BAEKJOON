import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// [클래스] Main
public class Main_1976_여행가자_G4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int arr[][];
	static int U[];
	
	// [메서드] main
	public static void main(String[] args) throws IOException {
		
		// [N]
		int N = Integer.parseInt(br.readLine());
		
		// [U]
		U = new int[N+1];
		for (int i = 1; i <= N; i++) {
			U[i] = i;
		}
		
		// [M]
		int M = Integer.parseInt(br.readLine());
		
		arr = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					union(i, j);
				}
			}
		}
		
		String result = "YES";
		
		st = new StringTokenizer(br.readLine());
		int value = find(Integer.parseInt(st.nextToken()));
		
		for (int i = 1; i < M; i++) {
			if (find(Integer.parseInt(st.nextToken())) != value) {
				result = "NO";
				break;
			}
		}
		
		System.out.println(result);
		
	} // [메서드] main
	
	// [메서드] find
	static int find(int num) {
		if (U[num] == num) {
			return num;
		}
		return U[num] = find(U[num]);
	} // [메서드] find
	
	// [메서드] union
	static void union(int num1, int num2) {
		U[find(num2)] = find(num1);
	} // [메서드] union
	
} // [클래스] Main
