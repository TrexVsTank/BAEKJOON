import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11279_최대힙_S2 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		My_Heap h = new My_Heap();
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				System.out.println(h.pop());
			} else {
				h.add(num);
			}
		}
		
	}
	
	
}

class My_Heap {
	
	int size = 0;
	int[] arr = new int[100001];
	
	void add(int num) {
		if (size == 100000) {
			return;
		}
		size++;
		arr[size] = num;
		int idx = size;
		while (idx != 1) {
			if (arr[idx] > arr[idx/2]) {
				int temp = arr[idx];
				arr[idx] = arr[idx/2];
				arr[idx/2] = temp;
				idx /= 2;
			} else {
				break;
			}
		}
	}
	
	int pop() {
		int result = arr[1];

		arr[1] = 0;
		int idx = 1;
		
		while (idx*2 <= size) {
			if (arr[idx] >= arr[idx*2] && arr[idx] >= arr[idx*2+1]) {
				break;
			} else {
				if (arr[idx*2] < arr[idx*2+1]) {
					arr[idx] = arr[idx*2+1];
					arr[idx*2+1] = 0;
					idx = idx*2+1;
				} else {
					arr[idx] = arr[idx*2];
					arr[idx*2] = 0;
					idx = idx*2;
				}
			}
		}
		return result;
	}
	
}