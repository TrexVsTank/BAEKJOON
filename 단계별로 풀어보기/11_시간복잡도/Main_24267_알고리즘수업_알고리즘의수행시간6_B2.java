import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_24267_알고리즘수업_알고리즘의수행시간6_B2 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());
		
		long nn = 0;
		
//		for (int i = 1; i <= n-2; i++) {
//			for (int j = i+1; j <= n-1; j++) {
//				for (int k = j+1; k <= n; k++) {
//					nn++;
//				}
//			}
//		}
		
		for (long i = 1; i <= n-2; i++) {
			nn += (i+1) * i / 2;
		}
		
		System.out.println(nn);
		System.out.println(3);
		
	} // end of main
} // end of class
