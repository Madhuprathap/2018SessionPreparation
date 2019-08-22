package com.madhu.geeksforgeeks.arrays;

import java.util.Arrays;

public class BinaryArraySort {

	public static void main(String[] args) {
		int[] a = { 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0 };
		// To track sorted zero value index
		int j = -1;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 1) {
				j++;
//				int temp = a[i];
				a[i] = a[j];
//				a[j] = temp;
				 a[j] = 0;
			}
		}
		Arrays.stream(a).forEach(System.out::print);
	}

}
