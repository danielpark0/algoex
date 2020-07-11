import java.util.*;

public class p_64065 {
	
	public static int[] solution(String s) {
        int[] answer;
        
        s = s.substring(1,s.length()-1);
        
        String [] s1 = s.split("},");
    	s1[s1.length-1] = s1[s1.length-1].substring(0,s1[s1.length-1].length()-1);
        
        Set<Integer> [] num = new HashSet[s1.length];
        
        for(int i = 0; i < s1.length; i++) {
        	num[i] = new HashSet<Integer>();
        	String [] temp = s1[i].substring(1,s1[i].length()).split(",");
        	for(String e : temp) {
        		num[i].add(Integer.parseInt(e));
        	}
        }
        
        Arrays.sort(num, new Comparator<Set<Integer>>() {

			@Override
			public int compare(Set<Integer> o1, Set<Integer> o2) {
				if(o1.size()<o2.size()) {
					return -1;
				}
				else if(o1.size()>o2.size()) {
					return 1;
				}
				else {
					return 0;
				}
			}
		});
        
        answer = new int [num.length];
        
        for(int i = num.length-1; i > 0; i--) {
        	num[i].removeAll(num[i-1]);
        }
        
        for(int i = 0; i < num.length; i++) {
        	for(int e:num[i])
        		answer[i]=e;
        }
        
        return answer;
    }

	public static void main(String[] args) {

		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		System.out.println(Arrays.toString(solution(s)));
		
	}

}
