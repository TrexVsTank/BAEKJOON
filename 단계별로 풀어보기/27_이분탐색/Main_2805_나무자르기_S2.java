import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// class
public class Main_2805_나무자르기_S2 {
	
	// main
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// N (1 ~ 1,000,000)
		int N = Integer.parseInt(st.nextToken());
		// M (1 ~ 2,000,000,000)
		long M = Long.parseLong(st.nextToken());
		
		// min
		long min = 0;
		// mid
		long mid = 0;
		// max
		long max = 0;
		
		// arr
		long[] arr = new long[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		mid = max/2;
		
		long maximum = 0;
		
		while (!(min == mid && mid == max)) {
			
			if (min+1 == max) {
				min = max;
				mid = (max+min)/2;
			}
			
			long count = 0;
			for (int i = 0; i < N; i++) {
				count += (arr[i] - mid > 0 ? arr[i] - mid : 0);
			}
			if (count >= M) {
				if (maximum < mid) {
					maximum = mid;
				}
				min = mid;
			} else {
				max = mid;
			}
			mid = (min+max)/2;
		}
		
		System.out.println(maximum);
		
	} // end of main
	
} // end of class