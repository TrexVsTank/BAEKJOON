import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_1920_수찾기_S4 {
	
	static int result;
	static int N;
	static long AN[];
	static long number;
	
	public static void main(String[] args) throws IOException {
		
		// sb
		StringBuilder sb = new StringBuilder();
		
		// br
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N
		N = Integer.parseInt(br.readLine());
		
		// AN
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		AN = new long[N];
		for (int i = 0; i < N; i++) {
			AN[i] = Long.parseLong(st.nextToken());
		}
		
		// AN 정렬
		Arrays.sort(AN);
		
		// M
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			// result
			result = 0;
			// number
			number = Long.parseLong(st.nextToken());
			
			bin_find(0, N-1);
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	// bin_find
	static void bin_find(int start, int end) {
		if (number < AN[start] && number > AN[end]) {
			return;
		}
		if (AN[start] == number || AN[end] == number) {
			result = 1;
			return;
		}
		if (start == end) {
			return;
		}
		int mid = (start+end) / 2;
		if (AN[mid] == number) {
			result = 1;
			return;
		}
		if (number < AN[mid]) {
			bin_find(start, mid);
			return;
		} else {
			bin_find(mid+1, end);
			return;
		}
	}
	
}