import java.io.*;
import java.util.*;

public class Main_1546_평균_B1 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		double[] arr = new double[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Double.parseDouble(st.nextToken());
		}
		
		// 0. 입력
		
		// 1. 풀이
		
		double max = arr[0];
		for (int i = 0; i < N; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		
		for (int i = 0; i < N; i++) {
			arr[i] = arr[i]/max*100;
		}
		
		double result = 0;
		for (int i = 0; i < N; i++) {
			result += arr[i];
		}
		result /= N;
		System.out.println(result);
		
		// 1. 풀이
		
	} // end of main
} // end of class

