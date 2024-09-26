import java.io.*;
import java.util.*;

public class Main_1157_단어공부_B1 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		// 0. 입력
		
		// 1. 풀이
		
		int air = 0;
		
		int star = 0;
		
		for (int i = 1; i <= N; i++) {
			air = N-i;
			for (int j = 0; j < air; j++) {
				sb.append(" ");
			}
			star = i*2-1;
			for (int j = 0; j < star; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		for (int i = N-1; i >= 1; i--) {
			air = N-i;
			for (int j = 0; j < air; j++) {
				sb.append(" ");
			}
			star = i*2-1;
			for (int j = 0; j < star; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		// 1. 풀이
		
	} // end of main
} // end of class

