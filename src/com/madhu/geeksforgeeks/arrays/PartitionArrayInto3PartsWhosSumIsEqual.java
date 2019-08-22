package com.madhu.geeksforgeeks.arrays;

import java.util.Scanner;

public class PartitionArrayInto3PartsWhosSumIsEqual {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter array size");
		int size = scanner.nextInt();
		int[] input = new int[size];
		for (int i = 0; i < size; i++) {
			input[i] = scanner.nextInt();
		}

		// partition logic
		int sum = 0;
		int[] prefixSum = new int[size];
		for (int i = 0; i < input.length; i++) {
			sum = sum + input[i];
			prefixSum[i] = sum;
		}
		sum = 0;
		int[] suffixSum = new int[size];
		for (int i = input.length - 1; i >=0 ; i--) {
			sum = sum + input[i];
			suffixSum[i] = sum;
		}

		boolean found = false;

		int total_sum = sum;
		int pos1 = -1, pos2 = -1;
		int i = 0, j = size -1;
		while (i < j) {
			if (prefixSum[i] == total_sum / 3) {
				pos1 = i;
			}

			if (suffixSum[j] == total_sum / 3) {
				pos2 = j;
			}

			if (pos1 != -1 && pos2 != -1) {
				if (prefixSum[pos2 - 1] - prefixSum[pos1] == total_sum / 3) {
					found = true;
				} else {
					found = false;
				}
			}

			if (prefixSum[i] > suffixSum[j]) {
				j --;
			} else {
				i ++;
			}
		}
		if (found) {
			System.out.print("First Segment : "); 
			for (int k = 0; k <= pos1; k++) { 
				System.out.print(input[k] + " "); 
			} 

			System.out.println(); 

			System.out.print("Second Segment : "); 
			for (int k = pos1 + 1; k < pos2; k++) { 
				System.out.print(input[k] + " "); 
			} 

			System.out.println(); 

			System.out.print("Third Segment : "); 
			for (int k = pos2; k < input.length; k++) { 
				System.out.print(input[k] + " "); 
			} 
		} else {
			System.out.println("Array cannot be divided into three equal sum segments"); 
		}
	}
}
