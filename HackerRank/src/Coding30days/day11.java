package Coding30days;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class day11 {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String s = "";
        while(n>0){
            s = n%2 + s;
            n/=2;
        }
        int max = 0;
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='1'){
                cnt++;
                if(cnt>max) max = cnt;
            }
            else{
                cnt = 0;
            }
        }
        System.out.println(max);
        scanner.close();
    }
}
