package Day2;

import java.util.*;

public class p_1072 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		long X = sc.nextInt();
		long Y = sc.nextInt();
		
		int Z = (int) ((Y*100)/X);
		
		if(Z>=99) {
			System.out.println(-1);
		}
		else {
			int l = 1;
			int r = 1000000000;
			int n = 0;
			
			while(l<=r) {
				int m = (l+r)/2;
				if((int)((Y+m)*100/(X+m))==Z) {
					l = m+1;
				}
				else {
					n = m;
					r = m-1;
				}
			}
			
			System.out.println(n);
		}
		

	}

}
