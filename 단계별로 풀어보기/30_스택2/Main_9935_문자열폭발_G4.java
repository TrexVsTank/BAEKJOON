import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 클래스
public class Main_9935_문자열폭발_G4 {
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		String kill = br.readLine();
		
		Deque<Character> D = new ArrayDeque<>();
		
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			D.offerLast(c);
			if (D.peekLast() == kill.charAt(kill.length()-1)) {
				String str = ""+D.pollLast();
				while (!D.isEmpty() && str.length() < kill.length()) {
					str = D.pollLast() + str;
				}
				if (str.equals(kill)) {
				} else {
					for (int j = 0; j < str.length(); j++) {
						D.offerLast(str.charAt(j));
					}
				}
			}
		}
		
//		// 메모리 초과 //
//		if (D.isEmpty()) {
//			System.out.println("FRULA");
//		} else {
//			String str = "";
//			while (!D.isEmpty()) {
//				str += D.pollFirst();
//			}
//			System.out.println(str);
//		}
//		// 메모리 초과 //
		
		// 통과 //
		if (D.isEmpty()) {
			sb.append("FRULA");
		} else {
			while (!D.isEmpty()) {
				sb.append(D.pollFirst());
			}
		}
		System.out.println(sb);
		// 통과 //
		
	} // 메인 끝
	
} // 클래스 끝