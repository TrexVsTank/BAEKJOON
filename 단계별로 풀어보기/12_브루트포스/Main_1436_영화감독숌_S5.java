import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1436_영화감독숌_S5 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 0. 입력
		
		// 1. 풀이
		
		int num = 665;
		
		int numCount = 0;
		
		int[] cursedNum = new int[N];
		
		while (numCount != N) {
			
			num++;
			
			String str = Integer.toString(num);
			
			
			for (int i = 0; i < str.length()-2; i++) {
				if ((str.charAt(i) == '6') && (str.charAt(i+1) == '6') && (str.charAt(i+2) == '6')) {
					cursedNum[numCount++] = num;
					break;
				}
			}
			
		}
		numCount--;
		
		System.out.println(cursedNum[numCount]);
		// 1. 풀이
		
		
	} // end of main
} // end of class
