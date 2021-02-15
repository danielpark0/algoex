package Coding30days;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class day27 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        
        int d1 = sc.nextInt();
        int m1 = sc.nextInt();
        int y1 = sc.nextInt();
        
        int d2 = sc.nextInt();
        int m2 = sc.nextInt();
        int y2 = sc.nextInt();
        
        int answer = 0;
        
        if(y2<y1){
            answer = 10000;
        }
        else if(y2>y1){
            
        }
        else{
            if(m2<m1){
                answer = (m1-m2)*500;
            }
            else if(m2>m1){
                
            }
            else{
                if(d2<d1){
                    answer = (d1-d2)*15;
                }
            }
        }
        System.out.println(answer);
    }
}