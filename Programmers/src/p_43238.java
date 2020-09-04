import java.util.*;

public class p_43238 {
	
	public static long solution(int n, int[] times) {
        long answer = 0;
        
        PriorityQueue<Desk> pq = new PriorityQueue<Desk>(Comparator.comparingLong(Desk::getSum));
        
        for(int e : times)
        	pq.add(new Desk(e,e));
        
        for(int i = 0; i < n-1; i++) {
        	Desk curr = pq.poll();
        	curr.sum += curr.t;
        	pq.add(curr);
        }
        
        answer = pq.poll().sum;
        
        return answer;
    }

	public static void main(String[] args) {

		int n = 6;
		int [] times = {7,10};
		
		System.out.println(solution(n,times));

	}

}

class Desk{
	int t;
	long sum;
	public Desk(int t, int sum) {
		this.t = t;
		this.sum = sum;
	}
	long getSum() {
		return sum;
	}
}
