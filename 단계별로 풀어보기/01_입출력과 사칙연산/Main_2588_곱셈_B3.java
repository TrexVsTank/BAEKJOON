import java.util.Scanner;

public class Main_2588_곱셈_B3 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int int1 = sc.nextInt();
		int int2 = sc.nextInt();
		
		int a = int2 % 10;
		int b = int2 % 100 / 10;
		int c = int2 % 1000 / 100;
		
		System.out.println(int1*a);
		System.out.println(int1*b);
		System.out.println(int1*c);
		System.out.println(int1*int2);
		
	} // end of main
} // end of class
