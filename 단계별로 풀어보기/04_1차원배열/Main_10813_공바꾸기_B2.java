import java.io.*;
import java.util.*;

public class Main_10813_공바꾸기_B2 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		
		
		// 0. 입력
		
		// 1. 풀이
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st2.nextToken());
			int n2 = Integer.parseInt(st2.nextToken());
			
			int temp = arr[n1-1];
			arr[n1-1] = arr[n2-1];
			arr[n2-1] = temp;
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
		
		// 1. 풀이
		
	} // end of main
} // end of class

