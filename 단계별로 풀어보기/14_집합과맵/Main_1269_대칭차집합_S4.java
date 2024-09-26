import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1269_대칭차집합_S4 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<Integer, Integer> map = new HashMap<>();

		StringTokenizer stN = new StringTokenizer(br.readLine(), " ");
		for (int n = 0; n < N; n++) {
			int input = Integer.parseInt(stN.nextToken());
			if (map.get(input) == null) {
				map.put(input, 1);
			} else {
				map.replace(input, map.get(input)+1);
			}
		}
		
		StringTokenizer stM = new StringTokenizer(br.readLine(), " ");
		for (int m = 0; m < M; m++) {
			int input = Integer.parseInt(stM.nextToken());
			if (map.get(input) == null) {
				map.put(input, 1);
			} else {
				map.replace(input, map.get(input)+1);
			}
		}
		
		int sum = 0;
		
		for (int i : map.keySet()) {
			if (map.get(i) == 1) {
				sum++;
			}
		}
		
		System.out.println(sum);
		
	} // end of main
} // end of class

