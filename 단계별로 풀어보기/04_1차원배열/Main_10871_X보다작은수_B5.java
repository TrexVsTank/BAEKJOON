import java.io.*;
import java.util.*;

public class Main_10871_X보다작은수_B5 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int X = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		
		StringTokenizer stN = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int numIn = Integer.parseInt(stN.nextToken());
			if (numIn < X) {
				list.add(numIn);
			}
		}
		
		for (int i = 0, i2 = list.size(); i < i2; i++) {
			sb.append(list.get(i) + " ");
		}
		
		System.out.println(sb);

		// 0. 입력
		
		// 1. 풀이
		
		
		
		// 1. 풀이
		
	} // end of main
} // end of class

