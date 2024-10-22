import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

// [CLASS]
public class Main_14725_개미굴_G3 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static Node curr;
	
	// [MAIN]
	public static void main(String[] args) throws IOException {
		
		TreeMap<String, Node> tree = new TreeMap<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			for (int level = 0; level < M; level++) {
				String value = st.nextToken();
				if (level == 0) {
					if (tree.get(value) == null) {
						Node node = new Node(value, level);
						tree.put(value, node);
					}
					curr = tree.get(value);
					continue;
				}
				if (curr.child.get(value) == null) {
					Node node = new Node(value, level);
					curr.child.put(value, node);
				}
				curr = curr.child.get(value);
			}
		}
		
		preOrder(tree);
		
		System.out.println(sb);
		
	} // [MAIN]
	
	// [PRE ORDER]
	private static void preOrder(TreeMap<String, Node> tree) {
		for (String value : tree.keySet()) {
			Node node = tree.get(value);
			for (int i = 0; i < node.level; i++) {
				sb.append("--");
			}
			sb.append(value).append("\n");
			preOrder(node.child);
		}
	} // [PRE ORDER]
	
	// [NODE]
	private static class Node implements Comparable<Node> {
		String value;
		int level;
		TreeMap<String, Node> child;
		
		public Node(String value, int level) {
			this.value = value;
			this.level = level;
			this.child = new TreeMap<>();
		}

		@Override
		public int compareTo(Main_14725_개미굴_G3.Node o) {
			return this.value.compareTo(o.value);
		}
	} // [NODE]
	
} // [CLASS]
