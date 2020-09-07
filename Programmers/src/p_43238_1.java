import java.util.*;

public class p_43238_1 {
	
	public static long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;

        Arrays.sort(times);
        
        long l = 0;
        long r = n*times[times.length-1];
        
        while(l<=r) {
        	long m = (l+r)/2;
        	long sum = 0;
        	for(int i = 0; i < times.length; i++) {
        		sum += m/times[i];
        	}
        	
        	if(sum>=n) {
        		if(m<answer) {
        			answer = m;
        		}
        		r = m-1;
        	}
        	else {
        		l = m+1;
        	}
        }
        
        return answer;
    }

	public static void main(String[] args) {

		int n = 6;
		int [] times = {7,10};
		
		System.out.println(solution(n,times));

	}

}
