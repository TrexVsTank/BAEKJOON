import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2751_수정렬하기2_S5 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arrN = new int[N];
		
		for (int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(br.readLine());
		}
		
		// 0. 입력
		
		// 1. 풀이
		
		Arrays.sort(arrN);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			sb.append(arrN[i]).append('\n');
		}
		
		System.out.print(sb);
		
		// 1. 풀이
		
	} // end of main
} // end of class
