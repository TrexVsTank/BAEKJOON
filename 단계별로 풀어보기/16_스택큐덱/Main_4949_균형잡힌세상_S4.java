import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// class
public class Main_4949_균형잡힌세상_S4 {
	// main
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		while (!input.equals(".")) {
			
			Stack<Character> sta = new Stack<>();
			
			String result = "yes";
			
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == '(') {
					sta.push('(');
				} else if (input.charAt(i) == '[') {
					sta.push('[');
				} else if (input.charAt(i) == ')') {
					if (!sta.isEmpty() && sta.peek() == '(') {
						sta.pop();
					} else {
						result = "no";
						break;
					}
				} else if (input.charAt(i) == ']') {
					if (!sta.isEmpty() && sta.peek() == '[') {
						sta.pop();
					} else {
						result = "no";
						break;
					}
				}
			}
			
			if (!sta.isEmpty()) {
				result = "no";
			}
			
			sb.append(result).append("\n");
			
			input = br.readLine();
			
		}
		System.out.println(sb);
		
	}
	// main
}
// class


