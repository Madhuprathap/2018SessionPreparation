package com.madhu.geeksforgeeks.DP;

import java.util.Scanner;

public class LCSJ8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input1 = scanner.nextLine();
		String input2 = scanner.nextLine();
		
		int[][] LCS = new int[input1.length()+1][input2.length()+1];
		
		for (int i = 1; i <= input1.length(); i++) {
			for (int j = 1; j <= input2.length(); j++) {
				if (input1.charAt(i-1) == input2.charAt(j-1)) {
					LCS[i][j] = 1 + LCS[i][j-1];
				} else {
					LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
				}
			}
		}

		System.out.println(LCS[input1.length()][input2.length()]);
	}
}
