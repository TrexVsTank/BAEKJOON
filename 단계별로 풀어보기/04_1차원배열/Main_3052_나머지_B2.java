import java.io.*;
import java.util.*;

public class Main_3052_나머지_B2 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Set<Integer> set = new HashSet<>();
		
		for (int i = 0; i < 10; i++) {
			int numTem = Integer.parseInt(br.readLine());
			set.add(numTem%42);
		}
		
		// 0. 입력
		
		// 1. 풀이
		
		System.out.println(set.size());
		
		// 1. 풀이
		
	} // end of main
} // end of class

