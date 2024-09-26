import java.io.*;
import java.util.*;

public class Main_5086_배수와약수_B3 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		while (!input.equals("0 0")) {
			StringTokenizer st = new StringTokenizer(input, " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if (B % A == 0 && B / A > 0) {
				System.out.println("factor");
			} else if (A % B == 0 && A / B > 0) {
				System.out.println("multiple");
			} else {
				System.out.println("neither");
			}
			input = br.readLine();
		}
		
		
	} // end of main
} // end of class

