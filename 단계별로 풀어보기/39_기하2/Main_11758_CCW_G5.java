import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [클래스] Main
public class Main_11758_CCW_G5 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	// [메서드] main
	public static void main(String[] args) throws IOException {
		
		// [point]
		double[][] point = new double[4][2];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			point[i][0] = Double.parseDouble(st.nextToken());
			point[i][1] = Double.parseDouble(st.nextToken());
		}
		point[3] = point[0];
		
		// [a] & [b]
		double a = 0;
		double b = 0;
		for (int i = 0; i < 3; i++) {
			a += point[i+1][0] * point[i][1];
			b += point[i][0] * point[i+1][1];
		}
		
		if (a < b) {
			System.out.println(1);
		} else if (a > b) {
			System.out.println(-1);
		} else {
			System.out.println(0);
		}
		
	} // [메서드] main
	
} // [클래스] Main
