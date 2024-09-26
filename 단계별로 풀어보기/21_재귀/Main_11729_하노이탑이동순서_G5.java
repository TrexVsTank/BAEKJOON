import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_11729_하노이탑이동순서_G5 {
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<int[]> list = HANOI(N, 1, 3);
		
		sb.append(list.size()).append("\n");
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)[0]).append(" ").append(list.get(i)[1]).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static List<int[]> HANOI(int num, int start, int end) {
		if (num == 1) {
			List<int[]> list = new ArrayList<>();
			list.add(new int[] {start, end});
			return list;
		}
		
		int mid = 0;
		for (int i = 1; i <= 3; i++) {
			if (i != start && i != end) {
				mid = i;
				break;
			}
		}
		List<int[]> list = HANOI(num-1, start, mid);
		list.add(new int[] {start, end});
		list.addAll(HANOI(num-1, mid, end));
		return list;
	}
	
}