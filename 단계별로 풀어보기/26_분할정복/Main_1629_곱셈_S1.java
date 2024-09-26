import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1629_곱셈_S1 {
	
	static Long A;
	static Long B;
	static Long C;
	static Long[] dp;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		System.out.println(pow(A, B, C));
		
	}
	
	static long pow(long a, long b, long c) {
		if (b == 1) {
			return a%c;
		}
		if (b % 2 == 0) {
			long num = pow(a, b/2, c);
			return num*num%c;
		}
		return (pow(a, b/2, c)*pow(a, b-b/2, c)%c);
	}
	
}