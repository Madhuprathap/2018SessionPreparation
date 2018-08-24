package com.madhu.trees.problems;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 5) {
					continue;
				}
				System.out.println(i + " " + j);
			}
		}
	}
}
