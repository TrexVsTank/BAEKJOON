import java.io.*;
import java.util.*;

public class Main_1316_그룹단어체커_S5 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		String[] words = new String[N];
		
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		
		// 0. 입력
		
		// 1. 풀이
		
		int result = N;
		
		int checker1 = 0;
		
		int checker2 = 0;
		
		for (int i = 0; i < N; i++) {
			checker2 = 0;
			for (int j = 0; j < words[i].length(); j++) {
				checker1 = 0;
				for (int k = j+1; k < words[i].length(); k++) {
					if (words[i].charAt(j) != words[i].charAt(k)) {
						checker1++;
					}
					if (checker1 != 0 && words[i].charAt(j) == words[i].charAt(k)) {
						checker2++;
					}
				}
			}
			if (checker2 != 0) {
				result--;
			}
		}
		
		System.out.println(result);
		
		// 1. 풀이
		
	} // end of main
} // end of class

