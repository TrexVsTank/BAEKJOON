import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [CLASS]
public class Main_1305_광고_P4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int len;
	static String str;
	static int[] lps;
	
	// [MAIN]
	public static void main(String[] args) throws IOException {
		
		len = Integer.parseInt(br.readLine());
		
		str = br.readLine();
		
		lps = new int[len];
		
		getLen();
		
		int result = len - lps[len - 1];
		
		System.out.println(result);
		
	} // [MAIN]
	
	// [GET LEN]
	private static void getLen() {
		int preIdx = 0;
		for (int sufIdx = 1; sufIdx < len; sufIdx++) {
			while (preIdx > 0 && str.charAt(preIdx) != str.charAt(sufIdx)) {
				preIdx = lps[preIdx - 1];
			}
			if (str.charAt(preIdx) == str.charAt(sufIdx)) {
				preIdx++;
				lps[sufIdx] = preIdx;
			}
		}
	} // [GET LEN]
	
} // [CLASS]
