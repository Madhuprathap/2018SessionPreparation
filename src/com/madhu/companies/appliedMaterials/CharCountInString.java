package com.madhu.companies.appliedMaterials;

import java.util.Scanner;

public class CharCountInString {

	public static void main(String[] args) {
//		int[] counts = new int[26];
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		StringBuilder output = new StringBuilder();
		int count = 1;
		for (int i = 0; i < input.length(); i++) {
//			char temp = input.charAt(i);
//			int indexOfCounts = temp-'A';
//			counts[indexOfCounts] = counts[indexOfCounts] + 1;
			
			if (i+1 < input.length() && input.charAt(i) == input.charAt(i+1)) {
				count++;
			} else {
//				System.out.print(input.charAt(i)+count);
				output.append(input.charAt(i));
				output.append(count);
				count = 0;
			}
		}
		System.out.println(output);
	}

}
