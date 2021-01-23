package Coding30days;

import java.util.*;

public class day4 {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int N = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		if(N%2==1){
			System.out.println("Weird");
		}
		else{
			if(N>=6&&N<=20){
				System.out.println("Weird");
			}
			else{
				System.out.println("Not Weird");
			}
		}
		scanner.close();
	}

}
