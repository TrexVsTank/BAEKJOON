import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// [클래스] Main
public class Main_2162_선분그룹_P5 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static double[][] line;
	static int[] group;
	static int[] size;
	static int count;
	static double[][] arr = new double[3][2];
	
	// [메서드] main
	public static void main(String[] args) throws IOException {
		
		// [N]
		int N = Integer.parseInt(br.readLine());
		
		// [line]
		line = new double[N][4];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				line[i][j] = Double.parseDouble(st.nextToken());
			}
		}
		
		// [group]
		group = new int[N];
		for (int i = 0; i < N; i++) {
			group[i] = i;
		}
		
		// [size]
		size = new int[N];
		Arrays.fill(size, 1);
		
		// [count]
		count = N;
		
		// RUN
		for (int i = 0; i <= N-2; i++) {
			for (int j = i + 1; j <= N-1; j++) {
				if (find(i) != find(j) && crossCheck(i, j)) {
					union(i, j);
				}
			}
		}
		
		// PRINT
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, size[i]);
		}
		sb.append(count).append("\n").append(max);
		System.out.println(sb);
		
	} // [메서드] main
	
	// [메서드] crossCheck
	private static boolean crossCheck(int l1, int l2) {
		double ccw_l1_l2_0 = CCW(l1, l2, 0);
		double ccw_l1_l2_1 = CCW(l1, l2, 1);
		double ccw_l2_l1_0 = CCW(l2, l1, 0);
		double ccw_l2_l1_1 = CCW(l2, l1, 1);
		if ( ( ccw_l1_l2_0 * ccw_l1_l2_1 < 0 ) && ( ccw_l2_l1_0 * ccw_l2_l1_1 < 0 ) ) {
			return true;
		}
		if ( ccw_l1_l2_0 == 0 && between(line[l1][0], line[l1][2], line[l2][0]) && between(line[l1][1], line[l1][3], line[l2][1]) ) {
			return true;
		}
		if ( ccw_l1_l2_1 == 0 && between(line[l1][0], line[l1][2], line[l2][2]) && between(line[l1][1], line[l1][3], line[l2][3]) ) {
			return true;
		}
		if ( ccw_l2_l1_0 == 0 && between(line[l2][0], line[l2][2], line[l1][0]) && between(line[l2][1], line[l2][3], line[l1][1]) ) {
			return true;
		}
		if ( ccw_l2_l1_1 == 0 && between(line[l2][0], line[l2][2], line[l1][2]) && between(line[l2][1], line[l2][3], line[l1][3]) ) {
			return true;
		}
		return false;
	} // [메서드] crossCheck
	
	// [메서드] CCW
	private static double CCW(int l1, int l2, int p) {
		arr[0][0] = line[l1][0];
		arr[0][1] = line[l1][1];
		arr[1][0] = line[l1][2];
		arr[1][1] = line[l1][3];
		arr[2][0] = line[l2][0 + p * 2];
		arr[2][1] = line[l2][1 + p * 2];
		double a = 0;
		double b = 0;
		for (int i = 0; i < 3; i++) {
			a += arr[i][0] * arr[(i+1)%3][1];
			b += arr[(i+1)%3][0] * arr[i][1];
		}
		return a-b;
	} // [메서드] CCW
	
	// [메서드] union
	private static void union(int a, int b) {
		if (find(a) == find(b)) {
			return;
		}
		size[find(a)] += size[find(b)];
		count--;
		group[find(b)] = find(a);
	} // [메서드] union
	
	// [메서드] find
	private static int find(int num) {
		if (group[num] == num) {
			return num;
		}
		return group[num] = find(group[num]);
	} // [메서드] find
	
	// [메서드] between
	private static boolean between(double n1, double n2, double m) {
		return (n1 <= m && m <= n2) || (n2 <= m && m <= n1);
	} // [메서드] between
	
} // [클래스] Main
