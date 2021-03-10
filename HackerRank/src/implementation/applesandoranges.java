package implementation;

public class applesandoranges {
	
	static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int org = 0;
        int apl = 0;
        for(int e : apples){
            if(e+a>=s&&e+a<=t){
                org++;
            }
        }
        for(int e : oranges){
            if(e+b>=s&&e+b<=t){
                apl++;
            }
        }
        
        System.out.println(org+"\n"+apl);

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
