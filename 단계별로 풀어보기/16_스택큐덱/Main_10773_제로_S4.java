import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


//class
public class Main_10773_제로_S4 {
	
	// main
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		
		for (int k = 0; k < K; k++) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				list.remove(list.size()-1);
			} else {
				list.add(input);
			}
		}
		
		int sum = 0;
		
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		
		System.out.println(sum);
		
	}
	// main
}
// class


