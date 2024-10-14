import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [클래스] Main
public class Main_2166_다각형의면적_G5 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	// [메서드] main
	public static void main(String[] args) throws IOException {
		
		// [N]
		int N = Integer.parseInt(br.readLine());
		
		// [point]
		double[][] point = new double[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			point[i][0] = x;
			point[i][1] = y;
		}
		
		// [var_A]
		double var_A = 0;
		for (int i = 0; i < N; i++) {
			var_A += point[i][0] * point[(i+1)%N][1];
		}
		
		// [var_B]
		double var_B = 0;
		for (int i = 0; i < N; i++) {
			var_B += point[i][0] * point[(i-1+N)%N][1];
		}
		
		// PRINT
		System.out.printf("%.1f", (Math.abs(var_A - var_B) / 2.0));
		
	} // [메서드] main
	
} // [클래스] Main
