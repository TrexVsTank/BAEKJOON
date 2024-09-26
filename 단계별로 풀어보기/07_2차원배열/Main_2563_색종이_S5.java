import java.io.*;
import java.util.*;

public class Main_2563_색종이_S5 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		int[][] board = new int[100][100];
		
		for (int n = 0; n < N; n++) {
			StringTokenizer stLocal = new StringTokenizer(br.readLine(), " ");
			int left = Integer.parseInt(stLocal.nextToken());
			int under = Integer.parseInt(stLocal.nextToken());
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					board[99-under-i][left+j] = 1;
				}
			}
		}
		
		int result = 0;
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				result += board[i][j];
			}
		}
		
		System.out.println(result);
		
	} // end of main
} // end of class

