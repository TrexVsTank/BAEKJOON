import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

// 클래스
public class Main_14003_가장긴증가하는부분수열5_P5 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine()); // 1 ~ 1_000_000_000
		
		int[] arr = new int[N+1]; // -1_000_000_000 ~ 1_000_000_000
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] arr_idx = new int[N+1];
		
		List<Integer> list = new ArrayList<>();
		list.add(-1_000_000_001);
		for (int i = 1; i <= N; i++) {
			if (arr[i] > list.get(list.size()-1)) {
				arr_idx[i] = list.size();
				list.add(arr[i]);
			} else {
				int left = 1;
				int right = list.size()-1;
				while (left <= right) {
					int mid = (left+right)/2;
					if (list.get(mid) < arr[i]) {
						left = mid+1;
					} else {
						right = mid-1;
					}
				}
				arr_idx[i] = left;
				list.set(left, arr[i]);
			}
		}
		
		int len = list.size()-1;
		Stack<Integer> stack = new Stack<>();
		for (int i = N; i >= 1; i--) {
			if (arr_idx[i] == len) {
				stack.push(arr[i]);
				len--;
			}
		}
		
		sb.append(list.size()-1).append("\n");
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb);
		
	} // 메인
	
} // 클래스
