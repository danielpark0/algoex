package Coding30days;

public class day5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Person1{
	private int age;	
	  
	public Person1(int initialAge) {
  		// Add some more code to run some checks on initialAge
        if(initialAge<0){
            age = 0;
            System.out.println("Age is not valid, setting age to 0.");
        }
        else{
            age = initialAge;
        }
	}

	public void amIOld() {
  		// Write code determining if this person's age is old and print the correct statement:
        if(age<13){
            System.out.println("You are young.");
        }
        else if(age>=13&&age<18){
            System.out.println("You are a teenager.");
        }
        else{
            System.out.println("You are old.");
        }
	}

	public void yearPasses() {
  		// Increment this person's age.
          age++;
	}
}
