package Heap;

import java.io.*;
import java.util.*;

public class heap {

	public static void main(String[] args) {

		

	}

}

class MinHeap{
	List<Integer> heap;
	
	public MinHeap() {
		this.heap = new ArrayList<>();
		heap.add(0);
	}
	
	public void insert(int value) {
		heap.add(value);
		int current = heap.size()-1;
		int parent = current / 2;
		while(true) {
			if(parent == 0 || heap.get(parent) < heap.get(current)) {
				break;
			}
			int temp = heap.get(parent);
			heap.set(parent, heap.get(current));
			heap.set(current, temp);
			
			current = parent;
			parent = current/2;
		}
	}
	
	public int delete() {
		if(heap.size()==1) {
			return 0;
		}
		
		int top = heap.get(1);
		heap.set(1, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		int currentPos = 1;
		while(true) {
			int leftPos = currentPos * 2;
			int rightPos = currentPos * 2;
			
			if(leftPos >= heap.size()) {
				break;
			}
			
			int minValue = heap.get(leftPos);
			int minPos = leftPos;
			
			if(rightPos < heap.size() && minValue > heap.get(rightPos)) {
				minValue = heap.get(rightPos);
				minPos = rightPos;
			}
			
			if(heap.get(currentPos) > minValue) {
				int temp = heap.get(currentPos);
				heap.set(currentPos, heap.get(minPos));
				heap.set(minPos, temp);
				currentPos = minPos;
			}
			else {
				break;
			}
		}
		return top;
	}
}
