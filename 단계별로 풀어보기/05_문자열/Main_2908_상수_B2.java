import java.io.*;
import java.util.*;

public class Main_2908_상수_B2 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String S1 = st.nextToken();
		String S2 = st.nextToken();
		
		// 0. 입력
		
		// 1. 풀이
		
		char[] s1 = S1.toCharArray();
		char[] s2 = S2.toCharArray();
		
		int n1 = 0;
		int n2 = 0;
		
		for (int i = 0; i < s1.length; i++) {
			n1 += (s1[i]-'0')*Math.pow(10, i);
		}
		for (int i = 0; i < s2.length; i++) {
			n2 += (s2[i]-'0')*Math.pow(10, i);
		}
		
		int max = n1;
		if (max < n2) {
			max = n2;
		}
		System.out.println(max);
		
		// 1. 풀이
		
	} // end of main
} // end of class

