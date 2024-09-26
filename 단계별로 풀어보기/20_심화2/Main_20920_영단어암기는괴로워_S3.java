import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_20920_영단어암기는괴로워_S3 {
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			if (input.length() < M) {
				continue;
			} else if (map.get(input) == null) {
				map.put(input, 1);
			} else {
				map.put(input, map.get(input)+1);
			}
		}
		
		List<String> list = new ArrayList<>();
		for (String s : map.keySet()) {
			list.add(s);
		}
		
		Collections.sort(list, (a, b) -> {
			if (map.get(b) == map.get(a) && a.length() == b.length()) {
				return a.compareTo(b);
			} else if (map.get(b) == map.get(a)) {
				return b.length() - a.length();
			}
			return map.get(b)-map.get(a);
		});
		
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		
		System.out.println(sb);
		
	}
}