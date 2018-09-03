package com.madhu.geeksforgeeks.DP;


/*https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
	
DP solution */
public class LargestSumContiguousSubArray {
	
	public static void main(String[] args) {
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
