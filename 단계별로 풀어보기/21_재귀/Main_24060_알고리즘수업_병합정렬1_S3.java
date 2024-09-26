import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


// 클래스
public class Main_24060_알고리즘수업_병합정렬1_S3 {
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st1.nextToken());
		int K = Integer.parseInt(st1.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		// 입력
		
		merge_sort(arr);
		
		if (list.size() < K) {
			System.out.println(-1);
		} else {
			System.out.println(list.get(K-1));
		}
		
	}
	// 메인
	
	// 병합정렬
	static List<Integer> list = new ArrayList<>();
	static int[] sorted;
	static void merge_sort(int[] a) {
		sorted = new int[a.length];
		merge_sort(a, 0, a.length-1);
		sorted = null;
	}
	static void merge_sort(int[] a, int left, int right) {
		if(left == right) return;
		int mid = (left+right)/2;
		merge_sort(a, left, mid);
		merge_sort(a, mid+1, right);
		merge(a, left, mid, right);
	}
	// 병합정렬
	
	// 병합
	static void merge(int[] a, int left, int mid, int right) {
		int l = left;
		int r = mid+1;
		int idx = left;
		while (l <= mid && r <= right) {
			if (a[l] <= a[r]) {
				sorted[idx] = a[l];
				list.add(a[l]);
				idx++;
				l++;
			} else {
				sorted[idx] = a[r];
				list.add(a[r]);
				idx++;
				r++;
			}
		}
		if (l > mid) {
			while(r <= right ) {
				sorted[idx] = a[r];
				list.add(a[r]);
				idx++;
				r++;
			}
		} else {
			while(l <= mid) {
				sorted[idx] = a[l];
				list.add(a[l]);
				idx++;
				l++;
			}
		}
		for (int i = left; i <= right; i++) {
			a[i] = sorted[i];
		}
	}
	// 병합
}
// 클래스
