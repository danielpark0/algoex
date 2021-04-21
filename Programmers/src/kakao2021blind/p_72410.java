package kakao2021blind;

public class p_72410 {
	
    public String solution(String new_id) {
        
        new_id = step1(new_id);
        new_id = step2(new_id);
        new_id = step3(new_id);
        new_id = step4(new_id);
        new_id = step5(new_id);
        new_id = step6(new_id);
        new_id = step7(new_id);
        
        return new_id;
    }
    
    String step1 (String s) {
    	return s.toLowerCase();
    }
    
    String step2 (String s) {
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		if((c-'0'>=49&&c-'0'<=74)||(c-'0'>=0&&c-'0'<=9)||c=='-'||c=='_'||c=='.') {
    			sb.append(c);
    		}
    	}
    	return sb.toString();
    }
    
    String step3 (String s) {
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		if(sb.length()>0&&sb.charAt(sb.length()-1)=='.'&&c=='.') {
    			
    		}
    		else {
    			sb.append(c);
    		}
    	}
    	return sb.toString();
    }
    
    String step4 (String s) {
    	if(s.length()==1&&s.charAt(0)=='.') {
    		return "";
    	}
    	if(s.charAt(0)=='.') {
    		s = s.substring(1,s.length());
    	}
    	if(s.charAt(s.length()-1)=='.') {
    		s = s.substring(0,s.length()-1);
    	}
    	return s;
    }
    
    String step5 (String s) {
    	if(s.length()==0)
    		return "a";
    	else 
    		return s;
    }
    
    String step6 (String s) {
    	if(s.length()>=16) {
    		s = s.substring(0,15);
    		if(s.charAt(14)=='.')
    			s = s.substring(0,14);
    	}
    	return s;
    }
    
    String step7 (String s) {
    	while(s.length()<3) {
    		s += s.charAt(s.length()-1);
    	}
    	return s;
    }

	public static void main(String[] args) {

		

	}

}
