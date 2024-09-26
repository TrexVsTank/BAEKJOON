import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// class
public class Main_1912_연속합_S2 {
	// main
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 정수의 수 N
		int N = Integer.parseInt(br.readLine());
		
		// 정수의 배열 array[]
		int array[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		// 해당 인덱스까지의 최대값 max[]
		int max[] = new int[N];
		max[0] = array[0];
		
		// 최대값 maximum
		int maximum = array[0];
		
		for (int i = 1; i < N; i++) {
			max[i] = Math.max(max[i-1] + array[i], array[i]);
			maximum = Math.max(maximum, max[i]);
		}
		
		System.out.println(maximum);
		
	} // end of main
} // end of class