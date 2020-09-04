package mergeSort;

import java.util.*;

public class mergeSort {

	static int num[] = {8,2,8,10,7,1,9,4,15};
	static int temp[] = new int[num.length];
	
	public static void main(String[] args) {

		mergeSort(0,num.length-1);
		System.out.println(Arrays.toString(num));

	}
	
	static void mergeSort(int s, int e) {
		if(s < e) {
			int mid = (s+e)/2;
			mergeSort(s,mid);
			mergeSort(mid+1,e);
			merge(s,mid,e);
		}
	}

	static void merge(int s, int m, int e) {
		int p1 = s;
		int p2 = m+1;
		int k = s;
		while(p1 <= m && p2 <= e) {
			if(num[p1] < num[p2]) {
				temp[k++] = num[p1++];
			}
			else {
				temp[k++] = num[p2++];
			}
		}
		while(p1 <= m) {
			temp[k++] = num[p1++];
		}
		while(p2 <= e) {
			temp[k++] = num[p2++];
		}
		for(int i = s; i <= e; i++) {
			num[i] = temp[i];
		}
	}
}
