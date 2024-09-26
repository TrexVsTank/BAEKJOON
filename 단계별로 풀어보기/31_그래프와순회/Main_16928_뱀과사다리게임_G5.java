import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 클래스
public class Main_16928_뱀과사다리게임_G5 {
	
	static int dice[] = {1, 2, 3, 4, 5, 6};
	
	static int N;
	static int M;
	
	static int board[];
	static int ladder[][];
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[101];
		for (int i = 0; i < 101; i++) {
			board[i] = -1;
		}
		
		ladder = new int[N+M][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			ladder[i][0] = num1;
			ladder[i][1] = num2;
		}
		for (int i = N; i < N+M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			ladder[i][0] = num1;
			ladder[i][1] = num2;
		}
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		board[1] = 0;
		for (int[] l : ladder) {
			if (l[0] == 1) {
				if (l[1] == 100) {
					System.out.println(0);
					System.exit(0);
				} else {
					queue.poll();
					queue.offer(l[1]);
					break;
				}
			}
		}
		
		int time = 1;
		
		w : while (!queue.isEmpty()) {
			int s = queue.size();
			for (int i = 0; i < s; i++) {
				int q = queue.poll();
				for (int d : dice) {
					int qd = q+d;
					if (checker(qd) && board[qd] == -1) {
						board[qd] = time;
						if (qd == 100) {
							System.out.println(time);
							break w;
						}
						for (int[] l : ladder) {
							if (qd == l[0]) {
								board[l[1]] = time;
								qd = l[1];
								if (l[1] == 100) {
									System.out.println(time);
									break w;
								}
							}
						}
						queue.offer(qd);
					}
				}
			}
			time++;
		}
		
	} // 메인 끝
	
	// 체커
	static boolean checker(int index) {
		return 1 <= index && index <= 100;
	} // 체커 끝
	
} // 클래스 끝
