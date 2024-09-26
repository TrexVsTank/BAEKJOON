import java.io.*;
import java.util.*;

public class Main_3009_네번째점_B3 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int[] x = new int[3];
		int[] y = new int[3];
		
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		if (x[0] == x[1]) {
			sb.append(x[2]);
		} else if (x[1] == x[2]) {
			sb.append(x[0]);
		} else {
			sb.append(x[1]);
		}
		
		sb.append(" ");
		
		if (y[0] == y[1]) {
			sb.append(y[2]);
		} else if (y[1] == y[2]) {
			sb.append(y[0]);
		} else {
			sb.append(y[1]);
		}
		
		System.out.println(sb);
		
	} // end of main
} // end of class

