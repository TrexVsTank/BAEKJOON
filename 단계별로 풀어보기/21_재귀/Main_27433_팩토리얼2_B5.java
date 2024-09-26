import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_27433_팩토리얼2_B5 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Integer.parseInt(br.readLine());
		
		System.out.println(fact(N));
		
	}
	
	static long fact(long n) {
		if (n < 2) {
			return 1;
		} else {
			return fact(n-1) * n;
		}
	}
	
}