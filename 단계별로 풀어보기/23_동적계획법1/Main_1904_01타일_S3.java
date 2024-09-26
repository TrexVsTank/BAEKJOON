import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// class
public class Main_1904_01타일_S3 {
	
	static int N;
	static int arr[];
	
	// main
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		System.out.println(zero_one_tile(N-1)%15746);
		
	} // end of main
	
	// zero_one_tile
	static int zero_one_tile(int index) {
		if (arr[index] != 0) {
			return arr[index];
		} else {
			if (index == 0) {
				arr[index] = 1;
				return 1;
			} else if (index == 1) {
				arr[index] = 2;
				return 2;
			} else {
				if (15746 < zero_one_tile(index-2) + zero_one_tile(index-1)) {
					arr[index] = (zero_one_tile(index-2) + zero_one_tile(index-1))%15746;
					return (zero_one_tile(index-2) + zero_one_tile(index-1))%15746;
				} else {
					arr[index] = zero_one_tile(index-2) + zero_one_tile(index-1);
					return zero_one_tile(index-2) + zero_one_tile(index-1);
				}
			}
		}
	} // end of zero_one_tile
	
} // end of class