import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [클래스] Main
public class Main_25308_방사형그래프_G4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static double[] value;
	static int[] located;
	static boolean[] used;
	static double[][] location;
	
	static int counter = 0;
	
	// [메서드] main
	public static void main(String[] args) throws IOException {
		
		// [value]
		value = new double[8];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 8; i++) {
			value[i] = Double.parseDouble(st.nextToken());
		}
		
		// [located]
		located = new int[8];
		
		// [used]
		used = new boolean[8];
		
		// [location]
		location = new double[8][2];
		
		// LOCATE
		locate(0);
		
		// PRINT
		System.out.println(counter);
		
	} // [메서드] main
	
	// [메서드] locate
	static void locate(int idx) {
		if (idx == 8) {
			if (check()) {
				counter++;
			}
			return;
		}
		for (int i = 0; i < 8; i++) {
			if (!used[i]) {
				located[idx] = i;
				used[i] = true;
				locate(idx+1);
				used[i] = false;
			}
		}
	} // [메서드] locate
	
	// [메서드] check
	private static boolean check() {
		// 좌표 입력
		for (int i = 0; i < 8; i++) {
			location[i][0] = Math.cos(Math.PI/2 - Math.PI/4*i) * value[located[i]];
			location[i][1] = Math.sin(Math.PI/2 - Math.PI/4*i) * value[located[i]];
		}
		// 체크
		double[][] arr = new double[3][2];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 3; j++) {
				arr[j][0] = location[(i+j)%8][0];
				arr[j][1] = location[(i+j)%8][1];
			}
			double a = 0;
			double b = 0;
			for (int j = 0; j < 3; j++) {
				a += arr[j][0] * arr[(j+1)%3][1];
				b += arr[(j+1)%3][0] * arr[j][1];
			}
			if (a > b) {
				return false;
			}
		}
		return true;
	} // [메서드] check
	
} // [클래스] Main
