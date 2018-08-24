package com.madhu.companies.appliedMaterials;

import java.util.Scanner;
import java.util.Stack;

public class BracketMatching {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		Stack stack = new Stack();
		boolean flag = true;
		for (int i = 0; i < input.length(); i++) {
			char temp = input.charAt(i);
			
			if (temp == '{' || temp == '[' || temp == '(') {
				stack.push(temp);
			} else {
				char out = (char) stack.pop();
				if (!isMatched(temp, out)) {
					flag = false;
					break;
				}
			}
		}
		
		if (flag) {
			System.out.println("Matched!");
		} else {
			System.out.println("Not Matched!");
		}
	}

	private static boolean isMatched(char temp, char out) {
		if (temp == '}' && out == '{') {
			return true;
		} else if (temp == ']' && out == '[') {
			return true;
		} else if (temp == ')' && out == '(') {
			return true;
		} return false;
	}

}
