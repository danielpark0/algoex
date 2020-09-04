package sort;

import java.util.*;

public class sort {

	public static void main(String[] args) {
		
		Point [] array = new Point[5];
		
		array[0] = new Point(0,0,1);
		array[1] = new Point(0,1,3);
		array[2] = new Point(0,2,4);
		array[3] = new Point(3,0,5);
		array[4] = new Point(4,0,2);
		
		Arrays.sort(array, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				//-1 : 데이터를 바꾸지 않음 => 우리가 원하는 순서.
				if(o1.y < o2.y) {
					return -1;
				}
				else if(o1.y == o2.y) {
					return 0;
				}
				else {
					return 1;
				}
				//0 : 같음.
				//1 : 데이터를 바꿈 => 우리가 원하는 순서가 아님.
			}
			
		});
		
		System.out.println(Arrays.toString(array));

	}

}

class Point implements Comparable<Point>{
	int x;
	int y;
	int value;
	public Point(int x, int y, int value) {
		super();
		this.x = x;
		this.y = y;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", value=" + value + "]";
	}
	
	@Override
	public int compareTo(Point o) {
		if(x > o.x) {
			return -1;
		}
		else if(x == o.x) {
			return 0;
		}
		else {
			return 1;
		}
	}
}
