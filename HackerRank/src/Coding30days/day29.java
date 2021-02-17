package Coding30days;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class day29 {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        ArrayList<String> list = new ArrayList<>();

        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            String firstName = firstNameEmailID[0];

            String emailID = firstNameEmailID[1];
            
            String [] email = emailID.split("@");
            
            if(email[1].equals("gmail.com")){
                list.add(firstName);
            }
        }
            
        Collections.sort(list);
        
        for(String e : list)
            System.out.println(e);

        scanner.close();
    }
}
