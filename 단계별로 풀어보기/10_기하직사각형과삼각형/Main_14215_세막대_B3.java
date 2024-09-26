import java.io.*;
import java.util.*;

public class Main_14215_세막대_B3 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		
		StringTokenizer stLocal = new StringTokenizer(input, " ");
		
		int a = Integer.parseInt(stLocal.nextToken());
		int b = Integer.parseInt(stLocal.nextToken());
		int c = Integer.parseInt(stLocal.nextToken());
		
		while (true) {
			if (b+c<=a) {
				a--;
			} else if (a+c<=b) {
				b--;
			} else if (a+b<=c) {
				c--;
			} else {
				break;
			}
		}
		
		System.out.println(a+b+c);
		
	} // end of main
} // end of class

