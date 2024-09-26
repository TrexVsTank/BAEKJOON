import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// class
public class Main_2110_공유기설치_G4 {
	
	// main
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 2 ~ 200,000
		int C = Integer.parseInt(st.nextToken()); // 2 ~ N
		
		long min = 0;
		long mid = 0;
		long max = 0;
		
		long[] arr = new long[N]; // 0 ~ 10^9
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		Arrays.sort(arr);
		
		long dist_max = 0;
		
		while (min != max) {
			mid = (min+max)/2;
			
			int idx = 0;
			int count = 1;
			
			for (int i = 1; i < N; i++) {
				if (arr[i] - arr[idx] >= mid) {
					idx = i;
					count++;
				}
			}
			
			if (count >= C) {
				min = mid+1;
				if (dist_max < mid) {
					dist_max = mid;
				}
			} else {
				max = mid;
			}
			
		}
		
		mid = (min+max)/2;
		
		int idx = 0;
		int count = 1;
		
		for (int i = 1; i < N; i++) {
			if (arr[i] - arr[idx] >= mid) {
				idx = i;
				count++;
			}
		}
		
		if (count >= C) {
			if (dist_max < mid) {
				dist_max = mid;
			}
		}
		
		System.out.println(dist_max);
		
	} // end of main
	
} // end of class