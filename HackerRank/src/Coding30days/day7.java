package Coding30days;

import java.io.*;

public class day7 {

	public static void main(String[] args) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++){
			String s = br.readLine();
			String s1 = "";
			String s2 = "";
			for(int j = 0; j < s.length(); j++){
				if(j%2==0){
					s1 += s.charAt(j);
				}
				else{
					s2 += s.charAt(j);
				}
			}
			System.out.println(s1+" "+s2);
		}
	}

}
