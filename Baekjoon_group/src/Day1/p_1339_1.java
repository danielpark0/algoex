package Day1;

import java.util.*;
import java.io.*;

public class p_1339_1 {
	
	static int N;
	
	static String [] words;
	
	static Map<Character,Integer> chars;
	
	static boolean [] contain;
	
	static boolean [] visited;
	
	static int answer;

	public static void main(String[] args) throws Exception {
		
		answer = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());

		words = new String [N];
		
		chars = new HashMap<>();
		
		contain = new boolean [26];
		
		visited = new boolean [10];
		
		for(int i = 0; i < N; i++) {
			words[i] = br.readLine();
			for(int j = 0; j < words[i].length(); j++) {
				char c = words[i].charAt(j);
				if(!contain[c-'A']) {
					chars.put(c,chars.size());
					contain[c-'A'] = true;
				}
			}
		}
		
		int [] nums = new int [chars.size()];
		
		dfs(0,nums);
		
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
		
	}
	
	static void dfs(int ind, int [] nums) {
		if(ind==chars.size()) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				int t = 0;
				for(int j = 0; j < words[i].length(); j++) {
					t *= 10;
					t += nums[chars.get(words[i].charAt(j))];
				}
				sum += t;
			}
			answer = Math.max(answer, sum);
		}
		else {
			for(int i = 9; i > 9-chars.size(); i--) {
				if(!visited[i]) {
					visited[i] = true;
					nums[ind] = i;
					dfs(ind+1,nums);
					visited[i] = false;
					nums[ind] = 0;
				}
			}
		}
	}
	
	
	
}
