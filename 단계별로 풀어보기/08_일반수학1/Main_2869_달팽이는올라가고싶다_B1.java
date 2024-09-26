import java.io.*;
import java.util.*;

public class Main_2869_달팽이는올라가고싶다_B1 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int day = A-B;
		
		V = V + day - 1;
		int result = (V-A)/day+1;
		
		System.out.println(result);
		
	} // end of main
} // end of class

