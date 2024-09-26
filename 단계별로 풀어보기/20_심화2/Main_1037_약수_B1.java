import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1037_약수_B1 {
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int result = 1;
		
		for (int i = 0; i < N; i++) {
			result = getLCM(result, arr[i]);
		}
		
		if (result == arr[arr.length-1]) {
			result *= arr[0];
		}
		
		System.out.println(result);
		
	}
	
	static int getMCM(int a, int b) {
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		int c = a % b;
		while (c != 0) {
			a = b;
			b = c;
			c = a % b;
		}
		return b;
	}
	
	static int getLCM(int a, int b) {
		return a/getMCM(a, b)*b;
	}
}