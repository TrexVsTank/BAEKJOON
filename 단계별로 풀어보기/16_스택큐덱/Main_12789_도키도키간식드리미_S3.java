import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_12789_도키도키간식드리미_S3 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int num = 1;
		
		String result = "Nice";

		Stack<Integer> sta = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			
			if (input == num) {
				num++;
				while (!sta.isEmpty()) {
					if (sta.peek() == num) {
						sta.pop();
						num++;
					} else {
						break;
					}
				}
			} else {
				sta.push(input);
			}
		}
		
		while (!sta.isEmpty()) {
			if (sta.peek() == num) {
				sta.pop();
			} else {
				result = "Sad";
				break;
			}
		}
		
		System.out.println(result);
		
	}
}