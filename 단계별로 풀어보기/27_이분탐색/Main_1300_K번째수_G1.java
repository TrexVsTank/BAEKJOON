import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1300_K번째수_G1 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		int n = (int) N;
		long K = Long.parseLong(br.readLine());
		
		long min = 1;
		long mid = 1;
		long max = N*N;
		
		long result = N*N;
		
		while (min < max) {
			
			mid = (min+max)/2;
			
			long count = 0;
			for (int i = 1; i <= n; i++) {
				count += Math.min(N, mid/i);
			}
			if (count >= K) {
				if (result > mid) {
					result = mid;
				}
				max = mid;
			} else {
				min = mid+1;
			}
			
		}
		
		System.out.println(result);
		
	}
}