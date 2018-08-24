package com.madhu.geeksforgeeks.DP;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//https://www.geeksforgeeks.org/?p=12832
public class LIS {

	public static void main(String[] args) {
		int arr[] = {70, 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println("Length of lis is " + lis(arr, arr.length));

	}

	public static int lis(int[] arr, int length) {
		//DP - Memorization array 
		//initialize with default value 1 as the least size is 1
		int[] lisMemory = Arrays.stream(new int[length]).map(n -> 1).toArray();
		
		for (int i = 0; i < lisMemory.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lisMemory[j] + 1 > lisMemory [i]) {
					lisMemory [i] = lisMemory[j] + 1;
				}
			}
		}

        /* Pick maximum of all LIS values */
		int max = 0;
       /* for ( int i = 0; i < length; i++ )
           if ( max < lisMemory[i] )
              max = lisMemory[i];*/
		max = Arrays.stream(lisMemory).reduce(0, Integer::max);

       return max;
	}

}
