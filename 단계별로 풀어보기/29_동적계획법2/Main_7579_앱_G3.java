import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

// 클래스
public class Main_7579_앱_G3 {
	
	static int N;
	static int M;
	static int memory[];
	static int cost[];
	static int sum_memory = 0;
	static int sum_cost = 0;
	static int minimum_cost = Integer.MAX_VALUE;
	static Map<Integer, Integer> map = new HashMap<>();
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 1 ~ 100
		M = Integer.parseInt(st.nextToken()); // 1 ~ 10,000,000
		
		st = new StringTokenizer(br.readLine(), " ");
		memory = new int[N]; // 1 ~ 10,000,000
		for (int i = 0; i < N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		cost = new int[N]; // 1 ~ 100
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			Set<int[]> set = new HashSet<>();
			for (int key : map.keySet()) {
				if (map.get(key+cost[i]) == null || map.get(key+cost[i]) <= map.get(key) + memory[i]) {
					int[] in = {key+cost[i], map.get(key) + memory[i]};
					set.add(in);
				}
				if (map.get(key) >= M && minimum_cost > key) {
					minimum_cost = key;
				}
			}
			for (int[] s : set) {
				map.put(s[0], Math.max(map.getOrDefault(s[0], 0), s[1]));
				if (map.get(s[0]) >= M && minimum_cost > s[0]) {
					minimum_cost = s[0];
				}
			}
			map.put(cost[i], Math.max(map.getOrDefault(cost[i], 0), memory[i]));
			if (map.get(cost[i]) >= M && minimum_cost > cost[i]) {
				minimum_cost = cost[i];
			}
		}
		
		System.out.println(minimum_cost);
		
	} // 메인 끝
	
} // 클래스 끝