import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1764_듣보잡_S4 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		
		for (int n = 0; n < N; n++) {
			String input = br.readLine();
			if (map.get(input) == null) {
				map.put(input, 1);
			} else {
				map.replace(input, map.get(input)+1);
			}
		}
		
		for (int m = 0; m < M; m++) {
			String input = br.readLine();
			if (map.get(input) == null) {
				map.put(input, 1);
			} else {
				map.replace(input, map.get(input)+1);
			}
		}
		
		int num = 0;
		
		List<String> list = new ArrayList<>();
		
		for (String s : map.keySet()) {
			if (map.get(s) == 2) {
				num++;
				list.add(s);
			}
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		
		System.out.println(num);
		
		System.out.println(sb);
		
	} // end of main
} // end of class

