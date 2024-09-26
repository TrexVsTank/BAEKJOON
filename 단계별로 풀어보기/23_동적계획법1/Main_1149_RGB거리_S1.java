import java.io.*;
import java.util.*;

public class Main_1149_RGB거리_S1 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arrPrice = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arrPrice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 0. 입력
		
		// 1. 풀이
		
		int[][] arrPaid = new int[N][3];
		
		for (int i = 0; i < 3; i++) {
			arrPaid[0][i] = arrPrice[0][i];
		}
		
		int min = 1000001;
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					if (min > arrPaid[i-1][k] && k != j) {
						min = arrPaid[i-1][k];
					}
				}
				arrPaid[i][j] = min + arrPrice[i][j];
				min = 1000001;
			}
		}
		
		int result = arrPaid[N-1][2];
		
		for (int i = 0; i < 2; i++) {
			if (result > arrPaid[N-1][i]) {
				result = arrPaid[N-1][i];
			}
		}
		
		System.out.println(result);
		
		// 1. 풀이
		
	} // end of main
} // end of class

