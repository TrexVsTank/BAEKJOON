import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4779_칸토어집합_S3 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
	    while (input != null && input.length()>0) {
	        
	        int N = Integer.parseInt(input);
	        
	        String cantoN = getCantor(N);
	        
	        System.out.println(cantoN);
	        
	        input = br.readLine();
	    }
		
	}
	
	// 겟칸토스트링
	static String getVoid(int num) {
		if (num == 0) {
			return " ";
		} else if (num == 1) {
			return "   ";
		}
		return getVoid(num-1)+getVoid(num-1)+getVoid(num-1);
	}
	static String getCantor(int num) {
		if (num == 0) {
			return "-";
		} else if (num == 1) {
			return "- -";
		}
		return getCantor(num-1)+getVoid(num-1)+getCantor(num-1);
		
	}
	// 겟칸토스트링
	
}