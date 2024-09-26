import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 클래스
public class Main_1956_운동_G4 {
	
	static final int INF = 1_000_000_000;
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		// [입력]
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 2 ~ 4,000
		int M = Integer.parseInt(st.nextToken()); // 1 ~ 16,000,000
		
		// [입력] 비용 1 ~ 100,000
		int[][] dist = new int[N+1][N+1];
		for (int i = 0; i <= N; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			dist[start][end] = Math.min(dist[start][end], cost);
		}
		
		// 플로이드
		for (int m = 1; m <= N; m++) {
			for (int s = 0; s <= N; s++) {
				for (int e = 0; e <= N; e++) {
					dist[s][e] = Math.min(dist[s][e], dist[s][m] + dist[m][e]);
				}
			}
		}
		
		int result = INF;
		
		// 출력
		for (int s = 1; s <= N; s++) {
			for (int e = 1; e <= N; e++) {
				if (s != e && dist[s][e] != INF && dist[e][s] != INF) {
					result = Math.min(result, dist[s][e] + dist[e][s]);
				}
					
			}
		}
		
		System.out.println(result == INF ? -1 : result);
		
	} // 메인 끝
	
} // 클래스 끝
