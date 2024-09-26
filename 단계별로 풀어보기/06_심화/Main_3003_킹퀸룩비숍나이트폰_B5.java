import java.io.*;
import java.util.*;

public class Main_3003_킹퀸룩비숍나이트폰_B5 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int[] arrCorrect = {1, 1, 2, 2, 2, 8};
		
		int[] arrInput = new int[6];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < 6; i++) {
			arrInput[i] = Integer.parseInt(st.nextToken());
		}
		
		// 0. 입력
		
		// 1. 풀이
		
		for (int i = 0; i < 6; i++) {
			arrInput[i] = arrCorrect[i] - arrInput[i];
		}
		
		for (int i = 0; i < 6; i++) {
			sb.append(arrInput[i]).append(" ");
		}
		
		System.out.println(sb);
		
		// 1. 풀이
		
	} // end of main
} // end of class

