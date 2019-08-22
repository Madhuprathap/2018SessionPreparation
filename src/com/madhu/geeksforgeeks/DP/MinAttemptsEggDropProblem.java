package com.madhu.geeksforgeeks.DP;

import static java.util.stream.IntStream.range;

import java.util.Arrays;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class MinAttemptsEggDropProblem {
	final static Logger logger = Logger.getLogger(MinAttemptsEggDropProblem.class);
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter no of floors:");
		int floors = scanner.nextInt();
		System.out.println("Enter no of eggs:");
		int eggs = scanner.nextInt();

		//DP problem
		/*	0	1	2	3	4	5	6 --> Floors
		0	0	0	0	0	0	0	0
		1	0	1	2	3	4	5	6
		2	0	1	2	2	3	3	3
		Eggs*/
		int[][] minOfAttemps = new int[eggs+1][floors+1];
		// initialize base case
		/*IntStream intStream  = range(0, eggs+1).filter(row -> row==1).flatMap(row -> range(0, floors+1).map(col -> {
			if (row == 1) {
				return col;
			} else {
				return 0;
			}
		}));*/
		minOfAttemps[1] = minOfAttemps[1] = range(0, floors+1).toArray();
		for (int i = 2; i <= eggs; i++) {
			for (int j = 1; j <= floors; j++) {
				if (i > j) {
					minOfAttemps[i][j] = minOfAttemps[i-1][j];
				} else {
					// 1 + min(max(T[i-1][k-1]),T[i][j-k]) for k 1->j)
					int min = Integer.MAX_VALUE;
					for (int k = 1; k <= j; k++) {
						int temp = Math.max(minOfAttemps[i-1][k-1], minOfAttemps[i][j-k]);
						if (temp < min) {
							min = temp;
						}
					}
					minOfAttemps[i][j]= 1+min;
				}
			}
		}

		System.out.println(range(1,10).min().getAsInt());
		int[] a = range(1,10).flatMap(x -> range(1,10)).toArray();

		int[] out = range(2, eggs+1).flatMap(row -> range(1, floors+1).map(col -> {
			if (row > col) {
				return minOfAttemps[row-1][col];
			} else {
				return range(1, col+1).map(k -> Math.max(minOfAttemps[row-1][k-1], minOfAttemps[row][col-k])).min().getAsInt() + 1;
			}
		})).toArray();
		System.out.println(out[(eggs-1) * (floors-1)]);

		Arrays.stream(minOfAttemps).map(Arrays::toString).forEach(System.out::println);
		System.out.println("Min attemps for floors "+floors + " eggs "+eggs+" = " + minOfAttemps[eggs][floors]);
	}

}
