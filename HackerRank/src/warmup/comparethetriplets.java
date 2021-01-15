package warmup;

import java.util.*;

public class comparethetriplets {
	
	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        int alice = 0;
        int bob = 0;
        
        for(int i = 0; i < 3; i++){
            if(a.get(i)>b.get(i)){
                alice++;
            }
            else if(a.get(i)<b.get(i)){
                bob++;
            }
        }
        
        List<Integer> list = new ArrayList<Integer>();
        list.add(alice);
        list.add(bob);
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
