import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 클래스
public class Main_1450_냅색문제_G1 {
	
	static int N;
	static int C;
	static int numbers[];
	
	static List<Long> leftSums;
	static List<Long> rightSums;
	// 메인
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// [입력] N 1 ~ 30 C 0 ~ 10**9
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		numbers = new int[N];
		// [입력] 1 ~ 10**9
		for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
		
		leftSums = new ArrayList<>();
		getLeftSums(0, 0);
		Collections.sort(leftSums);
		
		rightSums = new ArrayList<>();
		getRightSums(N/2, 0);
		Collections.sort(rightSums);
		
		long result = 0;
		for (long L : leftSums) {
			int start = 0;
			int end = rightSums.size()-1;
			int mid = (start + end) / 2;
			while (start <= end) {
				mid = (start + end) / 2;
				if (rightSums.get(mid) + L <= C) {
					start = mid+1;
				} else {
					end = mid-1;
				}
			}
//			result += start;
			result += end+1;
		}
		System.out.println(result);
		
	} // 메인 끝
	
	// 왼쪽합
	static void getLeftSums(int index, long sum) {
		if (sum > C) {
			return;
		}
		if (index == N/2) {
			leftSums.add(sum);
			return;
		}
		getLeftSums(index+1, sum+numbers[index]);
		getLeftSums(index+1, sum);
	} // 왼쪽합 끝
	
	// 오른쪽합
	static void getRightSums(int index, long sum) {
		if (sum > C) {
			return;
		}
		if (index == N) {
			rightSums.add(sum);
			return;
		}
		getRightSums(index+1, sum+numbers[index]);
		getRightSums(index+1, sum);
	} // 오른쪽합 끝
	
} // 클래스 끝
