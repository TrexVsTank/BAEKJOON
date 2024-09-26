import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780_종이의개수_S2 {
	
	static int num_plus = 0;
	static int num_zero = 0;
	static int num_minus = 0;
	
	// main
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cut(paper, 0, N-1, 0, N-1);
		
		System.out.println(num_minus);
		System.out.println(num_zero);
		System.out.println(num_plus);
	}
	// main
	
	// cut
	static void cut(int[][] arr, int r1, int r2, int c1, int c2) {
		int counter_plus = 0;
		int counter_zero = 0;
		int counter_minus = 0;
		for (int i = r1; i <= r2; i++) {
			for (int j = c1; j <= c2; j++) {
				switch (arr[i][j]) {
				case 1:
					counter_plus++;
					break;
				case 0:
					counter_zero++;
					break;
				case -1:
					counter_minus++;
					break;
				}
			}
		}
		if (counter_plus == (r2-r1+1)*(r2-r1+1)) {
			num_plus++;
			return;
		}
		if (counter_zero == (r2-r1+1)*(r2-r1+1)) {
			num_zero++;
			return;
		}
		if (counter_minus == (r2-r1+1)*(r2-r1+1)) {
			num_minus++;
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cut(arr, r1+i*(r2-r1+1)/3, r1+(i+1)*(r2-r1+1)/3-1, c1+j*(r2-r1+1)/3, c1+(j+1)*(r2-r1+1)/3-1);
			}
		}
		
	}
	// cut
	
}