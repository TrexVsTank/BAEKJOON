import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

// [CLASS]
public class Main_5670_휴대폰자판_P4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static String input;
	static int num;
	static String[] dic;
	static Try T;
	static double inputTime;
	
	// [MAIN]
	public static void main(String[] args) throws IOException {
		input = br.readLine();
		
		while (input != null && input != "") {
			num = Integer.parseInt(input);
			
			dic = new String[num];
			
			T = new Try();
			
			inputTime = 0;
			
			for (int n = 0; n < num; n++) {
				String word = br.readLine();
				dic[n] = word;
				T.add(word);
			}
			
			for (int n = 0; n < num; n++) {
				Node node = T.root;
				for (int w = 0; w < dic[n].length(); w++) {
					Character c = dic[n].charAt(w);
					if (w == 0 || node.child.size() > 1 || (node.isEnd && node.child.size() == 1)) {
						inputTime++;
					}
					node = node.child.get(c);
				}
			}
			
			inputTime /= num;
			
			System.out.printf("%.2f\n", inputTime);
			
			input = br.readLine();
		}
	} // [MAIN]
	
	// [TRI]
	private static class Try {
		Node root;
		public Try() {
			this.root = new Node();
		}
		public void add(String word) {
			Node node = this.root;
			for (Character c : word.toCharArray()) {
				node.child.putIfAbsent(c, new Node());
				node = node.child.get(c);
			}
			node.isEnd = true;
		}
	} // [TRI]
	
	// [Node]
	private static class Node {
		Map<Character, Node> child;
		boolean isEnd;
		public Node() {
			this.child = new HashMap<>();
		}
	} // [Node]
	
} // [CLASS]
