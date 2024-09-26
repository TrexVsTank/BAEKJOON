import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1541_잃어버린괄호_S2 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		
		String text = new String();
		
		int num = 0;
		
		char operator = '+';
		
		for (int i = 0; i < S.length(); i++) {
			
			if (S.charAt(i) == '-' || S.charAt(i) == '+') {
				if (operator == '-') {
					num -= Integer.parseInt(text);
					text = new String();
				} else {
					num += Integer.parseInt(text);
					text = new String();
				}
			} else {
				text += S.charAt(i);
			}
			
			if (S.charAt(i) == '-') {
				operator = '-';
			}
			
		}
		if (operator == '-') {
			num -= Integer.parseInt(text);
			text = new String();
		} else {
			num += Integer.parseInt(text);
			text = new String();
		}
		System.out.println(num);
	}
}