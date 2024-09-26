import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// class
public class Main_15649_N과M1_S3 {
	
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	static int arr[];
	static boolean used[];
	
	// main
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		used = new boolean[N];
		
		nAm1(0);
		System.out.println(sb);
		
	} // end of main
	
	// nAm1
	static void nAm1(int index) {
		if (index == M) {
			for (int idx = 0; idx < M; idx++) {
				sb.append(arr[idx]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int idx = 0; idx < N; idx++) {
			if (used[idx] == false) {
				used[idx] = true;
				arr[index] = idx+1;
				nAm1(index+1);
				used[idx] = false;
			}
		}
	} // end of nAm1
	
} // end of class