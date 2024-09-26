import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_10816_숫자카드2_S4 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Map<Integer, Integer> map = new HashMap<>();
		
		StringTokenizer stN = new StringTokenizer(br.readLine(), " ");
		
		for (int n = 0; n < N; n++) {
			int input = Integer.parseInt(stN.nextToken());
			if (map.get(input) == null) {
				map.put(input, 1);
			} else {
				map.replace(input, map.get(input)+1);
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		
		StringTokenizer stM = new StringTokenizer(br.readLine(), " ");
		
		for (int m = 0; m < M; m++) {
			int input = Integer.parseInt(stM.nextToken());
			if (map.get(input) == null) {
				sb.append(0).append(" ");
			} else {
				sb.append(map.get(input)).append(" ");
			}
		}
		
		System.out.println(sb);
		
	} // end of main
} // end of class

