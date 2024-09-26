import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_2108_통계학_S3 {
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		// 입력
		
		double one = 0;
		for (int i = 0; i < N; i++) {
			one += arr[i];
		}
		one /= N;
		if (-0.5 < one && one < 0) {
			System.out.println(0);
		} else {
			System.out.printf("%.0f\n", one);
		}
		
		int two = arr[arr.length/2];
		System.out.println(two);
		
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			if (map.get(arr[i]) == null) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i])+1);
			}
		}
		List<int[]> list = new ArrayList<>();
		for (Integer i : map.keySet()) {
			list.add(new int[] {i, map.get(i)});
		}
		Collections.sort(list, (a, b) -> {
			if (a[1] == b[1]) {
				return a[0] - b[0];
			}
			return b[1] - a[1];
		});
		if (list.size() > 1 && list.get(0)[1] == list.get(1)[1]) {
			System.out.println(list.get(1)[0]);
		} else {
			System.out.println(list.get(0)[0]);
		}
		
		int four = arr[arr.length-1] - arr[0];
		System.out.println(four);
		
	}
}