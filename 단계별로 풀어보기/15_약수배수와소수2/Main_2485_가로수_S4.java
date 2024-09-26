import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main_2485_가로수_S4 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
//		int a = 5;
//		int b = 0;
//		while (b > 0) {
//			int c = a % b;
//			a = b;
//			b = c;
//		}
//		System.out.println(a);
		
		int N = Integer.parseInt(br.readLine());
		int[] arrInput = new int[N];
		for (int i = 0; i < N; i++) {
			arrInput[i] = Integer.parseInt(br.readLine());
		}
		int n1 = arrInput[0];
		for (int i = 0; i < N; i++) {
			arrInput[i] -= n1;
		}
		
		int u = arrInput[1];
		for (int i = 1; i < N-1; i++) {
			int a = arrInput[i+1];
			int b = u;
			while (b > 0) {
				int c = a % b;
				a = b;
				b = c;
			}
			u = a;
		}
		
		System.out.println(arrInput[arrInput.length-1]/u-arrInput.length+1);
		
	} // end of main
} // end of class

