import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_2164_카드2_S4 {
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> D = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			D.offerFirst(i);
		}
		
		while (D.size() > 1) {
			D.pollLast();
			D.offerFirst(D.pollLast());
		}
		
		System.out.println(D.peek());
		
	}
}