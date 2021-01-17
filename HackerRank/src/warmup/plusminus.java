package warmup;

public class plusminus {
	
	static void plusMinus(int[] arr) {
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        
        for(int e : arr){
            if(e>0) i1++;
            else if(e<0) i2++;
            else i3++;
        }
        
        System.out.println(String.format("%.6f",(double)i1/arr.length));
        System.out.println(String.format("%.6f",(double)i2/arr.length));
        System.out.println(String.format("%.6f",(double)i3/arr.length));

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
