import java.io.*;
import java.util.*;

public class Main_9086_문자열_B5 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		// 0. 입력
		
		// 1. 풀이
		
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i].charAt(0));
			System.out.print(arr[i].charAt(arr[i].length()-1));
			System.out.println();
		}
		
		// 1. 풀이
		
	} // end of main
} // end of class

