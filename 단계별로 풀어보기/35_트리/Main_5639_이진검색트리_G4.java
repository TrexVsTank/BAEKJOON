import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
//import java.util.StringTokenizer;

// [클래스] Main
public class Main_5639_이진검색트리_G4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static List<Node> preOrder;
	
	// [메서드] main
	public static void main(String[] args) throws IOException {
		
		// [preOrder]
		preOrder = new ArrayList<>();
		String input = br.readLine();
		while (input != null) {
			preOrder.add(new Node(Integer.parseInt(input)));
			input = br.readLine();
		}
		
		linkNode(0, preOrder.size()-1);
		
		appendPostOrder(preOrder.get(0));
		
		System.out.println(sb);
		
	} // [메서드] main
	
	// [메서드] appendPostOrder
	private static void appendPostOrder(Node node) {
		if (node != null) {
			appendPostOrder(node.left);
			appendPostOrder(node.right);
			sb.append(node.value).append("\n");
		}
	} // [메서드] appendPostOrder
	
	// [메서드] linkNode
	private static void linkNode(int start, int end) {
		if (0 <= start && start < end) {
			Node node_Top = preOrder.get(start);
			int ls = -1;
			int le = -2;
			int rs = -1;
			int re = -2;
			for (int i = start+1; i <= end; i++) {
				if (preOrder.get(i).value < node_Top.value) {
					ls = i;
					le = i;
					break;
				}
			}
			for (int i = Math.max(start+1, ls+1); i <= end; i++) {
				if (preOrder.get(i).value < node_Top.value) {
					le = i;
				} else {
					rs = i;
					re = i;
					break;
				}
			}
			for (int i = Math.max(start+1, rs+1); i <= end; i++) {
				if (preOrder.get(i).value > node_Top.value) {
					re = i;
				}
			}
			if (ls > 0) {
				node_Top.left = preOrder.get(ls);
			}
			if (rs > 0) {
				node_Top.right = preOrder.get(rs);
			}
			linkNode(ls, le);
			linkNode(rs, re);
		}
	} // [메서드] linkNode
	
	// [클래스] Node
	private static class Node{
		int value;
		Node left;
		Node right;
		public Node() {
			
		}
		public Node(int value) {
			this.value = value;
		}
	} // [클래스] Node
	
} // [클래스] Main
