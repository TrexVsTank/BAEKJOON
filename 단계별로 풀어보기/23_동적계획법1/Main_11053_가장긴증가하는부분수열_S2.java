import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_11053_가장긴증가하는부분수열_S2 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		// input
		
		int maximum = 1;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		map.put(A[N-1], 1);
		for (int i = N-2; i >= 0; i--) {
			int max = 1;
			for (int key : map.keySet()) {
				if (A[i] < key && max < map.get(key)+1) {
					max = map.get(key)+1;
				}
				if (maximum < max) {
					maximum = max;
				}
			}
			map.put(A[i], max);
//			System.out.println(map);
		}
		
		System.out.println(maximum);
		
	}
}