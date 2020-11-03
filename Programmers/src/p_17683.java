import java.util.*;


class p_17683 {
	
	static ArrayList<String> mlist;
	static int [] fail;
	
    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int max = 0;
        mlist = new ArrayList<String>();
        for(int i = 0; i < m.length(); i++) {
        	if(i<m.length()-1) {
        		if(m.charAt(i+1)=='#') {
        			mlist.add(m.charAt(i)+"#");
        			i++;
        		}
        		else {
        			mlist.add(m.charAt(i)+"");
        		}
        	}
        	else {
        		mlist.add(m.charAt(i)+"");
        	}
        }
        
        fail = new int [mlist.size()];
        
        int q = 0;
        for(int i = 1; i < mlist.size(); i++) {
        	while(q>0&&!mlist.get(i).equals(mlist.get(q))) {
        		q--;
        	}
        	if(mlist.get(i).equals(mlist.get(q))) {
        		fail[i] = ++q;
        	}
        }
        
        //System.out.println(Arrays.toString(fail));
        
        for(int i = 0; i < musicinfos.length; i++){
            String [] s = musicinfos[i].split(",");
            String [] t1 = s[0].split(":");
            String [] t2 = s[1].split(":");
            int time = Integer.parseInt(t2[0])*60+Integer.parseInt(t2[1]) - Integer.parseInt(t1[0])*60-Integer.parseInt(t1[1]);
            Queue<String> queue = new LinkedList<String>();
            for(int j = 0; j < s[3].length(); j++){
                if(j<s[3].length()-1){
                    if(s[3].charAt(j+1)=='#'){
                        queue.add(s[3].charAt(j)+"#");
                        j++;                        
                    }
                    else{
                        queue.add(s[3].charAt(j)+"");
                    }
                }
                else{
                    queue.add(s[3].charAt(j)+"");
                }
            }
            
            ArrayList<String> currlist = new ArrayList<String>();
            
            for(int j = 0; j < time; j++){
                String curr = queue.poll();
                currlist.add(curr);
                queue.add(curr);
            }
            
            if(kmp(currlist)) {
            	if(time > max) {
            		max = time;
            		answer = s[2];
            	}
            }
            
        }
        
        return answer;
    }
    
    static boolean kmp(ArrayList<String> currlist) {
    	int j = 0;
    	for(int i = 0; i < currlist.size(); i++) {
    		while(j>0&&!currlist.get(i).equals(mlist.get(j))) {
    			j = fail[j-1];
    		}
    		if(currlist.get(i).equals(mlist.get(j))) {
    			if(j==mlist.size()-1) {
    				return true;
    			}
    			else {
    				j++;
    			}
    		}
    	}
    	return false;
    }
    
    public static void main(String [] args) {
    	
    	String m1 = "ABCDEFG";
    	
    	String [] musicinfos1 = {"12:00,12:14,HELLO,CDEFGAB","13:00,13:05,WORLD,ABCDEF"};
    	
    	String m2 = "ABC";
    	
    	String [] musicinfos2 = {"12:00,12:14,HELLO,C#DEFGAB","13:00,13:05,WORLD,ABCDEF"};
    	
    	System.out.println(solution(m2,musicinfos2));
    	
    }
}