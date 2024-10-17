import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [클래스] Main
public class Main_11723_집합_S5 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static final int FULL = 1048575;
	static final String NL = "\n";
	static int current = 0;
	static int[] pows = new int[21];
	
	// [메서드] main
	public static void main(String[] args) throws IOException {
		
		init();
		
		// [M]
		int M = Integer.parseInt(br.readLine());
		
		// RUN
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String order = st.nextToken();
			int num = 0;
			if (!order.equals("all") && !order.equals("empty")) {
				num = Integer.parseInt(st.nextToken());
			}
			switch (order) {
			case "add":
				add(num);
				break;
			case "remove":
				remove(num);
				break;
			case "check":
				check(num);
				break;
			case "toggle":
				toggle(num);
				break;
			case "all":
				all();
				break;
			case "empty":
				empty();
				break;
			default:
				break;
			}
		}
		
		// PRINT
		System.out.println(sb);
		
	} // [메서드] main
	
	// [메서드] init
	private static void init() {
		pows[1] = 1;
		for (int i = 2; i <= 20; i++) {
			pows[i] = pows[i-1] * 2;
		}
	} // [메서드] init
	
	// [메서드] add
	private static void add(int n) {
		if (current != (current | pows[n])) {
			current += pows[n];
		}
	} // [메서드] add
	
	// [메서드] remove
	private static void remove(int n) {
		if (current == (current | pows[n])) {
			current -= pows[n];
		}
	} // [메서드] remove
	
	// [메서드] check
	private static void check(int n) {
		if (current == (current | pows[n])) {
			sb.append(1).append(NL);
		} else {
			sb.append(0).append(NL);
		}
	} // [메서드] check
	
	// [메서드] toggle
	private static void toggle(int n) {
		if (current == (current | pows[n])) {
			current -= pows[n];
		} else {
			current += pows[n];
		}
	} // [메서드] toggle
	
	// [메서드] all
	private static void all() {
		current = FULL;
	} // [메서드] all
	
	// [메서드] empty
	private static void empty() {
		current = 0;
	} // [메서드] empty
	
} // [클래스] Main
