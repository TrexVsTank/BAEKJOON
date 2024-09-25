import java.io.*;

public class Main_2439_별찍기2_B4 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < N-i; j++) {
				sb.append(" ");
			}
			for (int j = 0; j < i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}

		System.out.println(sb);
		
		// 0. 입력
		
		// 1. 풀이
		
		
		// 1. 풀이
		
	} // end of main
} // end of class

