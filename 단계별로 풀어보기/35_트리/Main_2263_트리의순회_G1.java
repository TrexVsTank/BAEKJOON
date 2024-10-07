import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [클래스] Main
public class Main_2263_트리의순회_G1 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int[] inOrder;
	static int[] postOrder;
	
	// [메서드] main
	public static void main(String[] args) throws IOException {
		
		// [N] 정점의 수 | 1 ~ 100,000
		N = Integer.parseInt(br.readLine());
		
		// [inOrder]
		inOrder = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) { inOrder[i] = Integer.parseInt(st.nextToken()); }
		
		// [postOrder]
		postOrder = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) { postOrder[i] = Integer.parseInt(st.nextToken()); }
		
		append_Preorder(0, N-1, 0, N-1);
		
		System.out.println(sb);
	} // [메서드] main
	
	// [메서드] append_Preorder
	private static void append_Preorder(int in_S, int in_E, int po_S, int po_E) {
		if (in_S <= in_E && po_S <= po_E) {
			sb.append(postOrder[po_E]).append(" ");
			
			int in_M = 0;
			for (int i = in_S; i <= in_E; i++) {
				if (inOrder[i] == postOrder[po_E]) {
					in_M = i;
				}
			}
			
			int po_M = po_S + (in_M-in_S);
			
			append_Preorder(in_S, in_M-1, po_S, po_M-1);
			append_Preorder(in_M+1, in_E, po_M, po_E-1);
		}
	} // [메서드] append_Preorder
	
} // [클래스] Main
