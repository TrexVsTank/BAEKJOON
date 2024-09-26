import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_24265_알고리즘수업알고리즘의수행시간4_B3 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		double n = Double.parseDouble(br.readLine());
		
		
		System.out.printf("%.0f\n", n*((n-1)/2));
		System.out.println(2);
		
	} // end of main
} // end of class
