import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// class
public class Main_9184_신나는함수실행_S4 {
	
	static int arr[][][];
	
	// main
	public static void main(String[] args) throws IOException {
		
		arr = new int[51][51][51];
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st1 = new StringTokenizer(input, " ");
		int a = Integer.parseInt(st1.nextToken());
		int b = Integer.parseInt(st1.nextToken());
		int c = Integer.parseInt(st1.nextToken());
		while (a != -1 || b != -1 || c != -1) {
			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(W(a, b, c)).append("\n");
			input = br.readLine();
			StringTokenizer st = new StringTokenizer(input, " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
//			System.out.println(sb);
		}
		
		System.out.println(sb);
		
	} // end of main
	
	// W
	static int W(int a, int b, int c) {
		if (a < 0 || b < 0 || c < 0) {
			return 1;
		}
		if (arr[a][b][c] != 0) {
			return arr[a][b][c];
		} else {
			if (a <= 0 || b <= 0 || c <= 0) {
				arr[0][0][0] = 1;
				return arr[0][0][0];
			} else if (a > 20 || b > 20 || c > 20) {
				arr[a][b][c] = W(20, 20, 20);
				return W(20, 20, 20);
			} else if (a < b && b < c) {
				arr[a][b][c] = W(a, b, c-1) + W(a, b-1, c-1) - W(a, b-1, c);
				return W(a, b, c-1) + W(a, b-1, c-1) - W(a, b-1, c);
			} else {
				arr[a][b][c] = W(a-1, b, c) + W(a-1, b-1, c) + W(a-1, b, c-1) - W(a-1, b-1, c-1);
				return W(a-1, b, c) + W(a-1, b-1, c) + W(a-1, b, c-1) - W(a-1, b-1, c-1);
			}
		}
	} // end of W
	
} // end of class