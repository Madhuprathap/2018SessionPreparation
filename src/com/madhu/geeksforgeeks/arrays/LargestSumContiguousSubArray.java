package com.madhu.geeksforgeeks.arrays;


/*https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/

O(n) Complexity*/
public class LargestSumContiguousSubArray {

	public static void main(String[] args) {
		int [] array = {-2, -3, 4, -1, -2, 1, 5, -3};
		// Does not handle negative array
		int max_so_for = 0;
		int curr_max = 0;
		for (int i = 0; i < array.length; i++) {
			curr_max = curr_max + array[i];
			if (curr_max > max_so_for) {
				max_so_for = curr_max;
			}
			if (curr_max < 0) {
				curr_max = 0;
			}
		}

		System.out.println(max_so_for);
	}
}
