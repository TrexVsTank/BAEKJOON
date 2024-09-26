import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//class
public class Main_4134_다음소수_S4 {
	
	// main
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) { // 테케 시작
			
			long N = Long.parseLong(br.readLine());
			
			long num = N;
			
			while (!isP(num)) {
				num++;
			}
			
			sb.append(num).append("\n");
			
		} // 테케 끝
		
		System.out.println(sb);
		
	}
	// main
	
	// isP
	private static boolean isP(long num) {
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
