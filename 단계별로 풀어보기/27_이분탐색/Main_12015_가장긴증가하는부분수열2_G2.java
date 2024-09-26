import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12015_가장긴증가하는부분수열2_G2 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1 ~ 10^6
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N]; // 1 ~ 10 ^ 6
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] bs = new int[N];
		bs[0] = arr[0];
		int idx = 0;
		int max = 0;
		
		for (int i = 1; i < arr.length; i++) {
			
			if (bs[max] < arr[i]) {
				bs[++max] = arr[i];
			} else {
				
				int left = 0;
				int mid = 0;
				int right = max;
				
				while (left < right) {
					
					mid = (left+right)/2;
					if (bs[mid] >= arr[i]) {
						right = mid;
					} else {
						left = mid+1;
					}
					
				}
				
				mid = (left+right)/2;
				if (bs[mid] >= arr[i]) {
					right = mid;
				} else {
					left = mid+1;
				}
				if (bs[mid] != arr[i]) {
					idx = mid;
					bs[idx] = arr[i];
				}
				
			}
			
			if (max < idx) {
				max = idx;
			}
			
//			for (int j = 0; j < max+1; j++) {
//				System.out.print(bs[j] + " ");
//			}
//			System.out.println();
			
		}
		
		
		System.out.println(max+1);
		
	}
}

/*

6
10 20 10 30 20 50

25
10 12 14 11 15 22 1 21 8 24 8 20 3 2 5 6 17 7 16 25 19 23 18 13 3

*/