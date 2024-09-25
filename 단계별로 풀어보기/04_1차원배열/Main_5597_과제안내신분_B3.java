import java.io.*;
import java.util.*;

public class Main_5597_과제안내신분_B3 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 30;
		int M = 28;
		
		int[] arr = new int[N];
		
		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(br.readLine());
			arr[temp-1] = 1;
		}
		
		// 0. 입력
		
		// 1. 풀이
		
		
		for (int i = 0; i < N; i++) {
			if (arr[i] == 0) {
				System.out.println(i+1);
			}
		}
		
		// 1. 풀이
		
	} // end of main
} // end of class

