package com.madhu.geeksforgeeks.arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//https://www.geeksforgeeks.org/magic-square/


public class MagicMatrix {
	final static Logger logger = LoggerFactory.getLogger(MagicMatrix.class);
	
	public static void main(String[] args) {
		int[] test = {1,2,3};
		System.out.println(Arrays.toString(test));
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter size of the magic matrix");
		int n = scanner.nextInt();
		int[][] matrix = constructMagicMatrix(n); 
		printMatix(matrix, n);
	}

	private static void printMatix(int[][] matrix, int n) {
		System.out.println("The Magic Square for "+n+":");
        System.out.println("Sum of each row or column "+n*(n*n+1)/2+":");
        /*for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println();
        }*/
        Stream.of(matrix).map(Arrays::toString).forEach(System.out::println);
//        Arrays.stream(matrix).map(Arrays::toString).forEach(System.out::println);
	}


	private static int[][] constructMagicMatrix(int n) {
		int[][] matrix = new int[n][n];
		int i = n/2, j = n-1;
		
		for(int num = 1 ; num <= n*n ;) {
			if (i == -1 && j == n) {
				 j = n-2;
	             i = 0;
			} else {
                //1st condition helper if next number 
                // goes to out of square's right side
                if (j == n)
                    j = 0;
                     
                //1st condition helper if next number is 
                // goes to out of square's upper side
                if (i < 0)
                    i=n-1;
            }
			if (matrix[i][j] == 0) {
				matrix[i][j] = num ++;
				i--;j++;
			} else {
				i++;
				j = j - 2;
			}
		}
		
		return matrix;
	}

}
