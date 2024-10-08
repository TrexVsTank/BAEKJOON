import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [클래스] 메인
public class Main_1991_트리순회_S1 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
		
	static int N;
	static Node arr[];
	
	// [메서드] 메인
	public static void main(String[] args) throws IOException {
		
		// [N] 노드의 수 (1 ~ 26)
		N = Integer.parseInt(br.readLine());
		
		// [arr]
		arr = new Node[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			char parent = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			if (arr[parent-'A'] == null) {
				arr[parent-'A'] = new Node(parent);
			}
			if (left != '.') {
				arr[left-'A'] = new Node(left);
				arr[parent-'A'].left = arr[left-'A'];
			}
			if (right != '.') {
				arr[right-'A'] = new Node(right);
				arr[parent - 'A'].right = arr[right-'A'];
			}
		}
		
		// 순회
		Preorder(arr[0]);
		sb.append("\n");
		Inorder(arr[0]);
		sb.append("\n");
		Postorder(arr[0]);
		
		// 출력
		System.out.println(sb);
		
	} // [메서드] 메인
	
	// [메서드] 전위순회
	private static void Preorder(Node node) {
		if (node == null) {
			return;
		}
		sb.append(node.value);
		Preorder(node.left);
		Preorder(node.right);
	} // [메서드] 전위순회
	
	// [메서드] 중위순회
	private static void Inorder(Node node) {
		if (node == null) {
			return;
		}
		Inorder(node.left);
		sb.append(node.value);
		Inorder(node.right);
	} // [메서드] 중위순회
	
	// [메서드] 후위순회
	private static void Postorder(Node node) {
		if (node == null) {
			return;
		}
		Postorder(node.left);
		Postorder(node.right);
		sb.append(node.value);
	} // [메서드] 후위순회
	
	// [클래스] 노드
	private static class Node{
		Node left;
		Node right;
		char value;
		public Node() {
		}
		public Node(char value) {
			this.value = value;
		}
	} // [클래스] 노드
	
} // [클래스] 메인
