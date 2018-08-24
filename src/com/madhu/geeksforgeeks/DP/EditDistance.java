package com.madhu.geeksforgeeks.DP;

import java.util.Arrays;
//https://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
public class EditDistance {
	public static void main(String[] args) {
		String str1 = "sunday";
        String str2 = "saturday";
        System.out.println( editDistDP( str1 , str2 , str1.length(), str2.length()) );
	}

	private static int editDistDP(String str1, String str2, int m, int n) {
		int[][] EditTable = new int[m + 1][n + 1];
		// LCSTable[0] = Arrays.stream(LCSTable[0]).map(i -> 0).toArray();
		LCS.loop(EditTable, (i, j) -> {
			if (i == 0 && j > 0) {
				EditTable[i][j] = EditTable[i][j-1] + 1;
			}
			if (j == 0 && i > 0) {
				EditTable[i][j] = EditTable[i-1][j] + 1;
			}
		});
		LCS.loop(EditTable, (i, j) -> {
			if (i == 0 || j == 0) {
			} else {
				if (str1.charAt(i-1) == str2.charAt(j-1)) {
					EditTable[i][j] = EditTable[i-1][j-1];
				} else {
					EditTable[i][j] = 1 + Math.min(EditTable[i-1][j], Math.min(EditTable[i][j-1], EditTable[i-1][j-1]));
				}
			}
			
		});
		
		Arrays.stream(EditTable).map(Arrays::toString).forEach(System.out::println);

		return EditTable[m][n];
	}
}
