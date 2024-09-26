import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main_18870_좌표압축_S2 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] listInput = new int[N][3];
		int[] listSort = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			listInput[i][0] = Integer.parseInt(st.nextToken());
			listSort[i] = listInput[i][0];
			listInput[i][2] = i;
		}
		
		// 0. 입력
		
		// 1. 풀이
		
		Arrays.sort(listSort);
		Arrays.sort(listInput, (a, b) -> {
			return a[0] - b[0];
		});
		
		int num1 = 0;
		for (int i = 0; i < N-1; i++) {
			if (listSort[i] != listSort[i+1]) {
				listInput[i][1] = num1;
				num1++;
			} else {
				listInput[i][1] = num1;
			}
		}
		listInput[N-1][1] = num1;
		
		
		Arrays.sort(listInput, (a, b) -> {
			return a[2] - b[2];
		});

		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			sb.append(listInput[i][1] + " ");
		}
		
		System.out.println(sb);
		
		// 1. 풀이
		
	} // end of main
} // end of class
