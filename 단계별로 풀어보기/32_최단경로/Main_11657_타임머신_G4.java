import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 클래스
public class Main_11657_타임머신_G4 {
	
	static int N;
	static int M;
	static int link[][];
	static long dist[];
	
	static final long INF = 100_000_000 * 100_000_000;
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// [입력] 도시 수 / 노선 수
		N = Integer.parseInt(st.nextToken()); // 1 ~ 500
		M = Integer.parseInt(st.nextToken()); // 1 ~ 6,000
		
		// [입력] 버스 노선
		link = new int[M][3];
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken()); // -만 ~ 만
			int[] bus = {start, end, cost};
			link[m] = bus;
		}
		
		// 최소거리
		dist = new long[N+1];
		Arrays.fill(dist, INF);
		dist[1] = 0;
		
		// 실행 & 출력
		StringBuilder sb = new StringBuilder();
		if(!BellmanFord()) {
			sb.append(-1);
		} else {
			for (int i = 2; i <= N; i++) {
				if (dist[i] == INF) {
					sb.append(-1).append("\n");
				} else {
					sb.append(dist[i]).append("\n");
				}
			}
		}
		System.out.println(sb);
		
	} // 메인 끝
	
	// 벨만포드
	static boolean BellmanFord() {
		for (int n = 0; n < N; n++) {
			for (int[] li : link) {
				int start = li[0];
				int end = li[1];
				long cost = li[2];
				if (dist[start] != INF && dist[start] + cost < dist[end]) {
					dist[end] = dist[start] + cost;
				}
			}
		}
		for (int[] li : link) {
			int start = li[0];
			int end = li[1];
			int cost = li[2];
			if (dist[start] != INF && dist[start] + cost < dist[end]) {
				return false;
			}
		}
		return true;
	} // 벨만포드 끝
	
} // 클래스 끝
