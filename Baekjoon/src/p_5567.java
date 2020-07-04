import java.util.*;
import java.io.*;

public class p_5567 {
	
	static int N;
	static int M;

	public static void main(String[] args) throws Exception{
		
		int answer = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		boolean [][] friend = new boolean [N+1][N+1];
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int i1 = Integer.parseInt(st.nextToken());
			int i2 = Integer.parseInt(st.nextToken());
			friend[i1][i2] = true;
			friend[i2][i1] = true;
		}
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i = 2; i <= N; i++) {
			if(friend[1][i]) {
				set.add(i);
				for(int j = 2; j <= N; j++) {
					if(friend[i][j]) {
						set.add(j);
					}
				}
			}
		}
		
		bw.write(Integer.toString(set.size()));
		bw.flush();
		bw.close();
		
	}

}
