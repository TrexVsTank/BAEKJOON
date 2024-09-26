import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_25192_인사성밝은곰곰이_S4 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new HashMap<>();
		
		int checker = 0;
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			if (checker == 0 && input.equals("ENTER")) {
				checker++;
			} else if (input.equals("ENTER")) {
				result += map.size();
				map.clear();
			} else if (checker > 0) {
				map.put(input, 1);
			}
		}
		result += map.size();
		
		System.out.println(result);
		
	}
}