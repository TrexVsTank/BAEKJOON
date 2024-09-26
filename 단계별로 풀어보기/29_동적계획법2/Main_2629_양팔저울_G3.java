import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_2629_양팔저울_G3 {
	
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<Integer, Integer> map = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine()); // 1 ~ 30
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			int weight = Integer.parseInt(st.nextToken()); // 1 ~ 500
			Set<Integer> set = new HashSet<>();
			for (int key : map.keySet()) {
				if (map.get(Math.abs(key-weight)) == null) {
					set.add(Math.abs(key-weight));
				};
				if (map.get(Math.abs(key+weight)) == null) {
					set.add(Math.abs(key+weight));
				};
			}
			for (int newkey : set) {
				map.put(newkey, 1);
			}
			map.put(weight, map.getOrDefault(map.get(weight), 1));
		}
		
		int M = Integer.parseInt(br.readLine()); // 1 ~ 7
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int m = 0; m < M; m++) {
			int bead = Integer.parseInt(st.nextToken()); // 1 ~ 40,000
			if (map.get(bead) == null) {
				sb.append("N ");
			} else {
				sb.append("Y ");
			}
		}
		
		System.out.println(sb);
		
	}
	
}