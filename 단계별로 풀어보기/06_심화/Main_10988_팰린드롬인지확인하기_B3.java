import java.io.*;
import java.util.*;

public class Main_10988_팰린드롬인지확인하기_B3 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		String myWord = br.readLine().toUpperCase();
		
		// 0. 입력
		
		// 1. 풀이
		
		int[][] alpha = new int[26][2];
		
		for (int i = 0; i < alpha.length; i++) {
			alpha[i][1] = i+65;
		}
		
		for (int i = 0; i < myWord.length(); i++) {
			alpha[myWord.charAt(i)-'A'][0]++;
		}
		
		Arrays.sort(alpha, (a, b) -> {
			return b[0] - a[0];
		});
		
		if (alpha[0][0] == alpha[1][0]) {
			System.out.println("?");
		} else {
			System.out.println((char)alpha[0][1]);
		}
		
		// 1. 풀이
		
	} // end of main
} // end of class

