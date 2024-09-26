import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// class
public class Main_24416_알고리즘수업피보나치수1_B1 {
	
	static int N;
	static int fibos[];
	static int counter1 = 0;
	static int counter2 = 0;
	
	// main
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		fibos = new int[N];
		fibo1(N);
		fibo2(N);
		System.out.println(counter1);
		System.out.println(counter2);
	} // end of main
	
	// fibo1 (재귀호출)
	static int fibo1(int num) {
		if (num == 1 || num == 2) {
			counter1++;
			return 1;
		} else {
			return fibo1(num-2) + fibo1(num-1);
		}
	} // end of fibo1
	
	// fibo2 (동적 프로그래밍)
	static void fibo2(int num) {
		counter2++;
		fibos[0] = fibos[1] = 1;
		for (int i = 3; i < N; i++) {
			counter2++;
			fibos[i] = fibos[i-2] + fibos[i-1];
		}
	}// end of fibo2
	
} // end of class