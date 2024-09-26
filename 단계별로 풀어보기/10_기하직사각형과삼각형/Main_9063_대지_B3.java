import java.io.*;
import java.util.*;

public class Main_9063_대지_B3 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arrRow = new int[N];
		int[] arrCol = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer stLocal = new StringTokenizer(br.readLine(), " ");
			arrRow[i] = Integer.parseInt(stLocal.nextToken());
			arrCol[i] = Integer.parseInt(stLocal.nextToken());
		}
		Arrays.sort(arrRow);
		Arrays.sort(arrCol);
		
		int result = (arrRow[N-1] - arrRow[0]) * (arrCol[N-1] - arrCol[0]);
		
		System.out.println(result);
		
	} // end of main
} // end of class

