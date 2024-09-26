import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;

// [클래스] 메인
public class Main_2618_결찰차_P4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int W;
	
	static int crime[][];
	static int dp[][];
	
	// [메서드] 메인
	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(br.readLine()); // 도로의 개수 (5 <= N <= 1,000)
		W = Integer.parseInt(br.readLine()); // 사건의 개수 (1 <= W <= 1,000)
		
		crime = new int[W+1][2]; // 사건의 위치
		dp = new int[W+1][W+1]; // 최소거리 저장
		
		for (int i = 1; i <= W; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			crime[i][0] = Integer.parseInt(st.nextToken());
			crime[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int min_Move = get_Min_Dist(1, 0, 0); // 최소이동횟수
		sb.append(min_Move).append("\n");
		
//		for (int i = 0; i < W+1; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		
		// 경로역추적
		int one = 0;
		int two = 0;
		int crime = 1;
		while (one != W && two != W) {
			if (dp[one][two] == dp[crime][two] + get_Dist(1, one, crime)) {
				sb.append(1).append("\n");
				one = crime++;
			} else {
				sb.append(2).append("\n");
				two = crime++;
			}
		}
		
		// 출력
		System.out.println(sb);
		
	} // [메서드] 메인
	
	// [메서드] 최소거리 (해결할 범죄, 경찰차 1의 위치, 경찰차 2의 위치)
	private static int get_Min_Dist(int num_Crime, int idx_One, int idx_Two) {
		
		if (num_Crime > W) {
			return 0;
		}
		
		if (dp[idx_One][idx_Two] != 0) {
			return dp[idx_One][idx_Two];
		}
		
		// 최소거리(다음범죄, 현재범죄, 경찰차2) + idx_One -> num_Crime
		int dist_One = get_Min_Dist(num_Crime+1, num_Crime, idx_Two) + get_Dist(1, idx_One, num_Crime);
		// 최소거리(다음범죄, 경찰차1, 현재범죄) + idx_Two -> num_Crime
		int dist_Two = get_Min_Dist(num_Crime+1, idx_One, num_Crime) + get_Dist(2, idx_Two, num_Crime);
		
		return dp[idx_One][idx_Two] = Math.min(dist_One, dist_Two);
		
	} // [메서드] 최소거리
	
	// [메서드] 이동거리 (차량번호, 출발지, 목적지)
	private static int get_Dist(int num_Car, int idx_From, int idx_To) {
		
		int row_To = crime[idx_To][0]; // 목적 행
		int col_To = crime[idx_To][1]; // 목적 열
		
		if (idx_From == 0) {
			if (num_Car == 1) {
				return Math.abs(row_To-1) + Math.abs(col_To-1); // 차량 1 초기위치
			} else {
				return Math.abs(row_To-N) + Math.abs(col_To-N); // 차량 2 초기위치
			}
		}
		
		int row_From = crime[idx_From][0]; // 출발 행
		int col_From = crime[idx_From][1]; // 출발 열
		
		return Math.abs(row_To-row_From) + Math.abs(col_To-col_From);
		
	} // [메서드] 이동거리
	
} // [클래스] 메인
