import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_25501_재귀의귀재_B2 {
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		for (int t = 0; t < T; t++) {
			String input = br.readLine();
			
			int result = 1;
			int counter = 0;
			int idx1 = 0;
			int idx2 = input.length()-1;
			
			while (true) {
				counter++;
				if (idx1 >= idx2) {
					break;
				}
				if (input.charAt(idx1) != input.charAt(idx2)) {
					result = 0;
					break;
				}
				idx1++;
				idx2--;
			}
			
			sb.append(result).append(" ").append(counter).append("\n");
		}
		
		System.out.println(sb);
		
	}
}