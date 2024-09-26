import java.io.*;
import java.util.*;

public class Main_11005_진법변환2_B1 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		
		long b = 1;
		long len = 0;
		
		while (b <= N) {
			b *= B;
			len++;
		}
		
		
		List<Long> list = new ArrayList<>();
		
		for (int i = 0; i < len; i++) {
			b /= B;
			long n = 0;
			n = N/b;
			list.add(n);
			N -= n*b;
		}
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < 10) {
				sb.append(list.get(i));
			} else if (list.get(i) < 36) {
				sb.append((char)(55+list.get(i)));
			} else {
				sb.append(1);
			}
		}

		System.out.println(sb);
		
		
	} // end of main
} // end of class

