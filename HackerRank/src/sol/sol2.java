package sol;

import java.util.*;

public class sol2 {

	public static int longestChain(List<String> words) {
		int max = 0;
		// Write your code here
		Collections.sort(words, new Comparator<String>(){
			public int compare(String o1, String o2){
				return o1.length()-o2.length();
			}
		});
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(String s : words){
			if(s.length()==1){
				map.put(s, 1);
			}
			else{
				for(int i = 0; i < s.length(); i++){
					String ts = reduce(s,i);
					if(map.containsKey(ts)){
						if(map.containsKey(s)){
							if(map.get(s)<map.get(ts)+1){
								map.remove(s);
								map.put(s, map.get(ts)+1);
							}
						}
						else{
							map.put(s, map.get(ts)+1);
						}
					}
					else{
						if(!map.containsKey(s))
							map.put(s, 1);
					}
				}
			}
			if(max < map.get(s)) max = map.get(s);
		}
		return max;
	}

	public static String reduce(String s, int i){
		return s.substring(0,i)+s.substring(i+1,s.length());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("abcd");
		list.add("ab");
		list.add("abc");
		longestChain(list);
	}

}
