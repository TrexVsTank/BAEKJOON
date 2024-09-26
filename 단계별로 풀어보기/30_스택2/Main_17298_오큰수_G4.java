import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 클래스
public class Main_17298_오큰수_G4 {
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1 ~ 1,000,000
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int [N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> S = new Stack<>();
		for (int i = 0; i < N; i++) {
			while (!S.isEmpty() && arr[S.peek()] < arr[i]) {
				arr[S.pop()] = arr[i];
			}
			S.push(i);
		}
		while(!S.isEmpty()) {
			arr[S.pop()] = -1;
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]).append(" ");
		}
		
		System.out.println(sb);
		
	} // 메인 끝
	
} // 클래스 끝

// 스택을 사용하여 답의 후보를 오름/내림차순으로 관리하는 문제