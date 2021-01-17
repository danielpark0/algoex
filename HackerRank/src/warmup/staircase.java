package warmup;

public class staircase {
	
	static void staircase(int n) {

        for(int i = 1; i <= n; i++){
            for(int j = 0; j < n-i; j++){
                System.out.print(" ");
            }
            for(int j = 0; j < i; j++){
                System.out.print("#");
            }
            System.out.println();
        }

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
