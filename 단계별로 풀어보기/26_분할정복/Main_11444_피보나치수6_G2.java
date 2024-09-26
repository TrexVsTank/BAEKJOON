import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11444_피보나치수6_G2 {
	
	static int N;
	
	static long div = 1000000007;
	
	// main
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = 2;
		long B = Long.parseLong(br.readLine());
		
		long[][] A = new long[][] {{1, 1}, {1, 0}};
		
		long[][] result = mat_mul(A, B);
		
		System.out.println(result[0][1]);
		
	}
	
	// mat_mul
	static long[][] mat_mul(long[][] matrix, long num) {
		
		if (num == 1) {
			return matrix;
		}
		
		if (num % 2 == 0) {
			long[][] new_mat = mat_mul(matrix, num/2);
			return mat_mul(new_mat, new_mat);
		}
		
		return mat_mul(mat_mul(matrix, num-1), matrix);
	}
	
	// mat_mul
	static long[][] mat_mul(long[][] matrix1, long[][] matrix2) {
		
		long[][] res = new long[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					res[i][j] += (matrix1[i][k] * matrix2[k][j]) % div;
				}
				res[i][j] %= div;
			}
		}
		return res;
		
	}
	
}