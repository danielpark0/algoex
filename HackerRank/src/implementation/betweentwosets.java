package implementation;

import java.util.List;

public class betweentwosets {

	public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        int s1 = a.get(0);
        for(int i = 1; i < a.size(); i++) {
            s1 = s1*a.get(i)/(gcd(s1,a.get(i)));
        }
        
        int s2 = b.get(0);
        for(int i = 1; i < b.size(); i++) {
            s2 = gcd(s2,b.get(i));
        }
        
        System.out.println(s1+" "+s2);
        int cnt = 0;
        int n = 1;
        while(s1*n<=s2) {
            if(s2%(s1*n++)==0) cnt++;
        }
        return cnt;
    }
    
    static int gcd(int a, int b) {
        if(a<b) {
            int temp = b;
            b = a;
            a = temp;
        }
        while(b!=0) {
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
