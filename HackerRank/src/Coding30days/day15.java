package Coding30days;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Difference {
  	private int[] elements;
  	public int maximumDifference;
    
	// Add your code here
    public Difference(int [] a){
        this.elements = a;
    }
    
    void computeDifference(){
        int min = 100;
        int max = 1;
        for(int e: elements){
            if(e<min) min = e;
            if(e>max) max = e;
        }
        maximumDifference = Math.abs(max - min);
    }
} // End of Difference class

public class day15 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}