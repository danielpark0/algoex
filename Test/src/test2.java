import java.util.*;

public class test2 {

	public static void main(String[] args) {

		String [] s = "10/01".split("/");
		
		for(String e : s)
			System.out.println(e);
		
		Diff [] arr = new Diff[3];
		
		arr[0] = new Diff(0,2);
		arr[1] = new Diff(1,1);
		arr[2] = new Diff(2,2);
		
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr,Comparator.comparingInt(Diff::getN));
		
		System.out.println(Arrays.toString(arr));
		
	}

}

class Diff{
	int ind;
	int n;
	public Diff(int ind, int n) {
		this.ind = ind;
		this.n = n;
	}
	public int getN() {
		return n;
	}	
	public String toString() {
		return ind + " " + n;
	}
}
