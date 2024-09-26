import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_2587_대표값2_B2 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arrNum = new int[5];
		
		for (int i = 0; i < 5; i++) {
			arrNum[i] = Integer.parseInt(br.readLine());
		}
		
		// 0. 입력
		
		// 1. 풀이
		
		int avg = 0;
		
		for (int i = 0; i < 5; i++) {
			avg += arrNum[i];
		}
		
		avg /= 5;
		
		int counter = 1;
		
		while (counter != 0) {
			for (int i = 0; i < 4; i++) {
				if (arrNum[i] > arrNum[i+1]) {
					int temp = arrNum[i];
					arrNum[i] = arrNum[i+1];
					arrNum[i+1] = temp;
					counter = 2;
				}
			}
			counter--;
		}
		
		System.out.println(avg);
		System.out.println(arrNum[2]);
		
//		for (int i = 0; i < 5; i++) {
//			System.out.println(arrNum[i]);
//		}
		
		// 1. 풀이
		
	} // end of main
} // end of class
