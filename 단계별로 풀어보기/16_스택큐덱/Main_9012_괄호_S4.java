import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;


//class
public class Main_9012_괄호_S4 {
	
	// main
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			
			String result = "YES";
			
			String str = br.readLine();
			
			Stack<Character> sta = new Stack<>();
			
			for (int i = 0; i < str.length(); i++) {
				char cha = str.charAt(i);
				if (cha == '(') {
					sta.push(cha);
				} else {
					if (sta.isEmpty()) {
						result = "NO";
						break;
					}
					else if (sta.peek() == '(') {
						sta.pop();
					} else {
						result = "NO";
						break;
					}
				}
			}
			
			if (!(sta.isEmpty())) {
				result = "NO";
			}
			
			sb.append(result).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	// main
}
// class


