import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// class
public class Main_11054_가장긴바이토익부분수열_G4 {
	
	// main
	public static void main(String[] args) throws IOException {
		
		// br
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N
		int N = Integer.parseInt(br.readLine());
		
		// maximum
		int maximum = 1;
		
		// arr
		int arr[][] = new int[N][3];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
		}
		
		// map (up)
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int max = 1;
			
			for (int k : map.keySet()) {
				if (arr[i][0] > k && max < map.get(k)+1) {
					max = map.get(k)+1;
				}
			}
			
			map.put(arr[i][0], max);
			
			arr[i][1] = max;
			
			if (maximum < max) {
				maximum = max;
			}
		}
		
		// map2 (down)
		Map<Integer, Integer> map2 = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int max = arr[i][1];
			
			for (int k : map2.keySet()) {
				if (arr[i][0] < k && max < map2.get(k)+1) {
					max = map2.get(k)+1;
				}
			}
			
			map2.put(arr[i][0], max);
			
			arr[i][2] = max;
			
			if (maximum < max) {
				maximum = max;
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		
		System.out.println(maximum);
		
	} // end of main
	
} // end of class