import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13305_주유소_S3 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] road = new long[N-1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N-1; i++) {
			road[i] = Long.parseLong(st.nextToken());
		}
		
		long[] gas = new long[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			gas[i] = Long.parseLong(st.nextToken());
		}
		
		long cost = road[0]*gas[0];
		long gas_min = gas[0];
		for (int i = 1; i < N-1; i++) {
			gas_min = (gas_min < gas[i] ? gas_min : gas[i]);
			cost += gas_min*road[i];
		}
		
		System.out.println(cost);
		
	}
}