import java.io.*;
import java.util.*;

public class Main_10798_세로읽기_B1 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		String[] board = new String[5];
		
		for (int i = 0; i < 5; i++) {
			board[i] = br.readLine();
		}
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if (i < board[j].length()) {
					sb.append(board[j].charAt(i));
				}
			}
		}
		
		System.out.println(sb);
		
	} // end of main
} // end of class

