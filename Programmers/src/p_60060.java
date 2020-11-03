import java.util.*;

public class p_60060 {
	
	public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int [queries.length];
        
        tNode root = new tNode();
        
        for(String e : words) {
        	tNode curr = root;
        	for(int i = 0; i < e.length(); i++) {
        		char c = e.charAt(i);
        		if(curr.arr[c-'a']==null) {
        			curr.arr[c-'a'] = new tNode();
        			curr.next.add(c-'a');
        		}
        		curr = curr.arr[c-'a'];
        		if(i==e.length()-1) {
        			curr.isEnd = true;
        		}
        	}
        }
        
        for(int i = 0; i < queries.length; i++) {
        	answer[i] = query(queries[i], 0, root);
        }
        
        return answer;
    }
	
	static int query(String s, int ind, tNode curr) {
		if(ind==s.length()) {
			if(curr.isEnd) {
				return 1;
			}
			else {
				return 0;
			}
		}
		//Set<Integer> set = new HashSet<Integer>();
		//set.
		else {
			if(s.charAt(ind)=='?') {
				int sum = 0;
				for(int e : curr.next) {
					if(curr.arr[e]!=null) {
						sum += query(s,ind+1,curr.arr[e]);
					}
				}
				return sum;
			}
			else {
				if(curr.arr[s.charAt(ind)-'a']==null) {
					return 0;
				}
				return query(s,ind+1,curr.arr[s.charAt(ind)-'a']);
			}
		}
	}

	public static void main(String[] args) {

		String [] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String [] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
		
		System.out.println(Arrays.toString(solution(words,queries)));

	}

}

class tNode{
	tNode [] arr;
	boolean isEnd;
	Set<Integer> next;
	public tNode() {
		this.arr = new tNode [26];
		this.isEnd = false;
		this.next = new HashSet<>();
	}
}
