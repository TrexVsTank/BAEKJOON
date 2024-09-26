import java.io.*;
import java.util.*;

public class Main_2581_소수_B2 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		List<Integer> prime = new ArrayList<>();
		prime.add(2);
		for (int n = 3; n <= 10000; n++) {
			int checker = 0;
			for (int p = 0; p < prime.size(); p++) {
				if (n % prime.get(p) == 0) {
					checker++;
					break;
				}
			}
			if (checker != 0) {
				continue;
			} else {
				prime.add(n);
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<Integer> myList = new ArrayList<>();
		
		for (int p = 0; p < prime.size(); p++) {
			if (M < prime.get(p)) {
				break;
			}
			if (N <= prime.get(p) && prime.get(p) <= M) {
				myList.add(prime.get(p));
			}
		}
		
		int sum = 0;
		
		for (int i = 0; i < myList.size(); i++) {
			sum += myList.get(i);
		}
		
		if (myList.size() == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(myList.get(0));
		}
		
	} // end of main
} // end of class

