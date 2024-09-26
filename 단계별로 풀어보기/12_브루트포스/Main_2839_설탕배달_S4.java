import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839_설탕배달_S4 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int num = N;
		
		// 0. 입력
		
		// 1. 풀이
		
		int result = -1;
		
		for (int i = 0; i <= 4; i++) {
			if ( ( (num - i * 3) % 5 == 0) && (num - i * 3 >= 0) ) {
				result = i + (num - i * 3) / 5;
			}
		}
		
		System.out.println(result);
		// 1. 풀이
		
	} // end of main
} // end of class
