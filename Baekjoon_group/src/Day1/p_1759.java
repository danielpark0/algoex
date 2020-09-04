package Day1;

import java.util.*;
import java.io.*;

public class p_1759 {

	static int L, C;
	
	static char[] data;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt();
		C = sc.nextInt();
		
		data = new char[C];
		
		for(int i = 0; i < C; i++) {
			String s = sc.next();
			data[i] = s.charAt(0);
		}

		Arrays.sort(data);
		
		char [] ans = new char[L];
		
		dfs(0,0,ans);

	}
	
	static void dfs(int ind, int n, char [] ans) {
		if(n==L) {
			if(check(ans)) {
				String s = "";
				for(char e:ans) {
					s += e;
				}
				System.out.println(s);
			}
			return;
		}
		if(ind>=C) {
			
		}
		else {
			ans[n] = data[ind];
			dfs(ind+1,n+1,ans);
			dfs(ind+1,n,ans);
		}
	}
	
	static boolean check(char [] ans) {
		int v = 0;
		int c = 0;
		for(int i = 0; i < L; i++) {
			if(ans[i]=='a'||ans[i]=='e'||ans[i]=='i'||ans[i]=='o'||ans[i]=='u') {
				v++;
			}
			else {
				c++;
			}
		}
		if(v>0&&c>1) {
			return true;
		}
		else {
			return false;
		}
	}

}
