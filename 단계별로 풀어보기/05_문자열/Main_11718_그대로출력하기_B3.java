import java.io.*;
import java.util.*;

public class Main_11718_그대로출력하기_B3 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 0. 입력
		
		// 1. 풀이
		
		List<String> list = new ArrayList<>();
		
		String input = br.readLine();
		
		while (input != null) {
			
			list.add(input);
			
			System.out.println(input);

			input = br.readLine();
			
		}
		
		// 1. 풀이
		
	} // end of main
} // end of class

