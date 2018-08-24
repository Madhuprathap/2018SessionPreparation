package com.madhu.companies.appliedMaterials;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestIncrementalSequence {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = scanner.nextInt();
		}
		
		int longestSequenceSize = 1;
		int currentSequenceSize = 1;
		int startIndex = -1;
		int endIndex = -1;
		for (int i = 0; i < input.length; i++) {
			if (i+1 < input.length && input[i] == input[i+1]-1) {
				currentSequenceSize++;
			} else if (currentSequenceSize > longestSequenceSize) {
				longestSequenceSize = currentSequenceSize;
				currentSequenceSize = 1;
				startIndex = (i - longestSequenceSize + 1) < 0 ? 0 : (i - longestSequenceSize + 1);
				endIndex = i;
			}
		}
		
		System.out.println(longestSequenceSize);
		System.out.println(startIndex + " " + endIndex);
		
		
		String name1 = new String("Madhu");
		String name2 = new String("Madhu");
		System.out.println(name1.equals(name2));
	}

}
