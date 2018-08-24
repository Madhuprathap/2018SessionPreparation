package com.madhu.backtracking;

import java.util.Arrays;

import com.madhu.geeksforgeeks.DP.LCS;

/*Find row, col of an unassigned cell
If there is none, return true
For digits from 1 to 9
  a) If there is no conflict for digit at row, col
      assign digit to row, col and recursively try fill in rest of grid
  b) If recursion successful, return true
  c) Else, remove digit and try another
If all digits have been tried and nothing worked, return false*/
public class Sudoko {
	static int N = 9;
	
	public static void main(String[] args) {
		int grid[][] = {
				{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
                };
		if (solveSudoku(grid))
			printGrid(grid);
		else
			System.out.println("No solution exists");
	}

	private static void printGrid(int[][] grid) {
//		LCS.loop(grid, (i, j) -> {System.out.print(grid[i][j]+ " ");});
		/*for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(grid[i][j]+ " ");
			}
			System.out.println();
		}*/
		Arrays.stream(grid).map(Arrays::toString).forEach(System.out::println);
	}
	
	private static boolean solveSudoku(int[][] grid) {
		//callby-ref so that we can revert to zero while backtracking.
		int[] rowCol = new int[2];
		if (!findUnassignedLocation(grid, rowCol)) {
			return true; //success
		}
		//consider 1 to 9 for current cell
		int row = rowCol[0];
		int col = rowCol[1];
		for (int i = 1; i <= 9; i++) {
			if (isSafe(grid, row, col, i)) {
				grid[row][col] = i;
				
				if (solveSudoku(grid)) {
					return true;
				}
				
				grid[row][col] = 0;
			}
		}
		
		return false;
	}

	private static boolean isSafe(int[][] grid, int row, int col, int value) {
		//For row range
		for (int j = 0; j < N; j++) {
			if(grid[j][col] == value) {
				return false;
			}
		}
		
		//For col range
		for (int j = 0; j < N; j++) {
			if (grid[row][j] == value) {
				return false;
			}
		}
		
		//With in the grid range
		int boxStartRow = row - row%3;
		int boxStartCol = col - col%3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[boxStartRow+i][boxStartCol+j] == value) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean findUnassignedLocation(int[][] grid, int[] rowCol) {
		for (int row = rowCol[0]; row < N; row++) {
			for (int col = rowCol[1]; col < N; col++) {
				if (grid[row][col] == 0) {
					rowCol[0] = row;
					rowCol[1] = col;
					return true;
				}
			}
		}
		return false;
	}
}
