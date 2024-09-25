import java.io.*;
import java.util.*;

public class Main_10810_공넣기_B3 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			List<Integer> list2 = new ArrayList<>();
			list.add(list2);
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int n1 = (Integer.parseInt(st2.nextToken()));
			int n2 = (Integer.parseInt(st2.nextToken()));
			int n3 = (Integer.parseInt(st2.nextToken()));
			for (int j = n1-1; j < n2; j++) {
				if (list.get(j).size() == 1) {
					list.get(j).remove(0);
					list.get(j).add(n3);
				} else {
					list.get(j).add(n3);
				}
			}
		}
		
		// 0. 입력
		
		// 1. 풀이
		
		for (int i = 0; i < N; i++) {
			if (list.get(i).size() == 1) {
				System.out.print(list.get(i).get(0) + " ");
			} else {
				System.out.print(0 + " ");
			}
		}
		
		// 1. 풀이
		
	} // end of main
} // end of class

