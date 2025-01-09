import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Class
public class Main_1517_버블소트_P5 {
	static int[] originalArray;
	static int[] sortedArray;
	static long swapCount;
	
	// Main
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		originalArray = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i ++) {
			originalArray[i] = Integer.parseInt(st.nextToken());
		}
		sortedArray = new int[N+1];
		swapCount = 0;

		mergeSort(1, N);
		System.out.println(swapCount);
		
	} // Main
	
	// Merge Sort
	private static void mergeSort(int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(start, mid);
			mergeSort(mid + 1, end);
			merge(mid, start, end);
		}
	} // Merge Sort
	
	// Merge
private static void merge(int mid, int start, int end) {
		int index = start;
		int left = start;
		int right = mid + 1;
		while (left <= mid && right <= end) {
			if (originalArray[left] <= originalArray[right]) {
				sortedArray[index++] = originalArray[left++];
			} else {
				swapCount += mid - left + 1;
				sortedArray[index++] = originalArray[right++];
			}
		}
		while (left <= mid) {
			sortedArray[index++] = originalArray[left++];
		}
		while (right<= end) {
			sortedArray[index++] = originalArray[right++];
		}
		for (int i = start; i <= end; i++) {
			originalArray[i] = sortedArray[i];
		}
	} // Merge
} // Class
