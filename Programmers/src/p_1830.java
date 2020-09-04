import java.util.*;

public class p_1830 {
	
	static boolean [] check;
	
	public static String solution(String sentence) {
        String answer = "";
        
        String [] s = sentence.split(" ");
        
        if(s.length>1) {
        	return "invalid";
        }
        
        check = new boolean[26];
        
//        while(sentence.length()>0) {
//        	if(sentence.length()==1) {
//        		answer += " "+sentence;
//        		sentence = "";
//        	}
//        	int end = 0;
//        	if(sentence.charAt(0)-'A'>=0&&sentence.charAt(0)-'A'<=25) {
//        		end = rule1(sentence);
//            	if(end == -1) {
//            		return "invalid";
//            	}
//        	}
//        	else {
//        		end = rule2(sentence);
//            	if(end == -1) {
//            		return "invalid";
//            	}
//        	}
//        }
        
        
        return answer;
    }
	
	

	public static void main(String[] args) {

		String [] s = {"HaEaLaLaObWORLDb","SpIpGpOpNpGJqOqA","AxAxAxAoBoBoB"};
		
		for(String e:s)
			System.out.println(solution(e));

	}

}
