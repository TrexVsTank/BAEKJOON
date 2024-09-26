import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// class
public class Main_2559_수열_S3 {
	
	// main
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] sum = new int[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int maximum = Integer.MIN_VALUE;
		for (int i = 1; i <= N-M+1; i++) {
			if (maximum < sum[i+M-1]-sum[i-1]) {
				maximum = sum[i+M-1]-sum[i-1];
			}
		}
		
		System.out.println(maximum);
		
	} // end of main
	
} // end of class