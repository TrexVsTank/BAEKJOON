import java.io.*;
import java.util.*;

public class Main_1193_분수찾기_S5 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int X = Integer.parseInt(br.readLine());
		
		int row = X;
		int col = X;
		
		int num1 = 1;
		int num2 = 0;
		
		while (row > num2+num1) {
			num2 += num1;
			num1++;
		}
		
		if (num1 % 2 == 0) {
			row = row - num2;
			col = num1-row+1;
		} else {
			col = col - num2;
			row = num1-col+1;
		}
		
		
		System.out.println(row + "/" + col);
		
		
	} // end of main
} // end of class

