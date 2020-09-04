package Day1;

import java.io.*;
import java.util.*;

public class p_1062 {

	static int N, K;
	static String [] words;
	static boolean[] visited;
	static int selectedCount = 0;
	static int max = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = Integer.parseInt(sc.next());
		K = Integer.parseInt(sc.next());

		words = new String[N];
		visited = new boolean[26];
		visited['a'-'a'] = true;
		visited['n'-'a'] = true;
		visited['t'-'a'] = true;
		visited['i'-'a'] = true;
		visited['c'-'a'] = true;
		
		selectedCount = 5;
		
		for(int i = 0; i < N; i++) {
			words[i] = sc.next().replaceAll("[antic]", "");
		}
		
		for(String e:words) {
			if(e.length()==0) {
				max++;
			}
		}
		
		for(int i = 0; i < 26; i++) {
			if(!visited[i]) {
				dfs(i);
			}
		}
		
		
		if(K<5) {
			System.out.println(0);
		}
		else {
			System.out.println(max);
		}
		
	}
	
	static void dfs(int index) {
		visited[index] = true;
		selectedCount++;
		if(selectedCount == K) {
			int count = 0;
			for(String e: words) {
				boolean bool = true;
				for(int i = 0; i < e.length(); i++) {
					if(!visited[e.charAt(i)-'a']) {
						bool = false;
						break;
					}
				}
				if(bool) count++;
			}
			if(count > max) {
				max = count;
			}
		}
		else {
			for(int i = index+1; i < 26; i++) {
				if(!visited[i]) {
					dfs(i);
				}
			}
		}
		visited[index] = false;
		selectedCount--;
	}

}
