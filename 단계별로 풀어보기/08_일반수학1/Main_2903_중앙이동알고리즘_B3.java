import java.io.*;
import java.util.*;

public class Main_2903_중앙이동알고리즘_B3 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int num = 2;
		
		for (int i = 0; i < N; i++) {
			num = num + num-1;
		}
		
		System.out.println(num*num);
		
	} // end of main
} // end of class

