import java.io.*;
import java.util.*;

public class Main_2501_약수구하기_B3 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int num = 0;
		while (q != 0) {
			num++;
			if (p % num == 0) {
				q--;
			}
			if (num == p+1) {
				num = 0;
				break;
			}
		}
		
		System.out.println(num);
		
	} // end of main
} // end of class

