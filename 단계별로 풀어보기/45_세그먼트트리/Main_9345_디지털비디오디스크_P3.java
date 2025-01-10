import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [MainClass]
public class Main_9345_디지털비디오디스크_P3{
	
	private static final int INF = 1_000_000_000;
	
	// [Main]
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		// testCase
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] array = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				array[i] = i;
			}
			
			int len = (int) Math.pow(2, Math.ceil(Math.log(N) / Math.log(2)));
			MinSegmentTree minT = new MinSegmentTree(len);
			MaxSegmentTree maxT = new MaxSegmentTree(len);
			minT.init(1, 1, N, array);
			maxT.init(1, 1, N, array);
			
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				int order = Integer.parseInt(st.nextToken());
				int A = Integer.parseInt(st.nextToken()) + 1;
				int B = Integer.parseInt(st.nextToken()) + 1;
				
				if (order == 1) {
					// getValue
					if (minT.getMinimum(1, A, B, 1, N) == A && maxT.getMaximum(1, A, B, 1, N) == B) {
						sb.append("YES\n");
					} else {
						sb.append("NO\n");
					}
				} else {
					minT.swapNodes(A, B, N);
					maxT.swapNodes(A, B, N);
				}
			}
		}
		
		System.out.println(sb);
		
	} // [Main]
	
	// [MinSegmentTree]
	private static class MinSegmentTree {
		
		int[] tree;
		
		public MinSegmentTree(int length) {
			this.tree = new int[length * 2];
		}
		
		public int init(int node, int start, int end, int[] array) {
			if (start == end) {
				return tree[node] = array[start];
			}
			int mid = (start + end) / 2;
			return tree[node] = Math.min(init(node * 2, start, mid, array), init(node * 2 + 1, mid + 1, end, array));
		}
		
		public int getMinimum(int node, int left, int right, int start, int end) {
			if (right < start || end < left) {
				return INF;
			}
			if (left <= start && end <= right) {
				return tree[node];
			}
			if (start == end) {
				return tree[node];
			}
			int mid = (start + end) / 2;
			return Math.min(
					getMinimum(node * 2, left, right, start, mid),
					getMinimum(node * 2 + 1, left, right, mid + 1, end));
		}
		
		public void swapNodes(int a, int b, int n) {
			int minA = getMinimum(1, a, a, 1, n);
			int minB = getMinimum(1, b, b, 1, n);
			 updateNode(a, minB, 1, n);
			 updateNode(b, minA, 1, n);
		}
		
		public void updateNode(int one, int another, int start, int end) {
			int node = 1;
			int left = start;
			int right = end;
			int mid = (start + end) / 2;
			while (true) {
				if (left <= one && one <= mid) {
					right = mid;
					mid = (left + right) / 2;
					node = node * 2;
				} else {
					left = mid + 1;
					mid = (left + right) / 2;
					node = node * 2 + 1;
				}
				if (left == right) {
					tree[node] = another;
					break;
				}
			}
			while (node != 1) {
				node = node / 2;
				tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
			}
		}
		
	} // [MinSegmentTree]
	
	// [MaxSegmentTree]
	private static class MaxSegmentTree {
		
		int[] tree;
		
		public MaxSegmentTree(int length) {
			this.tree = new int[length * 2];
		}
		
		public int init(int node, int start, int end, int[] array) {
			if (start == end) {
				return tree[node] = array[start];
			}
			int mid = (start + end) / 2;
			return tree[node] = Math.max(init(node * 2, start, mid, array), init(node * 2 + 1, mid + 1, end, array));
		}
		
		public int getMaximum(int node, int left, int right, int start, int end) {
			if (right < start || end < left) {
				return 0;
			}
			if (left <= start && end <= right) {
				return tree[node];
			}
			if (start == end) {
				return tree[node];
			}
			int mid = (start + end) / 2;
			return Math.max(
					getMaximum(node * 2, left, right, start, mid),
					getMaximum(node * 2 + 1, left, right, mid + 1, end));
		}
		
		public void swapNodes(int a, int b, int n) {
			int maxA = getMaximum(1, a, a, 1, n);
			int maxB = getMaximum(1, b, b, 1, n);
			 updateNode(a, maxB, 1, n);
			 updateNode(b, maxA, 1, n);
		}
		
		public void updateNode(int one, int another, int start, int end) {
			int node = 1;
			int left = start;
			int right = end;
			int mid = (start + end) / 2;
			while (true) {
				if (left <= one && one <= mid) {
					right = mid;
					mid = (left + right) / 2;
					node = node * 2;
				} else {
					left = mid + 1;
					mid = (left + right) / 2;
					node = node * 2 + 1;
				}
				if (left == right) {
					tree[node] = another;
					break;
				}
			}
			while (node != 1) {
				node = node / 2;
				tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
			}
		}
		
	} // [MaxSegmentTree]
	
} // [MainClass]
