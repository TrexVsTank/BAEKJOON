import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_25305_커트라인_B2 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st1.nextToken());
		
		int k = Integer.parseInt(st1.nextToken());
		
		int[] arrX = new int[N];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arrX[i] = Integer.parseInt(st2.nextToken());
		}
		
		// 0. 입력
		
		// 1. 풀이
		
		int num1 = 2;
		
		while (num1 != 0) {
			for (int i = 0; i < N-1; i++) {
				if (arrX[i] < arrX[i+1]) {
					int temp = arrX[i];
					arrX[i] = arrX[i+1];
					arrX[i+1] = temp;
					num1 = 2;
				}
			}
			num1--;
		}
		
		System.out.println(arrX[k-1]);
		
//		System.out.println("----------");
//		System.out.println("N : " + N);
//		System.out.println("k : " + k);
//		System.out.println("-----arrX-----");
//		for (int i : arrX) {
//			System.out.println(i);
//		}
//		System.out.println("----------");
		
		// 1. 풀이
		
	} // end of main
} // end of class
