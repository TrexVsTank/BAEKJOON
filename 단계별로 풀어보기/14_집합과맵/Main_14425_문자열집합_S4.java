import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main_14425_문자열집합_S4 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(st.nextToken());
		
		String[] arrN = new String[N];
		for (int i = 0; i < N; i++) {
			arrN[i] = br.readLine();
		}
		
//		List<String> alN = new ArrayList<>();
//		for (int i = 0; i < N; i++) {
//			if (arrN[i].contains("s")) {
//				alN.add(arrN[i]);
//			}
//		}
		
		String[] arrM = new String[M];
		for (int i = 0; i < M; i++) {
			arrM[i] = br.readLine();
		}
		
		// 0. 입력
		
		// 1. 풀이
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arrN[i].equals(arrM[j])) {
					result++;
				}
			}
		}
		
		System.out.println(result);
		
		// 1. 풀이
		
	} // end of main
} // end of class
