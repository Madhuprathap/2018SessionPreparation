package com.madhu.trees.problems;

import java.util.Scanner;

public class Tables {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the table you wanted to display:");
		int n = scan .nextInt();
		System.out.println("Enter the table limit:");
		int n1 = scan.nextInt();
		System.out.println("The required table is");
		for(int i = 1;i<=n1;i++){
			System.out.println(n + " * "+ i +" = " + ( n*i));
		}
	}

}
