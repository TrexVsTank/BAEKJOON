import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main_2525_오븐시계_B3 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine());
		
		// 0. 입력
		
		// 1. 풀이
		
		M += N;
		
		while ( (!(M < 60) && ( H < 24)) ) {
			if (M >= 60) {
				M -= 60;
				H++;
			}
			
			if (H >= 24) {
				H -= 24;
			}
		}
		
		System.out.println(H + " " + M);
		
		// 1. 풀이
		
	} // end of main
} // end of class
