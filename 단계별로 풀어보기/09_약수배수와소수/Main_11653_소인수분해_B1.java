import java.io.*;
import java.util.*;

public class Main_11653_소인수분해_B1 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		if (N != 1) {
			int num = 2;
			while (N != 1) {
				while (N % num == 0) {
					N /= num;
					sb.append(num).append("\n");
				}
				num++;
			}
		}
		
		System.out.println(sb);
		
	} // end of main
} // end of class

