package com.madhu.geeksforgeeks.DP;

import java.util.Arrays;
import java.util.function.BiConsumer;

//https://www.geeksforgeeks.org/longest-common-subsequence/
public class LCS {

	public static void main(String[] args) {
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Length of LCS is" + " " + lcs(X, Y, m, n));

	}

	private static int lcs(char[] x, char[] y, int m, int n) {
		int[][] LCSTable = new int[m + 1][n + 1];
		// LCSTable[0] = Arrays.stream(LCSTable[0]).map(i -> 0).toArray();
		// TO makes sure initial values of 1 row and 1 column is zero
		loop(LCSTable, (i, j) -> {
			if (i == 0 || j == 0) {
				LCSTable[i][j] = 0;
			}
		});
		loop(LCSTable, (i, j) -> {
			if (i == 0 || j == 0) {
			} else {
				if (x[i-1] == y[j-1]) {
					LCSTable[i][j] = LCSTable[i-1][j-1] + 1;
				} else {
					LCSTable[i][j] = Math.max(LCSTable[i-1][j], LCSTable[i][j-1]);
				}
			}
			
		});
		
		Arrays.stream(LCSTable).map(Arrays::toString).forEach(System.out::println);

		return LCSTable[m][n];
	}

	public static void loop(int[][] values, BiConsumer<Integer, Integer> consumer) {
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values[i].length; j++) {
				consumer.accept(i, j);
			}
		}
	}

}
