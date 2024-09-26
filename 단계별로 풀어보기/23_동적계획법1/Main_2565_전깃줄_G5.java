import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// class
public class Main_2565_전깃줄_G5 {
	
	// main
	public static void main(String[] args) throws IOException {
		
		// br
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N
		int N = Integer.parseInt(br.readLine());
		
		// arr
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, (a, b) -> { return a[0]-b[0]; });
		
		// maximum
		int maximum = 1;
		
		// map / map2
		Map<Integer, Integer> map = new HashMap<>();
		Map<Integer, Integer> map2 = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			int max = 1;
			for (int k : map.keySet()) {
				if (map.get(k) < arr[i][1] && max < map2.get(k)+1) {
					max = map2.get(k)+1;
				}
			}
			map.put(arr[i][0], arr[i][1]);
			map2.put(arr[i][0], max);
			if (maximum < max) {
				maximum = max;
			}
		}
		
		System.out.println(N-maximum);
		
	} // end of main
	
} // end of class
