import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [클래스] Main
public class Main_1069_집으로_G3 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	// [메서드] main
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		
		// [X] [Y] [D] [T]
		double X = Double.parseDouble(st.nextToken());
		double Y = Double.parseDouble(st.nextToken());
		double D = Double.parseDouble(st.nextToken());
		double T = Double.parseDouble(st.nextToken());
		
		// [distance]
		double distance = Math.sqrt(X * X + Y * Y);
		
		// [result]
		double result = distance; // 걷
		
		// CALCULATE
		if (distance < D) {
			result = Math.min(result, T + D - distance); // 텔 백
			result = Math.min(result, 2 * T); // 2 텔
		} else {
			// n 텔
			result = Math.min(result, T * Math.ceil(distance / D));
			// n-1 텔 걷
			result = Math.min(result, T * Math.floor(distance / D) + (distance - D * Math.floor(distance / D)) );
		}
		
		// PRINT
		System.out.println(result);
		
	} // [메서드] main
	
} // [클래스] Main
