import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// [클래스] Main
public class Main_1717_집합의표현_G5 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int value[];
	static int arr[];
	
	// [메서드] main
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		
		// [N]
		int N = Integer.parseInt(st.nextToken());
		
		// [arr]
		arr = new int[N+1];
		for (int i = 0; i <= N; i++) {
			arr[i] = i;
		}
		
		// [M]
		int M = Integer.parseInt(st.nextToken());
		
		// order
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			switch (command) {
			case 0:
				union(a, b);
				break;
			default:
				if (find(a) == find(b)) {
					sb.append("YES").append("\n");
				} else {
					sb.append("NO").append("\n");
				}
				break;
			}
		} // order
		
		// 출력
		System.out.println(sb);
		
	} // [메서드] main
	
	// [메서드] find
	private static int find(int num) {
		if (arr[num] == num) {
			return num;
		}
		return arr[num] = find(arr[num]);
	} // [메서드] find
	
	// [메서드] union
	private static void union(int num1, int num2) {
		arr[find(num2)] = find(num1);
	} // [메서드] union
	
} // [클래스] Main
