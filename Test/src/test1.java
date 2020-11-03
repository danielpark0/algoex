import java.util.*;

public class test1 {

	public static void main(String[] args) {

		Node root = new Node();
		
		System.out.println(root.a);
		
		System.out.println(root.b[0]);
		
		System.out.println(root.c);
		
		System.out.println(root.set.toString());

	}

}

class Node{
	int a;
	Node [] b;
	boolean c;
	Set<Integer> set;
	public Node() {
		this.a = 3;
		this.b = new Node [3];
		this.c = false;
		this.set = new HashSet<>();
	}
}
