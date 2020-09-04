package Day3;

import java.io.*;
import java.util.*;

public class p_1927 {

	static ArrayList<Integer> min_heap;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		min_heap = new ArrayList<>();

		min_heap.add(0);

		for(int i = 0; i < N; i++) {
			int t = Integer.parseInt(br.readLine());
			if(t==0) {
				if(min_heap.size()>1) {
					System.out.println(min_heap.remove(1));
					if(min_heap.size()>1)
						heapRemove();
				}
				else {
					System.out.println(0);
				}
			}
			else {
				min_heap.add(t);
				heapAdd();
			}
		}

	}
	
	static void heapAdd() {
		int n = min_heap.size()-1;
		while(n>1) {
			if(min_heap.get(n)<min_heap.get(n/2)) {
				change(n,n/2);
				n /= 2;
			}
			else {
				break;
			}
		}
	}

	static void heapRemove() {
		int t = min_heap.remove(min_heap.size()-1);
		min_heap.add(1,t);
		int ind = 1;
		while(true) {
			if(min_heap.size()-1<ind*2) {
				break;
			}
			else if(min_heap.size()-1<ind*2+1) {
				if(min_heap.get(ind)>min_heap.get(ind*2)){
					change(ind,ind*2);
				}
				break;
			}
			else {
				if(min_heap.get(ind)>min_heap.get(ind*2)&&min_heap.get(ind)<=min_heap.get(ind*2+1)) {
					change(ind,ind*2);
					ind = ind*2;
				}
				else if(min_heap.get(ind)<=min_heap.get(ind*2)&&min_heap.get(ind)>min_heap.get(ind*2+1)) {
					change(ind, ind*2+1);
					ind = ind*2+1;
				}
				else if(min_heap.get(ind)>min_heap.get(ind*2)&&min_heap.get(ind)>min_heap.get(ind*2+1)){
					if (min_heap.get(ind*2)<min_heap.get(ind*2+1)) {
						change(ind,ind*2);
						ind = ind*2;
					}
					else {
						change(ind,ind*2+1);
						ind = ind*2+1;
					}
				}
				else {
					break;
				}
			}
		}
	}

	static void change(int i1, int i2) {
		int temp = min_heap.get(i1);
		min_heap.set(i1, min_heap.get(i2));
		min_heap.set(i2, temp);
	}

}
