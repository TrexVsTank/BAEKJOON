import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main_7785_회사에있는사람_S5 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Map<String, String> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		
		// 0. 입력
		
		// 1. 풀이
		
		List<String> list = new ArrayList<>();
		
		for (String s : map.keySet()) {
			if (map.get(s).equals("enter")) {
				list.add(s);
			}
		}
		
		Collections.sort(list, (a, b) -> {
			return b.compareTo(a);
		});
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0, s = list.size(); i < s; i++) {
			sb.append(list.get(i) + "\n");
		}
		
		System.out.println(sb);
		
		// 1. 풀이
		
	} // end of main
} // end of class
