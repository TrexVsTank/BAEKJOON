import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [CLASS]
public class Main_17435_합성함수와쿼리_G1 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int M;
	static int K;
	static int[][] sparseTable;
	static int Q;
	
	// [MAIN]
	public static void main(String[] args) throws IOException {
		
		M = Integer.parseInt(br.readLine());
		
		K = 17;
		
		sparseTable = new int[K+1][M+1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int m = 1; m <= M; m++) {
			sparseTable[0][m] = Integer.parseInt(st.nextToken());
		}
		for (int k = 1; k <= K; k++) {
			for (int m = 1; m <= M; m++) {
				sparseTable[k][m] = sparseTable[k-1][sparseTable[k-1][m]];
			}
		}
		
		Q = Integer.parseInt(br.readLine());
		
		for (int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			sb.append(query(n, x)).append("\n");
		}
		
		System.out.println(sb);
		
	} // [MAIN]
	
	// [QUERY]
	private static int query(int n, int x) {
		int num = x;
		int count = n;
		int k = K;
		while (count != 0) {
			while (count >= Math.pow(2, k)) {
				num = sparseTable[k][num];
				count -= Math.pow(2, k);
			}
			k--;
		}
		return num;
	} // [QUERY]
	
} // [CLASS]
