import java.io.*;
import java.util.*;

public class Main_2562_최댓값_B3 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = 9;
		
		List<List<Integer>> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			List<Integer> list2 = new ArrayList<>();
			list.add(list2);
			list.get(i).add(Integer.parseInt(br.readLine()));
			list.get(i).add(i+1);
		}
		
		// 0. 입력
		
		// 1. 풀이
		
		Collections.sort(list, (a, b) -> {
			return b.get(0)-a.get(0);
		});
		
		System.out.println(list.get(0).get(0));
		System.out.println(list.get(0).get(1));
		
		// 1. 풀이
		
	} // end of main
} // end of class

