import java.io.*;
import java.util.*;

public class Main_2292_벌집_B2 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int num1 = 1;
		int num6 = 0;
		int count = 1;
		
		if (N == 1) {
			System.out.println(1);
		} else {
			while (count < N) {
				num1++;
				num6 += 6;
				count += num6;
			}
			System.out.println(num1);
		}
		
		
	} // end of main
} // end of class

