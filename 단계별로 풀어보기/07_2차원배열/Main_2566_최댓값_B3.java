import java.io.*;
import java.util.*;

public class Main_2566_최댓값_B3 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int[][] board = new int[9][9];
		
		for (int i = 0; i < 9; i++) {
			StringTokenizer stLocal = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(stLocal.nextToken());
			}
		}
		
		int max = board[0][0];
		int row = 1;
		int col = 1;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (max < board[i][j]) {
					max = board[i][j];
					row = i+1;
					col = j+1;
				}
			}
		}
		
		sb.append(max).append("\n").append(row).append(" ").append(col);
		
		System.out.println(sb);
		
	} // end of main
} // end of class

