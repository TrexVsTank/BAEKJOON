import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1654_랜선자르기_S2 {
	
	// main
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// K / N (1 ~ 1,000,000)
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		// min / mid / max
		long min = 0;
		long mid = 0;
		long max = 0;
		
		// lan (1 ~ 2^31-1)
		long[] lan = new long[K];
		for (int i = 0; i < K; i++) {
			lan[i] = Long.parseLong(br.readLine());
			if (max < lan[i]) {
				max = lan[i];
			}
		}
		
		mid = (min+max)/2;
		long maximum_length = 0;
		
		while (!(min == mid && mid == max)) {
			if (min+1 == max) {
				min = max;
				mid = max;
			}
			
			long count = 0;
			for (int i = 0; i < lan.length; i++) {
				count += lan[i] / mid;
			}
			if (count >= N) {
				if (maximum_length < mid) {
					maximum_length = mid;
				}
				min = mid;
				mid = (min+max)/2;
			} else {
				max = mid;
				mid = (min+max)/2;
			}
		}
		
		System.out.println(maximum_length);
		
	} // end of main
	
} // end of class
