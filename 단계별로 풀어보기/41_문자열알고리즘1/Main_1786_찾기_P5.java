import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// [CLASS]
public class Main_1786_찾기_P5 {
	
	static StringBuilder sb = new StringBuilder();
	static int count = 0;
	
	static String sentence;
	static String word;
	static int lenS;
	static int lenW;
	static int[] LPS;
	
	// [MAIN]
	public static void main(String[] args) throws IOException {
		
		input();
		
		getLPS();
		
		KMP();
		
		System.out.println(count);
		System.out.println(sb);
		
	} // [MAIN]
	
	// [KMP]
	private static void KMP() {
		int idxW = 0;
		for (int idxS = 0; idxS < lenS; idxS++) {
			if (sentence.charAt(idxS) == word.charAt(idxW)) {
				idxW++;
				if (idxW == lenW) {
					count++;
					sb.append(idxS - lenW + 2).append(" ");
					idxW = LPS[idxW-1];
				}
			} else {
				while (idxW > 0 && sentence.charAt(idxS) != word.charAt(idxW)) {
					idxW = LPS[idxW-1];
				}
				if (sentence.charAt(idxS) == word.charAt(idxW)) {
					idxW++;
				}
			}
		}
	} // [KMP]
	
	// [get LPS]
	private static void getLPS() {
		int idx = 0;
		for (int k = 1; k < lenW; k++) {
			while (idx > 0 && word.charAt(k) != word.charAt(idx)) {
				idx = LPS[idx-1];
			}
			if (word.charAt(k) == word.charAt(idx)) {
				idx++;
				LPS[k] = idx;
			}
		}
	} // [get LPS]
	
	// [INPUT]
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sentence = br.readLine();
		lenS = sentence.length();
		word = br.readLine();
		lenW = word.length();
		LPS = new int[lenW];
	} // [INPUT]
	
} // [CLASS]
