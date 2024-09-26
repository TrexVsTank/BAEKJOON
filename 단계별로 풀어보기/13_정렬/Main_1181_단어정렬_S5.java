import java.io.*;
import java.util.*;

public class Main_1181_단어정렬_S5 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] list = new String[N];
		
		for (int i = 0; i < N; i++) {
			list[i] = br.readLine();
		}
		
		// 0. 입력
		
		// 1. 풀이
		
		Arrays.sort(list, (a, b) -> {
			if (((String)a).length() == ((String)b).length()) {
				return a.compareTo(b);
			} else {
				return ((String)a).length() - ((String)b).length();
			}
		});
		
		List<String> list2 = new ArrayList<>();
		
		list2.add(list[0]);
		
		for (int i = 1; i < N; i++) {
			if(!(list[i].equals(list[i-1]))) {
				list2.add(list[i]);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list2.size(); i++) {
			sb.append(list2.get(i) + "\n");
		}
		System.out.println(sb);
		
		// 1. 풀이
		
	} // end of main
} // end of class
