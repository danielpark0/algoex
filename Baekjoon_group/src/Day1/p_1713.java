package Day1;

import java.util.*;

public class p_1713 {

	static int N, M;
	static List<Cand> pics;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		pics = new LinkedList<Cand>();
		
		for(int i = 0; i < M; i++) {
			int n = sc.nextInt();
			if(pics.size()<N) {
				if(check(n)) {
					
				}
				else {
					pics.add(new Cand(n,1,i));
				}
			}
			else {
				if(check(n)) {

				}
				else {
					Collections.sort(pics);
					pics.remove(N-1);
					pics.add(new Cand(n,1,i));
				}
			}
		}
		
		Collections.sort(pics, new Comparator<Cand>() {

			@Override
			public int compare(Cand o1, Cand o2) {
				if(o1.n < o2.n) {
					return -1;
				}
				else if(o1.n == o2.n) {
					return 0;
				}
				else {
					return 1;
				}
			}
			
		});
		
		for(Cand e : pics)
			System.out.print(e.n+" ");

	}
	
	static boolean check(int k) {
		for(int i = 0; i < pics.size(); i++) {
			if(pics.get(i).n==k) {
				pics.get(i).count++;
				return true;
			}
		}
		return false;
	}

}

class Cand implements Comparable<Cand>{
	int n;
	int count;
	int time;
	public Cand(int n, int count, int time) {
		super();
		this.n = n;
		this.count = count;
		this.time = time;
	}
	@Override
	public String toString() {
		return "Cand [n=" + n + ", count=" + count + ", time=" + time + "]";
	}
	@Override
	public int compareTo(Cand o) {
		if(count < o.count) {
			return 1;
		}
		else if(count == o.count) {
			if(time < o.time) {
				return 1;
			}
			else if(time == o.time) {
				return 0;
			}
			else {
				return -1;
			}
		}
		else {
			return -1;
		}
	}
}
