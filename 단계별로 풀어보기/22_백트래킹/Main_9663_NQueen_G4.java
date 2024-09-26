import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9663_NQueen_G4 {
	
	static int N;
	static int queens[];
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		queens = new int[N];
		nQueen(0);
		System.out.println(count);
	}
	
	static void nQueen(int index) {
		if (index == N) {
			count++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (canSet(index, i)) {
				queens[index] = i;
				nQueen(index+1);
			}
		}
	}
	
	static boolean canSet(int row, int col) {
		for (int i = 0; i < row; i++) {
			if (col == queens[i] || Math.abs(row - i) == Math.abs(col - queens[i])) {
				return false;
			}
		}
		return true;
	}
}