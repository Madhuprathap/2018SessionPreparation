package com.madhu.backtracking;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class NQueensProblem {
	
	static class Pair {
		int row;
		int col;
		Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
		@Override
		public String toString() {
			return this.row + " " + this.col;
		}
	}
	static int size;
	static Pair[] queensPositions;

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of Queens to arange:");
		size = scanner.nextInt();
		queensPositions = new Pair[size];
		positionQueens(0, queensPositions);
//		Stream.of(queensPositions).forEach(pair -> System.out.println(pair.row + " " + pair.col));
		Arrays.stream(queensPositions).forEach(pair -> System.out.println(pair.row + " " + pair.col));
	}

	private static boolean positionQueens(int row, Pair[] queensPositions) {
		// Base condition; if satisfied we got the solution
		if (row == size) {
			return true;
		}
		for (int col = 0; col < size; col++) {
			boolean found = true;
			
			//check if this row and col is not under attack from any previous queen.
			for (int queen = 0 ; queen < row ; queen ++) {
				Pair pair = queensPositions[queen];
				if (pair.col == col || pair.row - pair.col  == row-col || pair.row + pair.col  == row+col) {
					found = false;
					break;
				}
			}
			if (found) {
				queensPositions[row] = new Pair(row, col);
				if (positionQueens(row+1, queensPositions)) {
					return true;
				}
			}
		}
		return false;
	}

}
