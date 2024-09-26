import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_26069_붙임성좋은총총이_S4 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new HashMap<>();
		map.put("ChongChong", 1);
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String A = st.nextToken();
			String B = st.nextToken();
			if (map.get(A) != null && map.get(A) == 1) {
				map.put(B, 1);
			} else if (map.get(B) != null && map.get(B) == 1) {
				map.put(A, 1);
			}
		}
		
		System.out.println(map.size());
		
	}
}