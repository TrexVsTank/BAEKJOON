import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main_10815_숫자카드_S5 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer stN = new StringTokenizer(br.readLine());
		int[] arrN = new int[N];
		for (int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(stN.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		
		StringTokenizer stM = new StringTokenizer(br.readLine());
		int[][] arrM = new int[M][3];
		for (int i = 0; i < M; i++) {
			arrM[i][0] = Integer.parseInt(stM.nextToken());
			arrM[i][2] = i;
		}
		
		// 0. 입력
		
		// 1. 풀이
		
		Arrays.sort(arrM, (a, b) -> {
			return a[0] - b[0];
		});
		Arrays.sort(arrN);
		
		int min = arrN[0];
		if (arrN[0] > arrM[0][0]) {
			min = arrM[0][0];
		}
		int max = arrN[N-1];
		if (arrN[N-1] < arrM[M-1][0]) {
			max = arrM[M-1][0];
		}
		
		int checker = min;
		int corM = 0;
		int corN = 0;
		while ((corM < M) && (corN < N)) {
			if(arrN[corN] == arrM[corM][0]) {
				arrM[corM][1] = 1;
				corN++;
				corM++;
			} else if (arrN[corN] > arrM[corM][0]) {
				corM++;
			} else {
				corN++;
			}
		}
		
		Arrays.sort(arrM, (a, b) -> {
			return a[2] - b[2];
		});
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			sb.append(arrM[i][1] + " ");
		}
		System.out.println(sb);
		
//		System.out.println(Arrays.toString(arrN));
//		System.out.println(Arrays.deepToString(arrM));
		
		// 1. 풀이
		
	} // end of main
} // end of class
