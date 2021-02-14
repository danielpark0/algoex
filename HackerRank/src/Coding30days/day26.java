package Coding30days;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class day26 {

    public static void main(String[] args) {
        /* Enter your code here. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int p = sc.nextInt();
            if(p==1){
                System.out.println("Not prime");
                continue;
            }
            boolean b = true;
            for(int j = 2; j*j <= p; j++){
                if(p%j==0){
                    System.out.println("Not prime");
                    b = false;
                    break;
                }
            }
            if(b) System.out.println("Prime");
        }
    }
}



