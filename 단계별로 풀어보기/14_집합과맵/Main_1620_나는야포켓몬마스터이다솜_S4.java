import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1620_나는야포켓몬마스터이다솜_S4 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<Integer, String> intKey = new HashMap<>();
		Map<String, Integer> strKey = new HashMap<>();
		for (int n = 1; n <= N; n++) {
			String input = br.readLine();
			intKey.put(n, input);
			strKey.put(input, n);
		}
		
		for (int m = 0; m < M; m++) {
			String input = br.readLine();
			if (input.charAt(0)-'0' < 10) {
				sb.append(intKey.get(Integer.parseInt(input))).append("\n");
			} else {
				sb.append(strKey.get(input)).append("\n");
			}
		}
		
		System.out.println(sb);
		
	} // end of main
} // end of class

