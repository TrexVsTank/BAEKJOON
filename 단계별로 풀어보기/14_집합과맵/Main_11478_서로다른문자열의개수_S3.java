import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_11478_서로다른문자열의개수_S3 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String word = br.readLine();
		
		Map<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i <= word.length()-1; i++) {
			for (int j = i+1; j <= word.length(); j++) {
				String key = word.substring(i, j);
				if (map.get(key) == null) {
					map.put(key, 1);
				}
			}
		}
		
		System.out.println(map.keySet().size());
		
	} // end of main
} // end of class

