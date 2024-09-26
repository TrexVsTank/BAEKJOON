import java.io.*;
import java.util.*;

public class Main_2738_행렬덧셈_B3 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arrA = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer stLocal = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arrA[i][j] = Integer.parseInt(stLocal.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			StringTokenizer stLocal = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arrA[i][j] += Integer.parseInt(stLocal.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arrA[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	} // end of main
} // end of class

