import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_25682_체스판다시칠하기2_G4 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			String input = br.readLine();
			for (int j = 1; j <= M; j++) {
				if ((i+j) % 2 == 0) {
					int a = input.charAt(j-1)=='W' ? 0 : 1;
					A[i][j] = A[i][j-1] + A[i-1][j] - A[i-1][j-1] + a;
				} else {
					int a = input.charAt(j-1)=='B' ? 0 : 1;
					A[i][j] = A[i][j-1] + A[i-1][j] - A[i-1][j-1] + a;
				}
				
			}
		}
		
//		for (int i = 0; i <= N; i++) {
//			System.out.println(Arrays.toString(A[i]));
//		}
		
		int min = Integer.MAX_VALUE;
		
		for (int i = K; i <= N; i++) {
			for (int j = K; j <= M; j++) {
				int w = A[i][j]-A[i][j-K]-A[i-K][j]+A[i-K][j-K];
				w = Math.min(Math.abs(K*K-w), w);
//				System.out.println(w);
				if (w < min) {
					min = w;
				}
			}
		}
		
		System.out.println(min);
		
	}
}