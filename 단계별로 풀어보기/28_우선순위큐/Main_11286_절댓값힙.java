import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_11286_절댓값힙 {
	public static void main(String[] args) throws IOException {
		
		PriorityQueue<Integer> Q = new PriorityQueue<>((a, b) -> {
			if (Math.abs(a) == Math.abs(b)) {
				return a-b;
			}
			return Math.abs(a) - Math.abs(b);
		});
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if (input == 0) {
				if (Q.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(Q.poll());
				}
			} else {
				Q.add(input);
			}
		}
		
	}
}