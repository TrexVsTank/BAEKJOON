import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main_1427_소트인사이드_S5 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		
		// 0. 입력
		
		// 1. 풀이
		
		int[] arrN = new int[N.length()];
		
		for (int i = 0; i < N.length(); i++) {
			arrN[i] = N.charAt(i) - '0';
		}
		
		Arrays.sort(arrN);
		
		for (int i = arrN.length-1; i >= 0; i--) {
			System.out.print(arrN[i]);
		}
		
		// 1. 풀이
		
	} // end of main
} // end of class
