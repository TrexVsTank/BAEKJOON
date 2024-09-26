import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650_N과M2_S3 {
	
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	static int arr[];
	static boolean used[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		used = new boolean[N];
		
		nAm2(0);
		
		System.out.println(sb);
	}
	
	// nAm2
	static void nAm2(int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = idx; i < N; i++) {
			if (!used[i]) {
				for (int j = 0; j <= i; j++) {
					used[j] = true;
				}
				arr[idx] = i+1;
				nAm2(idx+1);
				for (int j = 0; j <= i; j++) {
					used[j] = false;
				}
			}
		}
	}
	
}