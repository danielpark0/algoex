package warmup;

import java.util.*;

public class minimaxsum {

	// Complete the miniMaxSum function below.
	static void miniMaxSum(int[] arr) {

		Arrays.sort(arr);

		long sum = 0;

		for(int e : arr){
			sum += e;
		}

		System.out.println((sum-arr[4])+" "+(sum-arr[0]));

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
