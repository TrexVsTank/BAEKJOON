import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16139_인간컴퓨터상호작용_S1 {
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		
		int[][] sum = new int[26][S.length()+1];
		
		for (int i = 0; i < S.length(); i++) {
			for (int j = 0; j < 26; j++) {
				sum[j][i+1] = sum[j][i];
			}
			sum[S.charAt(i)-'a'][i+1]++;
		}
		
		int q = Integer.parseInt(br.readLine());
		
//		for (int i = 0; i < 26; i++) {
//			System.out.println(Arrays.toString(sum[i]));
//		}
		
		for (int i = 0; i < q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			char a = st.nextToken().charAt(0);
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			sb.append(sum[a-'a'][r+1]-sum[a-'a'][l]).append("\n");
		}
		
		System.out.println(sb);
		
	}
}