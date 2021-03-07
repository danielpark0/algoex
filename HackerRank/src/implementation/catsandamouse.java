package implementation;

public class catsandamouse {

	static String catAndMouse(int x, int y, int z) {

		int a = Math.abs(x-z);
		int b = Math.abs(y-z);
		String s = "";
		if(a<b){
			s = "Cat A";
		}
		else if(a>b){
			s = "Cat B";
		}
		else{
			s = "Mouse C";
		}
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
