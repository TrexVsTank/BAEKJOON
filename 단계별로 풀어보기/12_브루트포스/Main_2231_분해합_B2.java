import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2231_분해합_B2 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String n = br.readLine();
		int N = Integer.parseInt(n);
		// 0. 입력
		
		int num1 = n.length();
		int num2 = 0;
		int num3 = 0;
		int result = 0;
		
		for (int i = 1; i <= N; i++) {
			
			int arr1[] = new int[num1];
			arr1[0] = i % 10;
			num2 = 10;
			
			for (int j = 1; j < num1; j++) {
				num2 *= 10;
				arr1[j] = i % num2 - arr1[j-1];
			}
			
			num3 = i;
			num2 = 1;
			for (int j = 0; j < num1; j++) {
				
				num3 += arr1[j]/num2;
				num2 *= 10;
			}
			
			if (num3 == N) {
				result = i;
				break;
			}
			
		}

//		System.out.println(num3);
		System.out.println(result);
		
	} // end of main
} // end of class
