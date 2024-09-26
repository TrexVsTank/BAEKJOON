import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1010_다리놓기_S5 {
	public static void main(String[] args) throws IOException {
		
		long[][] combs = new long[30][30];
		for (int i = 0; i < 30; i++) {
			combs[i][0] = i+1;
			combs[i][i] = 1;
		}
		for (int i = 0; i < 30; i++) {
			for (int j = 1; j < i; j++) {
				combs[i][j] = combs[i][j-1] * (i-j+1) / (j+1);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			sb.append(combs[M-1][N-1]).append("\n");
			
		}
		
		System.out.println(sb);
		
//		for (int i = 0; i < 30; i++) {
//			System.out.println(Arrays.toString(combs[i]));
//		}
		
	}
}