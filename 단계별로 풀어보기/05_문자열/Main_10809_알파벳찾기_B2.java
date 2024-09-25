import java.io.*;
import java.util.*;

public class Main_10809_알파벳찾기_B2 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		
		// 0. 입력
		
		// 1. 풀이
		
		int[] arr = new int[26];
		for (int i = 0; i < 26; i++) {
			arr[i] = -1;
		}
		
		for (int i = 0; i < S.length(); i++) {
			if (arr[S.charAt(i)-'a'] == -1) {
				arr[S.charAt(i)-'a'] = i;
			}
		}
		
		for (int i = 0; i < 26; i++) {
			System.out.print(arr[i] + " ");
		}
		
		// 1. 풀이
		
	} // end of main
} // end of class

