import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 클래스
public class Main_1644_소수의연속합_G3 {
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		List<Integer> primes = new ArrayList<>();
		primes.add(0);
		for (int n = 2; n <= 4_000_000; n++) {
			if (isPrime(n)) {
				primes.add(n);
			}
		}
		
		int[] arr = new int[primes.size()];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = arr[i-1] + primes.get(i);
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int left = 0;
		int right = 1;
		int result = 0;
		
		while (right < arr.length && primes.get(right) < N+1) {
			if (arr[right] - arr[left] == N) {
				left++;
				right++;
				result++;
				continue;
			}
			if (arr[right] - arr[left] > N) {
				left++;
				continue;
			}
			if (arr[right] - arr[left] < N) {
				right++;
				continue;
			}
		}
		
		System.out.println(result);
		
	} // 메인 끝
	
	// 소수판정
	static boolean isPrime(int num) {
		if (num <= 2) {
			return true;
		}
		for (int n = 2; n <= Math.sqrt(num); n++) {
			if (num % n == 0) {
				return false;
			}
		}
		return true;
	}
	
} // 클래스 끝
