import java.util.*;

public class test6 {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		
		float a = (float) 9/3;
		
		list.add(4);
		list.add(3);
		list.add(2);
		
		System.out.println(list.get(1)>a);
		
		System.out.println(list.toString());
		
		for(int i = 0; i < 3; i++) {
			if(list.get(i)<a) {
				list.add(i,list.remove(i)+1);
			}
			else if(list.get(i)>a) {
				list.add(i,list.remove(i)-1);
			}
		}
		
		System.out.println(list.toString());

	}

}
