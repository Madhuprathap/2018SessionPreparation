package com.madhu.geeksforgeeks.DP;

import java.util.Scanner;
import java.util.regex.Pattern;

//Regular expression matching using dynamic programming bottom up fashion

// T[i][j] collection to fill bottom up fashion

// i -> to track the string to compare
// j -> to track the regex

public class PatternMatch {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		String regex = scanner.nextLine();
		System.out.println("Pattern match status: " + patterMatchUtil(text, regex));
	}

	private static boolean patterMatchUtil(String text, String regex) {
		// Double dimension array to store repeated subproblems solutions
		boolean[][] T = new boolean[text.length()+1][regex.length()+1];
		
		//0 - length text & 0 -length regex, there is a match
		T[0][0] = true;
		
		
		// with 0 length regex
		for (int i = 1; i <= text.length(); i++) {
			T[i][0] = false;
		}
		// with 0 length text
		for (int i = 1; i <= regex.length(); i++) {
			T[0][i] = false;
		}
		
		for (int i = 1; i <= text.length(); i++) {
			for (int j = 1; j <= regex.length(); j++) {
				if (text.charAt(i-1) == regex.charAt(j-1) || regex.charAt(j-1) == '.') {
					T[i][j] = T[i-1][j-1];
				} 
				else if (regex.charAt(j-1) == '*') {
					// first check does zero occurrences work.
					if (T[i][j-2] == true) {
						T[i][j] = T[i][j-2];
					} 
					// one more occurrences of character before *
					else if (text.charAt(i-1) == text.charAt(j-2) || regex.charAt(j-2) == '.') {
						T[i][j] = T[i-1][j];
					} else {
						T[i][j] = false;
					}
				} else {
					T[i][j] = false;
				}
			}
		}
		return T[text.length()][regex.length()];
	}

}
