package Coding30days;

import java.util.*;

public class day3 {
	
	// Complete the solve function below.
    static void solve(double meal_cost, int tip_percent, int tax_percent) {
        int tip = (int) Math.round(meal_cost*tip_percent/(double)100);
        int tax = (int) Math.round(meal_cost*tax_percent/(double)100);
        System.out.println(tip+tax);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
	}

}
