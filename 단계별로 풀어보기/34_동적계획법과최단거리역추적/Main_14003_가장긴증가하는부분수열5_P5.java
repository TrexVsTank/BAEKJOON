import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

// [클래스] 메인
public class Main_14003_가장긴증가하는부분수열5_P5 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	// [메서드] 메인
	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine()); // 수열의 크기 (1 ~ 10^9)
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N+1]; // 수열 (-10^9 ~ 10^9)
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] arr_order = new int[N+1]; // 순서 기록 (역추적용)
		
		// Longest Increase Sequence
		List<Integer> LIS = new ArrayList<>(); LIS.add(-1_000_000_001);
		for (int i = 1; i <= N; i++) {
			int curr_Num = arr[i];
			
			if (LIS.get(LIS.size()-1) < curr_Num) {
				arr_order[i] = LIS.size();
				LIS.add(curr_Num);
			}
			
			int left = 1;
			int right = LIS.size()-1;
			while (left <= right) {
				int mid = (left+right)/2;
				if (LIS.get(mid) < curr_Num) {
					left = mid+1;
				} else {
					right = mid-1;
				}
			}
			arr_order[i] = left;
			LIS.set(left, curr_Num);
		}
		
		// 최대길이
		int val = LIS.size()-1;
		sb.append(val).append("\n");
		
		// 역추적
		Stack<Integer> stack = new Stack<>();
		for (int i = N; i >= 1; i--) {
			if (arr_order[i] == val) {
				stack.push(arr[i]);
				val--;
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		
		// 출력
		System.out.println(sb);
		
	} // [메서드] 메인
	
} // [클래스] 메인
