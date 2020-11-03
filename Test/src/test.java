import java.util.*;

public class test {

	public static void main(String[] args) {
		
		int max = 2000000000;
		
		System.out.println(max);

//		System.out.println('Z'-'A');
		
		System.out.println('z'-'a');
		
		PriorityQueue<Kiosk> pq = new PriorityQueue<Kiosk>();
		
		pq.add(new Kiosk(1,2));
		pq.add(new Kiosk(2,1));
		pq.add(new Kiosk(4,3));
		pq.add(new Kiosk(3,3));
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
		
	}
	
	

}

class Kiosk implements Comparable<Kiosk>{

	int id;
	long end;
	
	public Kiosk(int id, long end) {
		this.id = id;
		this.end = end;
	}

	@Override
	public int compareTo(Kiosk o) {
		if(o.end>this.end) {
			return -1;
		}
		else if(o.end<this.end) {
			return 1;
		}
		else {
			if(o.id > this.id) {
				return -1;
			}
			else if(o.id < this.id) {
				return 1;
			}
			else {
				return 0;
			}
		}
	}

	public String toString() {
		return id + " " + end;
	}
	
}
