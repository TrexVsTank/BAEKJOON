import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15652_N과M4_S3 {
	
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	static int arr[];
	
	public static void main(String[] args) throws IOException {
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		nAm4(0);
		
		System.out.println(sb);
		
	}
	
	static void nAm4(int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (idx == 0 || arr[idx-1] <= i+1) {
				arr[idx] = i+1;
			} else {
				continue;
			}
			nAm4(idx+1);
		}
	}
	
}