import java.io.*;
import java.util.*;

public class Main_11720_숫자의합_B4 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String S = br.readLine();
		
		// 0. 입력
		
		// 1. 풀이
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = S.charAt(i) - '0';
		}
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];
		}
		
		System.out.println(sum);
		
		// 1. 풀이
		
	} // end of main
} // end of class

