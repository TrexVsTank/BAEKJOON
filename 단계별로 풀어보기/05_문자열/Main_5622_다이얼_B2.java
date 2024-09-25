import java.io.*;
import java.util.*;

public class Main_5622_다이얼_B2 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		
		// 0. 입력
		
		// 1. 풀이
		
		int[] arrI = new int[S.length()];
		
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i)-'O' <= 0) {
				arrI[i] = (S.charAt(i)-'A')/3+3;
			} else if (S.charAt(i)-'S' <= 0) {
				arrI[i] = 8;
			} else if (S.charAt(i)-'V' <= 0) {
				arrI[i] = 9;
			} else if (S.charAt(i)-'Z' <= 0) {
				arrI[i] = 10;
			}
		}
		
		int sum = 0;
		
		for (int i = 0; i < S.length(); i++) {
			sum += arrI[i];
		}
		
		System.out.println(sum);
		
		// 1. 풀이
		
	} // end of main
} // end of class

