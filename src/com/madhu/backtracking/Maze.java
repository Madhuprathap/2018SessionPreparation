package com.madhu.backtracking;

import java.util.Arrays;

//The rat can move only in two directions: forward and down.
public class Maze {
	static int m = 4;
	static int n = 4;
	public static void main(String[] args) {
		int[][] input = {
				{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
                };
		int[][] output = new int[m][n];
		//starts at row = 0 and col = 0
		boolean canEscape = solveMaze(input, output, 0, 0);
		if (canEscape) {
//			Arrays.stream(output).forEach(row -> Arrays.stream(row).forEach(System.out::print));
			Arrays.stream(output).map(Arrays::toString).forEach(System.out::println);
		} else {
			System.out.println("Rat is dead!!");
		}
		
	}

	private static boolean solveMaze(int[][] input, int[][] output, int row, int col) {
		if (isSafe(input, row, col)) {
			// Base condition
			if (row == input.length-1 && col == input.length-1) {
				output[row][col] = 1;
				return true;
			}
			output[row][col] = 1;
			
			if (solveMaze(input, output, row+1, col)) {
				return true;
			}
			
			if (solveMaze(input, output, row, col+1)) {
				return true;
			}
			
			// back tracking we have to revert the modified array to base state
			output[row][col] = 0;
			return false;
		}
		return false;
	}

	private static boolean isSafe(int[][] input, int row, int col) {
		if (row >= 0 && row < m &&
				col >= 0 && col < n && input[row][col] == 1) {
			return true;
		}
		return false;
	}
}
