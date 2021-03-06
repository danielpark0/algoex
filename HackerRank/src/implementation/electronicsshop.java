package implementation;

public class electronicsshop {
	
	static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        /*
         * Write your code here.
         */
        int answer = -1;
        for(int e1 : keyboards){
            for(int e2 : drives){
                if(e1+e2<=b&&e1+e2>answer){
                    answer = e1+e2;
                }
                //if(e1+e2>b) break;
            }
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
