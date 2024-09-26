import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 클래스
public class Main_2667_단지번호붙이기_S1 {
	
	// 스태틱
	static int N;
	static int arr[][];
	
	static int[][] dir = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} }; // 동서남북
	static List<Integer> list = new ArrayList<>();
	static int sum;
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = input.charAt(j)-'0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1) {
					sum = 0;
					dfs(i, j);
					list.add(sum);
				}
			}
		}
		
		Collections.sort(list);
		sb.append(list.size());
		for (int i = 0; i < list.size(); i++) {
			sb.append("\n").append(list.get(i));
		}
		
		System.out.println(sb);
		
	} // 메인 끝
	
	// dfs
	static void dfs(int row, int col) {
		sum++;
		arr[row][col] = 2;
		for (int[] d : dir) {
			if (checker(row+d[0], col+d[1]) && arr[row+d[0]][col+d[1]] == 1) {
				dfs(row+d[0], col+d[1]);
			}
		}
	} // dfs 끝
	
	// checker
	static boolean checker(int row, int col) {
		if (0 <= row && row < N && 0 <= col && col < N) {
			return true;
		}
		return false;
	} // checker 끝
	
} // 클래스 끝