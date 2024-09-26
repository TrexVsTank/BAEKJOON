import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// class
public class Main_14899_스타트와링크_S1 {
	
	static int N;
	static int S[][];
	
	static StringBuilder sb = new StringBuilder();
	static boolean used[];
	static boolean usedStart[];
	static int teamStart[];
	static int teamLink[];
	static int minimum;
	
	// main
	public static void main(String[] args) throws IOException {
		
		// INPUT
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		teamStart = new int[N/2];
		teamLink = new int[N/2];
		usedStart = new boolean[N];
		used = new boolean[N];
		minimum = Integer.MAX_VALUE;
		
		setTeam(0);
		
		System.out.println(minimum);
		// END OF INPUT
		
	} // end of main
	
	// setTeam
	static void setTeam(int index) {
		if (index == N/2) {
			int abilityStart = 0;
			int abilityLink = 0;
			int idxStart = 0;
			int idxLink = 0;
			for (int i = 0; i < N; i++) {
				if (usedStart[i]) {
					teamStart[idxStart++] = i;
				} else {
					teamLink[idxLink++] = i;
				}
			}
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < N/2; j++) {
					abilityStart += S[teamStart[i]][teamStart[j]];
					abilityLink += S[teamLink[i]][teamLink[j]];
				}
			}
			int diff = Math.abs(abilityStart-abilityLink);
			if (diff < minimum) {
				minimum = diff;
			}
//			System.out.println(Arrays.toString(teamStart));
//			System.out.println(abilityStart);
//			System.out.println(Arrays.toString(teamLink));
//			System.out.println(abilityLink);
//			System.out.println(Arrays.toString(usedStart));
			return;
		}
		for (int i = index; i < N; i++) {
			if (!used[i]) {
				for (int j = 0; j <= i; j++) {
					used[j] = true;
				}
				usedStart[i] = true;
				setTeam(index+1);
				for (int j = 0; j <= i; j++) {
					used[j] = false;
				}
				usedStart[i] = false;
			}
		}
//			if (!usedStart[i]) {
//				
//				usedStart[i] = true;
//				for (int i = 0; i < array.length; i++) {
//					
//				}
//				setTeam(index+1);
//				usedStart[i] = false;
//			}
	} // end of setTeam
	
} // end of class