import java.io.*;
import java.util.*;

public class Main_2745_진법변환_B2 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String N = st.nextToken();
		int B = Integer.parseInt(st.nextToken());
		
		int result = 0;
		
		int b = 1;
		
		for (int i = N.length()-1; i >= 0; i--) {
			char c = N.charAt(i);
			if ('0' <= c && c <= '9') {
				result += (c-'0')*b;
			} else if ('A' <= c && c <= 'Z') {
				result += (c-'A'+10)*b;
			}
			b *= B;
		}
		
		System.out.println(result);
		
	} // end of main
} // end of class

