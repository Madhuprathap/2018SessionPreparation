package com.madhu.geeksforgeeks.DP;

import java.util.Comparator;
import java.util.PriorityQueue;

/*https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
	
*/
public class LargestSumContiguousSubArray {
	
	public static void main(String[] args) {
//		PriorityQueue<Integer> pQueue = new PriorityQueue<>(20, new Comparator<Integer>() {
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o2.compareTo(o1);
//			}
//		});
		PriorityQueue<Integer> pQueue = new PriorityQueue<>(20, (o1, o2) -> o2.compareTo(o1));
		pQueue.add(5);
		pQueue.add(3);
		pQueue.add(10);
		System.out.println(pQueue.peek());
		System.out.println("----------------");
//		int [] array = {-2, -3, -4, -1, -2, -1, -5, -3};
		int [] array = {-2, -3, 4, -1, -2, 1, 5, -3};
		
		int max_so_far = array[0];
		int curr_max = array[0];
		
		for (int i = 0; i < array.length; i++) {
			curr_max = Math.max(array[i], curr_max+array[i]);
			max_so_far = Math.max(max_so_far, curr_max);
		}
		
		System.out.println(max_so_far);
	}
}
