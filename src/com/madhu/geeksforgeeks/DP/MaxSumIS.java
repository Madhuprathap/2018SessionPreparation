package com.madhu.geeksforgeeks.DP;

import java.util.Arrays;

public class MaxSumIS {

	public static void main(String[] args) {
		 int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
		 System.out.println("Sum of maximum sum increasing "+
                 " subsequence is "+
                 maxSumIS( arr, arr.length ) );
	}

	public static int maxSumIS(int[] arr, int length) {
		//DP - Memorization array
		//initialize to corresponding arr[i]
		int[] MIS = Arrays.stream(arr).toArray();
		
		for (int i = 0; i < MIS.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && MIS[j] +  arr [i] > MIS [i]) {
					MIS [i] = MIS[j] +  arr [i];
				}
			}
		}
		
		return Arrays.stream(MIS).reduce(0, Integer::max);
	}

}
