import java.io.*;
import java.util.*;

public class Main_9506_약수들의합_B1 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		List<Integer> listInput = new ArrayList<>();
		
		String input = br.readLine();
		
		while (!input.equals("-1")) {
			listInput.add(Integer.parseInt(input));
			input = br.readLine();
		}
		
		for (int i = 0; i < listInput.size(); i++) {
			
			List<Integer> listTemp = new ArrayList<>();
			
			int num1 = 1;
			
			while (num1 != listInput.get(i)) {
				if (listInput.get(i) % num1 == 0) {
					listTemp.add(num1);
				}
				num1++;
			}
			
			int sum = 0;
			
			for (int j = 0; j < listTemp.size(); j++) {
				sum += listTemp.get(j);
			}
			
			sb.append(listInput.get(i));
			
			if (sum == listInput.get(i)) {
				sb.append(" ").append("=").append(" ");
				for (int j = 0; j < listTemp.size()-1; j++) {
					sb.append(listTemp.get(j)).append(" + ");
				}
				sb.append(listTemp.get(listTemp.size()-1)).append("\n");
			} else {
				sb.append(" ").append("is NOT perfect.").append("\n");
			}
			
		}
		
		System.out.println(sb);
		
	} // end of main
} // end of class

