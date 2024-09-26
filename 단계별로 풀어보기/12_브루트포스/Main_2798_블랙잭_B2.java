import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2798_블랙잭_B2 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int[] cards = new int[N];
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st2.nextToken());
		}
		// 0. 입력
		
		
		int com = N * (N-1) * (N-2) / 6;
		
		int[] arrPick = new int[com];
		int num1 = 0;
		
		for (int i = N; i >= 3; i--) {
			for (int j = i-1; j >= 2; j--) {
				for (int k = j-1; k >= 1; k--) {
					if (cards[i-1] + cards[j-1] + cards[k-1] <= M) {
						arrPick[num1++] = cards[i-1] + cards[j-1] + cards[k-1];
					}
				}
			}
		}
		
		int result = 0;
		
		for (int i = 0; i < num1; i++) {
			if (result < arrPick[i]) {
				result = arrPick[i];
			}
		}
		
		System.out.println(result);
		
	} // end of main
} // end of class
