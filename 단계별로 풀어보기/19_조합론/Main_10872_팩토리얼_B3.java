import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10872_팩토리얼_B3 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(fact(N));
	}
	
	static int fact(int n) {
		if (n < 2) {
			return 1;
		}
		return fact(n-1)*n;
	}
}