import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 클래스
public class Main_1012_유기농배추_S2 {
	
	// 스태틱
	static int M;
	static int N;
	static int K;
	
	static int arr[][];
	
	static int[][] dir = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} }; // 동서남북
	static List<Integer> list = new ArrayList<>();
	static int sum;
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		// 테케
		for (int t = 0; t < T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new int[M][N];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			
			sum = 0;
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1) {
						sum++;
						dfs(i, j);
					}
				}
			}
			
			sb.append(sum).append("\n");
			
		} // 테케 끝
		
		System.out.println(sb);
		
	} // 메인 끝
	
	// dfs
	static void dfs(int row, int col) {
		arr[row][col] = 2;
		for (int[] d : dir) {
			if (checker(row+d[0], col+d[1]) && arr[row+d[0]][col+d[1]] == 1) {
				dfs(row+d[0], col+d[1]);
			}
		}
	} // dfs 끝
	
	// checker
	static boolean checker(int row, int col) {
		if (0 <= row && row < M && 0 <= col && col < N) {
			return true;
		}
		return false;
	} // checker 끝
	
} // 클래스 끝