import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_24723_녹색거탑_B4 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int result = 1;
		for (int i = 0; i < n; i++) {
			result *= 2;
		}
		System.out.println(result);
		
	}
}