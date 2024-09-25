import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2884_알람시계_B3 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int H2 = H;
		int M2 = M-45;
		
		if(M2 < 0) {
			M2 += 60;
			H2--;
		}
		
		if(H2 < 0) {
			H2 += 24;
		}
		
		System.out.println(H2 + " " + M2);
		
	} // end of main
} // end of class
