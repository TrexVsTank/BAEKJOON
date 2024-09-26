import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

//class
public class Main_17103_골드바흐파티션_S2 {
	
	// main
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		Map<Integer, Integer> primeMap = new HashMap<>();
		for (int i = 2; i <= 1000000; i++) {
			if (isPrime(i)) {
				primeMap.put(i, 1);
			}
		}

		// teke
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int sum = 0;
			for (int i = 2; i <= N/2; i++) {
				if (primeMap.get(i)!=null && primeMap.get(N-i)!=null) {
					sum++;
				}
			}
			sb.append(sum).append("\n");
		}
		// teke
		
		System.out.println(sb);
		
	}
	// main
	
	// isP
	private static boolean isPrime(int num) {
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
