import java.io.*;
import java.util.*;

public class Main_2941_크로아티아알파벳_S5 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		String myWord = br.readLine();
		
		// 0. 입력
		
		// 1. 풀이
		
		String[] croAlpha = {"dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z="};
		
		int len = myWord.length();
		
		int result = 0;
		
		int idx = 0;
		
		while (idx < myWord.length()) {
			for (int i = 0; i < croAlpha.length; i++) {
				if (idx+croAlpha[i].length() <= myWord.length() && croAlpha[i].equals(myWord.substring(idx, idx+croAlpha[i].length()))) {
					result++;
					len -= croAlpha[i].length();
					idx += croAlpha[i].length()-1;
				}
			}
			idx++;
		}
		
		result += len;
		
		System.out.println(result);
		
		// 1. 풀이
		
	} // end of main
} // end of class

