import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


//class
public class Main_28278_스택2_S4 {
	
	// main
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int func = Integer.parseInt(st.nextToken());
			if (func == 1) {
				int X = Integer.parseInt(st.nextToken());
				MyStack.func1(X);
			} else if (func == 2) {
				MyStack.func2();
			} else if (func == 3) {
				MyStack.func3();
			} else if (func == 4) {
				MyStack.func4();
			} else if (func == 5) {
				MyStack.func5();
			}
		}
		
	}
	// main
}
// class



// MyStack
class MyStack {
	
	static List<Integer> numbers = new ArrayList<>();
	
	// 1
	static void func1(int a) {
		numbers.add(a);
	}
	// 2
	static void func2() {
		if (numbers.size() == 0) {
			System.out.println(-1);
		} else {
			System.out.println(numbers.get(numbers.size()-1));
			numbers.remove(numbers.size()-1);
		}
	}
	// 3
	static void func3() {
		System.out.println(numbers.size());
	}
	// 4
	static void func4() {
		if (numbers.isEmpty()) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
	// 5
	static void func5() {
		if (numbers.size() == 0) {
			System.out.println(-1);
		} else {
			System.out.println(numbers.get(numbers.size()-1));
		}
	}
	
}
//MyStack