import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 클래스
public class Main_11404_플로이드_G4 {
	
	static final int INF = 1_000_000_000;
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// [입력]
		int N = Integer.parseInt(br.readLine()); // 2 ~ 100
		int M = Integer.parseInt(br.readLine()); // 1 ~ 100,000
		
		// [입력] 비용 1 ~ 100,000
		int[][] dist = new int[N+1][N+1];
		for (int i = 0; i <= N; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}
		for (int m = 0; m < M; m++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
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
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for (int s = 1; s <= N; s++) {
			for (int e = 1; e <= N; e++) {
				sb.append(dist[s][e] == INF ? 0 : dist[s][e]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	} // 메인 끝
	
} // 클래스 끝
