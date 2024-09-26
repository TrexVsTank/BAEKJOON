import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2447_별찍기10_G5 {
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][N];
		
		int[][] result = starPainter(N);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (result[i][j] == 1) {
					sb.append("*");
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static int[][] starPainter(int num) {
		if (num == 3) {
			int[][] res = new int[3][3];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i != 1 || j != 1) {
						res[i][j] = 1;
					}
				}
			}
			return res;
		}
		
		int[][] res = new int[num][num];
		int[][] temp = starPainter(num/3);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int row = 0; row < num/3; row++) {
					for (int col = 0; col < num/3; col++) {
						if (i != 1 || j != 1) {
							res[i*num/3+row][j*num/3+col] = temp[row][col];
						}
					}
				}
			}
		}
		return res;
		
	}
	
}