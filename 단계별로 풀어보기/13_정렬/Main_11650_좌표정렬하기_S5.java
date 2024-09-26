import java.io.*;
import java.util.*;

public class Main_11650_좌표정렬하기_S5 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] list = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 0. 입력
		
		// 1. 풀이
		Arrays.sort(list, (a, b) -> {
			if ( a[0] == b[0] ) return a[1] - b[1];
			else return a[0] - b[0];
		});
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(list[i][0] + " " + list[i][1] + "\n");
		}
		System.out.println(sb);
		
		
		// 1. 풀이
		
	} // end of main
} // end of class
