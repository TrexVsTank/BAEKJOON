import java.io.*;
import java.util.*;

public class Main_25206_너의평점은_S5 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		List<List<String>> listInput = new ArrayList<>();
		
		for (int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			listInput.add(new ArrayList<String>());
			for (int j = 0; j < 3; j++) {
				listInput.get(i).add(st.nextToken());
			}
		}
		
		String[][] arrGrade = {{"A+", "4.5"}, {"A0", "4.0"}, {"B+", "3.5"}, {"B0", "3.0"}, {"C+", "2.5"}, {"C0", "2.0"}, {"D+", "1.5"}, {"D0", "1.0"}, {"F", "0.0"}};
		
		List<Double> listCalculate = new ArrayList<>();
		
		double sum1 = 0;
		double sum2 = 0;
		double num = 0;
		
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < arrGrade.length; j++) {
				if (listInput.get(i).get(2).equals(arrGrade[j][0])) {
					sum1 += Double.parseDouble(listInput.get(i).get(1)) * Double.parseDouble(arrGrade[j][1]);
					sum2 += Double.parseDouble(listInput.get(i).get(1));
					num++;
				}
			}
		}
		
		System.out.println(sum1/sum2);
		
	} // end of main
} // end of class

