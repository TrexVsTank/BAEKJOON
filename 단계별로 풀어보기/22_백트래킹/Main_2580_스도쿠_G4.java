import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2580_스도쿠_G4 {
	
	static StringBuilder sb = new StringBuilder();
	static int board[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[9][9];
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sudoku(0, 0);
	}
	
	static void sudoku(int row, int col) {
		if (row == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(board[i][j]).append(" ");
				}
				sb.append("\n");
			}
//			sb.append("\n");
			System.out.println(sb);
			System.exit(0);
			return;
		}
		if (col == 9) {
			sudoku(row+1, 0);
			return;
		}
		if (board[row][col] == 0) {
			for (int i = 0; i < 9; i++) {
				if (canSet(row, col, i+1)) {
					board[row][col] = i+1;
					sudoku(row, col+1);
					board[row][col] = 0;
				}
			}
//			System.out.println("불가능");
			board[row][col] = 0;
			return;
		}
		sudoku(row, col+1);
	}
	
	static boolean canSet(int row, int col, int number) {
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == number) {
				return false;
			}
			if (board[i][col] == number) {
				return false;
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[row/3*3+i][col/3*3+j] == number) {
					return false;
				}
			}
		}
		return true;
	}
	
}