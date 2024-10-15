import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [클래스] Main
public class Main_20149_선분교차3_P4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static double[][] point;
	static int result1;
	static double[] result2;
			
	// [메서드] main
	public static void main(String[] args) throws IOException {
		
		// [point]
		point = new double[4][2];
		
		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				point[j + i*2][0] = Double.parseDouble(st.nextToken());
				point[j + i*2][1] = Double.parseDouble(st.nextToken());
			}
		}
		
		crossCheck();
		if (result1 == 1) {
			sb.append(1).append("\n");
			sb.append(result2[0]).append(" ").append(result2[1]);
			System.out.println(sb);
			System.exit(0);
		}
		
		touchCheck();
		if (result1 == 1) {
			sb.append(1).append("\n");
			sb.append(result2[0]).append(" ").append(result2[1]);
			System.out.println(sb);
			System.exit(0);
		}
		
		linkCheck();
		if (result1 == 1) {
			sb.append(1).append("\n");
			sb.append(result2[0]).append(" ").append(result2[1]);
			System.out.println(sb);
			System.exit(0);
		}
		
		mergeCheck();
		if (result1 == 1) {
			System.out.println(1);
			System.exit(0);
		}
		
		System.out.println(0);
		
		// PRINT
		
	} // [메서드] main
	
	// [메서드] mergeCheck
	private static void mergeCheck() {
		if (
				(CCW(0, 1, 2) == 0 && between(point[0][0], point[1][0], point[2][0]) && between(point[0][1], point[1][1], point[2][1]) && CCW(0, 1, 3) == 0)
				||
				(CCW(0, 1, 3) == 0 && between(point[0][0], point[1][0], point[3][0]) && between(point[0][1], point[1][1], point[3][1]) && CCW(0, 1, 2) == 0)
				||
				(CCW(2, 3, 0) == 0 && between(point[2][0], point[3][0], point[0][0]) && between(point[2][1], point[3][1], point[0][1]) && CCW(2, 3, 1) == 0)
				||
				(CCW(2, 3, 1) == 0 && between(point[2][0], point[3][0], point[1][0]) && between(point[2][1], point[3][1], point[1][1]) && CCW(2, 3, 0) == 0)
				) {
			result1 = 1;
		}
	} // [메서드] mergeCheck
		
	// [메서드] linkCheck
	private static void linkCheck() {
		if (CCW(0, 1, 2) == 0 && ( (point[2][0] == point[0][0] && point[2][1] == point[0][1]) || (point[2][0] == point[1][0] && point[2][1] == point[1][1]) ) && CCW(0, 1, 3) == 0 && ( !between(point[0][0], point[1][0], point[2][0] + (point[3][0] - point[2][0])/1000) || !between(point[0][1], point[1][1], point[2][1] + (point[3][1] - point[2][1])/1000) )) {
			result1 = 1;
			result2 = new double[] {point[2][0], point[2][1]};
		} else if (CCW(0, 1, 3) == 0 && ( (point[3][0] == point[0][0] && point[3][1] == point[0][1]) || (point[3][0] == point[1][0] && point[3][1] == point[1][1]) ) && CCW(0, 1, 2) == 0 && ( !between(point[0][0], point[1][0], point[3][0] + (point[2][0] - point[3][0])/1000) || !between(point[0][1], point[1][1], point[3][1] + (point[2][1] - point[3][1])/1000) )) {
			result1 = 1;
			result2 = new double[] {point[3][0], point[3][1]};
		} else if (CCW(2, 3, 0) == 0 && ( (point[0][0] == point[2][0] && point[0][1] == point[2][1]) || (point[0][0] == point[3][0] && point[0][1] == point[3][1]) ) && CCW(2, 3, 1) == 0 && ( !between(point[2][0], point[3][0], point[0][0] + (point[1][0] - point[0][0])/1000) || !between(point[2][1], point[3][1], point[0][1] + (point[1][1] - point[0][1])/1000) )) {
			result1 = 1;
			result2 = new double[] {point[0][0], point[0][1]};
		} else if (CCW(2, 3, 1) == 0 && ( (point[1][0] == point[2][0] && point[1][1] == point[2][1]) || (point[1][0] == point[3][0] && point[1][1] == point[3][1]) ) && CCW(2, 3, 0) == 0 && ( !between(point[2][0], point[3][0], point[1][0] + (point[0][0] - point[1][0])/1000) || !between(point[2][1], point[3][1], point[1][1] + (point[0][1] - point[1][1])/1000) )) {
			result1 = 1;
			result2 = new double[] {point[1][0], point[1][1]};
		}
	} // [메서드] linkCheck

	// [메서드] touchCheck
	private static void touchCheck() {
		if ((CCW(0, 1, 2) == 0 && between(point[0][0], point[1][0], point[2][0]) && between(point[0][1], point[1][1], point[2][1]) && CCW(0, 1, 3) != 0)) {
			result1 = 1;
			result2 = new double[] {point[2][0], point[2][1]};
		} else if ((CCW(0, 1, 3) == 0 && between(point[0][0], point[1][0], point[3][0]) && between(point[0][1], point[1][1], point[3][1]) && CCW(0, 1, 2) != 0)) {
			result1 = 1;
			result2 = new double[] {point[3][0], point[3][1]};
		} else if ((CCW(2, 3, 0) == 0 && between(point[2][0], point[3][0], point[0][0]) && between(point[2][1], point[3][1], point[0][1]) && CCW(2, 3, 1) != 0)) {
			result1 = 1;
			result2 = new double[] {point[0][0], point[0][1]};
		} else if((CCW(2, 3, 1) == 0 && between(point[2][0], point[3][0], point[1][0]) && between(point[2][1], point[3][1], point[1][1]) && CCW(2, 3, 0) != 0)) {
			result1 = 1;
			result2 = new double[] {point[1][0], point[1][1]};
		}
	} // [메서드] touchCheck
	
	// [메서드] between
	private static boolean between(double n1, double n2, double m) {
		return (n1 <= m && m <= n2) || (n2 <= m && m <= n1);
	} // [메서드] between
	
	// [메서드] crossCheck
	private static void crossCheck() {
		if (CCW(0, 1, 2) * CCW(0, 1, 3) < 0 && CCW(2, 3, 0) * CCW(2, 3, 1) < 0) {
			result1 = 1;
			result2 = new double[2];
			double a = (point[1][1] - point[0][1]) / (point[1][0] - point[0][0]);
			double b = point[0][1] - a * point[0][0];
			double c = (point[3][1] - point[2][1]) / (point[3][0] - point[2][0]);
			double d = point[2][1] - c * point[2][0];
			result2[0] = (d - b) / (a - c);
			result2[1] = result2[0] * a + b;
			if (Math.abs(a) > 1_000_000_000) {
				result2[0] = point[0][0];
				result2[1] = point[0][0] * c + d;
			} else if (Math.abs(c) > 1_000_000_000) {
				result2[0] = point[2][0];
				result2[1] = point[2][0] * a + b;
			}
		}
	} // [메서드] corssCheck
	
	// [메서드] CCW
	private static double CCW(int n1, int n2, int m) {
		// get coordinates
		double[][] coor = new double[3][2];
		for (int i = 0; i < 2; i++) {
			coor[0][i] = point[n1][i]; coor[1][i] = point[n2][i]; coor[2][i] = point[m][i];
		}
		// calculate counter clock wise
		double a = 0;
		double b = 0;
		for (int i = 0; i < 3; i++) {
			a += coor[i][0] * coor[(i+1)%3][1];
			b += coor[(i+1)%3][0] * coor[i][1];
		}
		return a-b;
	}
	// [메서드] CCW
	
} // [클래스] Main
