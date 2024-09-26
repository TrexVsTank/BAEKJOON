import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630_색종이만들기_S2 {
	
	static int white = 0;
	static int blue = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cut(paper);
		
		System.out.println(white);
		System.out.println(blue);
		
	}
	
	static void cut(int[][] arr) {
		
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 1) {
					counter++;
				}
			}
		}
		if (counter == 0) {
			white++;
			return;
		}
		if (counter == arr.length*arr.length) {
			blue++;
			return;
		}
		
		int mid = arr.length/2;
		cut(arr, 0, 0, mid-1, mid-1);
		cut(arr, 0, mid, mid-1, arr.length-1);
		cut(arr, mid, 0, arr.length-1, mid-1);
		cut(arr, mid, mid, arr.length-1, arr.length-1);
	}
	
	static void cut(int[][] arr, int r1, int c1, int r2, int c2) {
		
		int counter = 0;
		for (int i = r1; i <= r2; i++) {
			for (int j = c1; j <= c2; j++) {
				if (arr[i][j] == 1) {
					counter++;
				}
			}
		}
		if (counter == 0) {
			white++;
			return;
		}
		if (counter == (r2-r1+1)*(r2-r1+1)) {
			blue++;
			return;
		}
		
		int mid_r = (r1+r2)/2;
		int mid_c = (c1+c2)/2;
		cut(arr, r1, c1, mid_r, mid_c);
		cut(arr, r1, mid_c+1, mid_r, c2);
		cut(arr, mid_r+1, c1, r2, mid_c);
		cut(arr, mid_r+1, mid_c+1, r2, c2);
		
	}
}