import java.util.Scanner;

public class Main_10807_개수세기_B5 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] Arr = new int[N];
		for (int i = 0; i < Arr.length; i++) {
			Arr[i] = sc.nextInt();
		}
		
		int V = sc.nextInt();
		
		int count = 0;
		for (int i = 0; i < Arr.length; i++) {
			if (Arr[i] == V) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}
