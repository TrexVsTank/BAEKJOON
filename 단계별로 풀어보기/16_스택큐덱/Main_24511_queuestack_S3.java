import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_24511_queuestack_S3 {
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		//// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N
		int N = Integer.parseInt(br.readLine());
		// A
		int[] A = new int[N];
		StringTokenizer stA = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(stA.nextToken());
		}
		// B
		Deque<Integer> B = new ArrayDeque<>();
		StringTokenizer stB = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(stB.nextToken());
			if (A[i] == 0) {
				B.offerLast(input);
			}
		}
		// M
		int M = Integer.parseInt(br.readLine());
		// C
		StringTokenizer stC = new StringTokenizer(br.readLine(), " ");
		for (int m = 0; m < M; m++) {
			B.offerFirst(Integer.parseInt(stC.nextToken()));
			sb.append(B.pollLast()).append(" ");
		}
		//// 입력
		
		// 출력
		System.out.println(sb);
		
	}
}