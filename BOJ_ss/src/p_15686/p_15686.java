package p_15686;

import java.util.*;
import java.io.*;

public class p_15686 {
	
	static int N, M;
	
	static ArrayList<Pos> home;
	static ArrayList<Pos> chicken;
	
	static int answer;

	public static void main(String[] args) throws Exception {
		
		answer = Integer.MAX_VALUE;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		home = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a==1) {
					home.add(new Pos(i,j));
				}
				else if(a==2) {
					chicken.add(new Pos(i,j));
				}
			}
		}
		
		Pos [] selectM = new Pos [M];
		
		comb(0,0,selectM);
		
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
		
	}
	
	static void comb(int ind, int cnt, Pos [] selectM) {
		if(cnt == M) {
			int sum = 0;
			for(int i = 0; i < home.size(); i++) {
				Pos currH = home.get(i);
				int min = Math.abs(selectM[0].y-currH.y)+Math.abs(selectM[0].x-currH.x);
				for(int j = 1; j < selectM.length; j++) {
					int m = Math.abs(selectM[j].y-currH.y)+Math.abs(selectM[j].x-currH.x);
					if(min > m) {
						min = m;
					}
				}
				sum += min;
			}
			if(sum < answer) answer = sum;
			return;
		}
		if(ind>=chicken.size()) return;
		selectM[cnt] = chicken.get(ind);
		comb(ind+1,cnt+1,selectM);
		comb(ind+1,cnt,selectM);
	}

}

class Pos{
	int y;
	int x;
	public Pos(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
