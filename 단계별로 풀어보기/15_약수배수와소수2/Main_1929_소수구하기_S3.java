import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//class
public class Main_1929_소수구하기_S3 {
	
	// main
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		
		for (long i = N; i <= M; i++) {
			if (isPrime(i)) {
				sb.append(i).append("\n");
			}
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
