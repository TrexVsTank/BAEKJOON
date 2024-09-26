import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1018_체스판다시칠하기_S4 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] chessBoard = new char[N][M];
		
		for (int n = 0; n < N; n++) {
			StringTokenizer stTemp = new StringTokenizer(br.readLine());
			String stringTemp = stTemp.nextToken();
			for (int m = 0; m < M; m++) {
				chessBoard[n][m] = stringTemp.charAt(m);
			}
		}
		
		// 0. 입력
		
		
		int[][] arrPaint = new int [N-7][M-7];
		
		for (int i = 0; i < N-7; i++) {
			for (int j = 0; j < M-7; j++) {
				
				int intTemp1 = 0;
				int intTemp2 = 0;
				
				for (int i2 = 0; i2 < 8; i2++) {
					for (int j2 = 0; j2 < 8; j2++) {
						if ( ( (i2+j2) % 2 == 0 ) && ( chessBoard[i+i2][j+j2] != 'W') ) {
							intTemp1++;
						} else if ( ( (i2+j2) % 2 == 1 ) && ( chessBoard[i+i2][j+j2] != 'B') ) {
							intTemp1++;
						}
					}
				}
				
				for (int i2 = 0; i2 < 8; i2++) {
					for (int j2 = 0; j2 < 8; j2++) {
						if ( ( (i2+j2) % 2 == 0 ) && ( chessBoard[i+i2][j+j2] != 'B') ) {
							intTemp2++;
						} else if ( ( (i2+j2) % 2 == 1 ) && ( chessBoard[i+i2][j+j2] != 'W') ) {
							intTemp2++;
						}
					}
				}
				
				if (intTemp1 < intTemp2) {
					arrPaint[i][j] = intTemp1;
				} else {
					arrPaint[i][j] = intTemp2;
				}
			}
		}
		
		
		int result = 64;
		
		for (int i = 0; i < N-7; i++) {
			for (int j = 0; j < M-7; j++) {
				if (result > arrPaint[i][j]) {
					result = arrPaint[i][j];
				}
			}
		}
		
		System.out.println(result);
		
//		for (int i = 0; i < chessBoard.length; i++) {
//			System.out.println(Arrays.toString(chessBoard[i]));
//		}
//		System.out.println();
//		
//		for (int i = 0; i < arrPaint.length; i++) {
//			System.out.println(Arrays.toString(arrPaint[i]));
//		}
		
	} // end of main
} // end of class
