import java.io.*;
import java.util.*;

public class Main_5073_삼각형과세변_B3 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		
		while (!(input.equals("0 0 0"))) {
			
			StringTokenizer stLocal = new StringTokenizer(input, " ");
			
			int a = Integer.parseInt(stLocal.nextToken());
			int b = Integer.parseInt(stLocal.nextToken());
			int c = Integer.parseInt(stLocal.nextToken());
			
			if (a+b<=c||a+c<=b||b+c<=a) {
				System.out.println("Invalid");
			} else if (a == b && a == c) {
				System.out.println("Equilateral");
			} else if (a == b || a == c || b == c) {
				System.out.println("Isosceles");
			} else {
				System.out.println("Scalene");
			}
			
			input = br.readLine();
		}
		
	} // end of main
} // end of class

