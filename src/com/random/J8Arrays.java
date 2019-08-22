package com.random;

import java.util.stream.IntStream;

public class J8Arrays {
	public static void main(String[] args) {
		
		int[] dout = IntStream.range(0, 5).flatMap(i -> IntStream.range(0, 5).map(j -> {
			return (i*j)+j;
		})).toArray();
		
		int[] out = IntStream.range(0, 5).map(i -> i).toArray();
		System.out.println(out);
	}
}
