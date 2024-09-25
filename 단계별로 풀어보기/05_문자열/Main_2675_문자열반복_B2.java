import java.io.*;
import java.util.*;

public class Main_2675_문자열반복_B2 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arrInt = new int[N];
		String[] arrStr = new String[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arrInt[i] = Integer.parseInt(st.nextToken());
			arrStr[i] = st.nextToken();
		}
		
		// 0. 입력
		
		// 1. 풀이
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < arrStr[i].length(); j++) {
				for (int k = 0; k < arrInt[i]; k++) {
					System.out.print(arrStr[i].charAt(j));
				}
			}
			System.out.println();
		}
		
		// 1. 풀이
		
	} // end of main
} // end of class

