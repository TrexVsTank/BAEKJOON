import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main_2480_주사위세개_B4 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		
		int B = Integer.parseInt(st.nextToken());
		
		int C = Integer.parseInt(st.nextToken());
		
		// 0. 입력
		
		// 1. 풀이
		
//		같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
//		같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
//		모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.
		int money = 0;
		
		if ((A == B) && (B == C)) {
			money = 10000+A*1000;
		} else if ( (A != B) && (A != C) && (B != C) ) {
			int max = A;
			if (max < B) {
				max = B;
			}
			if (max < C) {
				max = C;
			}
			money = max*100;
		} else {
			if (A==B) {
				money = 1000+A*100;
			} else if (A==C) {
				money = 1000+A*100;
			} else {
				money = 1000+B*100;
			}
		}
		
		System.out.println(money);
		
		// 1. 풀이
		
	} // end of main
} // end of class
