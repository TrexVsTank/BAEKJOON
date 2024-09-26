import java.io.*;
import java.util.*;

public class Main_2720_세탁소사장동혁_B3 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int money = Integer.parseInt(br.readLine());
			
			int[] don = {25, 10, 5, 1};
			
			int[] num = {0, 0, 0, 0};
			
			for (int j = 0; j < 4; j++) {
				while (don[j] <= money) {
					money -= don[j];
					num[j]++;
				}
				sb.append(num[j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	} // end of main
} // end of class

