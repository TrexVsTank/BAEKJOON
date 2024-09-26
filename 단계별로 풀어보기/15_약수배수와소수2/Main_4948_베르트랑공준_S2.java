import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//class
public class Main_4948_베르트랑공준_S2 {
	
	// main
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		while (!input.equals("0")) {
			long sum = 0;
			long N = Long.parseLong(input);
			for (long i = N+1; i <= N*2; i++) {
				if (isPrime(i)) {
					sum++;
				}
			}
			input = br.readLine();
			sb.append(sum).append("\n");
		}
		
		
		System.out.println(sb);
		
	}
	// main
	
	// isP
	private static boolean isPrime(long num) {
		if (num < 2) {
			return false;
		}
		for (long i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	// is P
	
}
// class
