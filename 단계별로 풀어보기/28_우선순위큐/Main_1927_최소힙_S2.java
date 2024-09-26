import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_1927_최소힙_S2 {
	public static void main(String[] args) throws IOException {
		
		min_heap MH = new min_heap();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if (input == 0) {
				System.out.println(MH.poll());
			} else {
				MH.push(input);
			}
		}
		
	}
}

class min_heap {
	
	List<Long> list;
	
	min_heap() {
		list = new ArrayList<>();
		list.add((long) 0);
	}
	
	void push(long value) {
		list.add(value);
		int idx = list.size()-1;
		while (idx > 1) {
			if (list.get(idx) < list.get(idx/2)) {
				Collections.swap(list, idx, idx/2);
				idx /= 2;
			} else {
				break;
			}
		}
	}
	
	long poll() {
		if (list.size() == 1) {
			return 0;
		}
		
		long result = list.get(1);
		
		int idx = 1;
		list.set(idx, list.get(list.size()-1));
		list.remove(list.size()-1);
		
		while (idx*2 < list.size()) {
			if ( (idx*2 < list.size() && list.get(idx) > list.get(idx*2)) || (idx*2+1 < list.size() && list.get(idx) > list.get(idx*2+1)) ) {
				if (idx*2+1 < list.size() && list.get(idx*2) > list.get(idx*2+1)) {
					Collections.swap(list, idx, idx*2+1);
					idx = idx*2+1;
				} else {
					Collections.swap(list, idx, idx*2);
					idx = idx*2;
				}
			} else {
				break;
			}
		}
		
		return result;
	}
	
}