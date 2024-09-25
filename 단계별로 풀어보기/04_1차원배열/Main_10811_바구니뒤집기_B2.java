import java.io.*;
import java.util.*;

public class Main_10811_바구니뒤집기_B2 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st2.nextToken());
			int n2 = Integer.parseInt(st2.nextToken());
			
			int[] arr2 = new int[n2-n1+1];
			
			for (int j = 0; j < arr2.length; j++) {
				arr2[j] = arr[j+n1-1];
			}
			for (int j = arr2.length-1; j >= 0; j--) {
				arr[n1-1+arr2.length-1-j] = arr2[j];
			}
		}
		
		// 0. 입력
		
		// 1. 풀이
		
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
		
		// 1. 풀이
		
	} // end of main
} // end of class

