package Day1;

import java.util.*;

public class p_1713_1 {

	static int N, K;
	static int [] input;
	static Person[] people = new Person[101];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		input = new int[K];
		
		List<Person> list = new ArrayList<>();
		
		for(int i = 0; i < K; i++) {
			int num = sc.nextInt();
			System.out.println(num);
		}
		
	}

}

class Person implements Comparable<Person>{
	
	int num;
	int count;
	int timeStamp;
	boolean isIn;

	public Person(int num, int count, int timeStamp, boolean isIn) {
		super();
		this.num = num;
		this.count = count;
		this.timeStamp = timeStamp;
		this.isIn = isIn;
	}

	@Override
	public String toString() {
		return "Person [num=" + num + ", count=" + count + ", timeStamp=" + timeStamp + ", isIn=" + isIn + "]";
	}

	@Override
	public int compareTo(Person o) {
		if(count < o.count) {
			return -1;
		}
		else if(count == o.count) {
			if(timeStamp < o.timeStamp) {
				return 1;
			}
			else if(timeStamp == o.timeStamp) {
				return 0;
			}
			else {
				return -1;
			}
		}
		else {
			return 1;
		}
	}
	
}
