import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// class
public class Main_1932_정수삼각형_S2 {
	
	// main
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N
		int N = Integer.parseInt(br.readLine());
		
		// Memorizer // nums // cums // maximum // num
		List<Integer> Memorizer = new ArrayList<>();
		int nums[] = {0};
		int cums[];
		int maximum = 0;
		int num;
		
		for (int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			cums = new int[n];
			for (int i = 0; i < n; i++) {
				num = Integer.parseInt(st.nextToken());
				if (i == 0) {
					cums[i] = nums[i] + num;
				} else if (i < n-1) {
					cums[i] = Math.max(nums[i-1] + num, nums[i] + num);
				} else {
					cums[i] = nums[i-1] + num;
				}
				if (maximum < cums[i]) {
					maximum = cums[i];
				}
			}
			nums = Arrays.copyOfRange(cums, 0, n);
			
		}
		
		System.out.println(maximum);
		
	} // end of main
	
} // end of class
