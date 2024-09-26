import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 클래스 시작
public class Main_11049_행렬곱셈순서_G3 {
	
	static int N;
	static int mat[][];
	static int dp[][];
	
	// 메인 시작
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 1 ~ 500
		
		mat = new int[N][2]; // 1 ~ 500
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			mat[i][0] = Integer.parseInt(st.nextToken());
			mat[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N][N];
		
		System.out.println(mat_mul(0, N-1));
		
	} // 메인 끝
	
	// 행렬곱
	static int mat_mul(int start, int end) {
		if (start == end) {
			return 0;
		}
		if (dp[start][end] != 0) {
			return dp[start][end];
		}
		int minimum = Integer.MAX_VALUE;
		for (int i = start; i < end; i++) {
			if (minimum > mat_mul(start, i) + mat_mul(i+1, end) + mat[start][0]*mat[i][1]*mat[end][1]) {
				minimum = mat_mul(start, i) + mat_mul(i+1, end) + mat[start][0]*mat[i][1]*mat[end][1];
			}
		}
		return dp[start][end] = minimum;
	} // 행렬곱 끝
	
} // 클래스 끝