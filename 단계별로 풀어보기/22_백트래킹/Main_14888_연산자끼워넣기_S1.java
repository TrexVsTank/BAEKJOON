import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// class
public class Main_14888_연산자끼워넣기_S1 {
	
	static int N;
	static int numbers[];
	static int comparators[];
	
	static int comps[];
	static int maximum;
	static int minimum;
	
	// main
	public static void main(String[] args) throws IOException {
		
		// Input
		minimum = Integer.MAX_VALUE;
		maximum = Integer.MIN_VALUE;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer stNum = new StringTokenizer(br.readLine(), " ");
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(stNum.nextToken());
		}
		
		comps = new int[N-1];
		
		StringTokenizer stCom = new StringTokenizer(br.readLine(), " ");
		comparators = new int[4];
		for (int i = 0; i < 4; i++) {
			comparators[i] = Integer.parseInt(stCom.nextToken());
		} // Input end
		
		insertComparator(0);
		
		System.out.println(maximum);
		System.out.println(minimum);
		
	} // end of main
	
	// insertComparators
	static void insertComparator(int index) {
		
		if (index == N-1) {
			int temp = numbers[0];
			for (int i = 0; i < N-1; i++) {
				switch (comps[i]) {
				case 0:
					temp = temp + numbers[i+1];
					continue;
				case 1:
					temp = temp - numbers[i+1];
					continue;
				case 2:
					temp = temp * numbers[i+1];
					continue;
				case 3:
					temp = temp / numbers[i+1];
					continue;
				}
			}
			if (temp < minimum) {
				minimum = temp;
			}
			if (maximum < temp) {
				maximum = temp;
			}
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (comparators[i] > 0) {
				comparators[i]--;
				comps[index] = i;
				insertComparator(index+1);
				comparators[i]++;
			}
		}
		
	} // end ofinsertComparators
	
} // end of class