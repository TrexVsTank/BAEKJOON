import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main_10814_나이순정렬_S5 {
	public static void main(String[] args) throws IOException {
		
		// 0. 입력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[][] list = new String[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list[i][0] = st.nextToken();
			list[i][1] = st.nextToken();
			list[i][2] = i+"";
		}
		
		// 0. 입력
		
		// 1. 풀이
		
//		System.out.println(Arrays.deepToString(list));
		
		Arrays.sort(list, (a, b) -> {
			if ( Integer.parseInt(a[0]) == Integer.parseInt(b[0]) ) {
				return Integer.parseInt(a[2]) - Integer.parseInt(b[2]);
			} else {
				return Integer.parseInt(a[0]) - Integer.parseInt(b[0]);
			}
		});
		
//		System.out.println(Arrays.deepToString(list));
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			sb.append(list[i][0] + " " + list[i][1] + "\n");
		}
		
		System.out.println(sb);
		
//		Arrays.sort(list, (a, b) -> {
//			if (((String)a).length() == ((String)b).length()) {
//				return a.compareTo(b);
//			} else {
//				return ((String)a).length() - ((String)b).length();
//			}
//		});
//		
//		List<String> list2 = new ArrayList<>();
//		
//		list2.add(list[0]);
//		
//		for (int i = 1; i < N; i++) {
//			if(!(list[i].equals(list[i-1]))) {
//				list2.add(list[i]);
//			}
//		}
//		
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < list2.size(); i++) {
//			sb.append(list2.get(i) + "\n");
//		}
//		System.out.println(sb);
		
		// 1. 풀이
		
	} // end of main
} // end of class
