import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_2750_수정렬하기_B2 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		int[] arrNum = new int[N];
		
		for (int i = 0; i < N; i++) {
			arrNum[i] = Integer.parseInt(br.readLine());
		}
		
		// 0. 입력
		
		// 1. 풀이
		
		int counter = 1;
		while (counter != 0) {
			for (int i = 0; i < N-1; i++) {
				if (arrNum[i] > arrNum[i+1]) {
					int temp = arrNum[i];
					arrNum[i] = arrNum[i+1];
					arrNum[i+1] = temp;
					counter = 2;
				}
			}
			counter--;
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(arrNum[i]);
		}
		
		// 1. 풀이
		
	} // end of main
} // end of class
