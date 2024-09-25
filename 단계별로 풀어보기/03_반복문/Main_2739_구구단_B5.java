import java.io.*;

public class Main_2739_구구단_B5 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 0. 입력
		
		// 1. 풀이
		
		for (int i = 1; i <= 9; i++) {
			System.out.println(N + " * " + i + " = " + N*i);
		}
		
		// 1. 풀이
		
	} // end of main
} // end of class
