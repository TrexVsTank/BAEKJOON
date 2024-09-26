import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 클래스
public class Main_2606_바이러스_S3 {
	
	// 스태틱
	static int N;
	static int M;
	static int R;
	
	static int arr[];
	static List<List<Integer>> list = new ArrayList<>();
	static boolean visited[];
	static int sum = 0;
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			list.get(num1).add(num2);
			list.get(num2).add(num1);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(list.get(i));
		}
		
		visited = new boolean[N+1];
		
		link(1);
		
		System.out.println(sum-1);
		
	} // 메인 끝
	
	// 링크
	static void link(int index) {
		if (!visited[index]) {
			visited[index] = true;
			sum++;
		}
		for (int i = 0; i < list.get(index).size(); i++) {
			if (!visited[list.get(index).get(i)]) {
				link(list.get(index).get(i));
			}
		}
	} // 링크 끝
	
} // 클래스 끝