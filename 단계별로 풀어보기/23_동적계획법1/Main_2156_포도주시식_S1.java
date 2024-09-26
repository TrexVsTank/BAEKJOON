import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// class
public class Main_2156_포도주시식_S1 {
	
	// main
	public static void main(String[] args) throws IOException {
		
		// br
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N
		int N = Integer.parseInt(br.readLine());
		
		// max
		int max = 0;
		
		// wine
		int wine[][] = new int[N+1][2];
		wine[1][0] = Integer.parseInt(br.readLine());
		max = wine[1][0];
		
//		System.out.println("case : " + 1);
//		System.out.println(Arrays.toString(wine[1]));
		
		for (int i = 2; i <= N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				wine[i][0] = Math.max(Math.max(wine[i-2][0], wine[i-2][1]), Math.max(wine[i-1][0], wine[i-1][1]));
				wine[i][1] = 0;
			} else {
				wine[i][0] = Math.max(max, Math.max(wine[i-2][0]+num, wine[i-2][1]+num));
				wine[i][1] = wine[i-1][0]+num;
			}
			if (max < wine[i][0]) {
				max = wine[i][0];
			}
			if (max < wine[i][1]) {
				max = wine[i][1];
			}
			
//			System.out.println("case : " + i);
//			System.out.println(num);
//			System.out.println(Arrays.toString(wine[i]));
			
		}
		
		System.out.println(max);
		
	} // end of main
	
} // end of class