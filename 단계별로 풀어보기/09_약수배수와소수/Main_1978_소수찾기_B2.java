import java.io.*;
import java.util.*;

public class Main_1978_소수찾기_B2 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arrInput = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			arrInput[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			if (arrInput[i] > 1) {
				int counter = 2;
				int checker = 0;
				while (counter < arrInput[i]) {
					if (arrInput[i] % counter == 0) {
						checker++;
						break;
					}
					counter++;
				}
				if (checker == 0) {
					result++;
				}
			}
		}
		
		System.out.println(result);
		
	} // end of main
} // end of class

