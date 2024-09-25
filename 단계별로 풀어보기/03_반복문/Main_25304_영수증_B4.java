import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main_25304_영수증_B4 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());

		int N = Integer.parseInt(br.readLine());

		int total = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			total += a*b;
		}
		
		// 0. 입력
		
		// 1. 풀이
		
		if (total == X) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		
		// 1. 풀이
		
	} // end of main
} // end of class

