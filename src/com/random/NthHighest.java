package com.random;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class NthHighest {
	public static void main(String[] args) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			queue.add(scanner.nextInt());
		}
		
		System.out.println(queue.poll()); 
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		
	}
}
