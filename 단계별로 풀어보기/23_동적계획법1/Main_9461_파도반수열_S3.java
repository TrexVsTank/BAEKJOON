import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// class
public class Main_9461_파도반수열_S3 {
	
	static int N;
	static long arr[];
	
	// main
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		// testCase
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new long[N+1];
			System.out.println(waveSequence(N));
		} // end of testCase
		
	} // end of main
	
	// waveSequence
	static long waveSequence(int n) {
		if (arr[n] != 0) {
			return arr[n];
		}
		if (n < 4) {
			return arr[n] = 1;
		} else {
			return arr[n] = waveSequence(n-2) + waveSequence(n-3);
		}
	} // end of waveSequence
	
} // end of class