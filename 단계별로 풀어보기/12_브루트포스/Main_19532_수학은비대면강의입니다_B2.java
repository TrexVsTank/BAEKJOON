import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19532_수학은비대면강의입니다_B2 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double a = Double.parseDouble(st.nextToken());
		double b = Double.parseDouble(st.nextToken());
		double c = Double.parseDouble(st.nextToken());
		double d = Double.parseDouble(st.nextToken());
		double e = Double.parseDouble(st.nextToken());
		double f = Double.parseDouble(st.nextToken());
		// 0. 입력
		
		int X = 0;
		int Y = 0;
		
		for (int x = -999; x <= 999; x++) {
			for (int y = -999; y <= 999; y++) {
				if ( (a*x+b*y==c) && (d*x+e*y==f) ) {
					X = x;
					Y = y;
				}
			}
		}

		System.out.println(X + " " + Y);
		
	} // end of main
} // end of class
