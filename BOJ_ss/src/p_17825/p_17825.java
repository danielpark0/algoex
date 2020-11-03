package p_17825;

import java.util.*;
import java.io.*;

public class p_17825 {
	
	static int answer;
	
	static int [] A;
	
	static int [] point;

	public static void main(String[] args) throws Exception {
		
		answer = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		A = new int [10];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 10; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		
		point = new int [33];
		
		for(int i = 1; i <= 20; i++) {
			point[i] = i*2;
		}
		
		point[21] = 13;
		point[22] = 16;
		point[23] = 19;
		
		point[24] = 22;
		point[25] = 24;
		
		point[26] = 28;
		point[27] = 27;
		point[28] = 26;
		
		point[29] = 25;
		point[30] = 30;
		point[31] = 35;
		
		int [] pos = new int [4];
		
		dfs(pos,0,0);
		
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();

	}
	
	static void dfs(int [] pos, int ind, int sum) {
		if(ind==10) {
			if(sum>answer) answer = sum;
		}
		else {
			for(int i = 0; i < 4; i++) {
				//if(pos[i]==32) continue;
				int temp = pos[i];
				pos[i] = move(pos[i],A[ind]);
				if(pos[i]==32||check(i,pos))
					dfs(pos,ind+1,sum+point[pos[i]]);
				pos[i] = temp;
			}
		}
	}
	
	static int move(int curr, int n) {
		boolean first = true;
		while(n>0&&curr<32) {
			curr = getNext(first,curr);
			first = false;
			n--;
		}
		return curr;
	}
	
	static int getNext(boolean first, int curr) {
		if(curr==23||curr==25) {
			return 29;
		}
		else if(curr==31) {
			return 20;
		}
		else if(curr==20) {
			return 32;
		}
		else if(curr==5&&first) {
			return 21;
		}
		else if(curr==10&&first) {
			return 24;
		}
		else if(curr==15&&first) {
			return 26;
		}
		else {
			return curr+1;
		}
	}
	
	static boolean check(int n, int [] pos) {
		for(int i = 0; i < 4; i++) {
			if(i!=n&&pos[i]==pos[n]) return false;
		}
		return true;
	}

}
