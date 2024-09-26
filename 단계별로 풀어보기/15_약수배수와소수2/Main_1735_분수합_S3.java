import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1735_분수합_S3 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		int c = Integer.parseInt(st2.nextToken());
		int d = Integer.parseInt(st2.nextToken());
		
		int A = a;
		int B = b;
		int C = c;
		int D = d;
		
		while (B != D) {
			if (B < D) {
				A += a;
				B += b;
			} else {
				C += c;
				D += d;
			}
		}
		
		int AC = A+C;
		
		for (int i = B; i >= 1; i--) {
			if (B % i == 0 && AC % i == 0) {
				B /= i;
				AC /= i;
			}
		}
		
		System.out.println(AC + " " + B);
		
	} // end of main
} // end of class

