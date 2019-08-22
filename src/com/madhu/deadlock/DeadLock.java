package com.madhu.deadlock;

public class DeadLock {

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			synchronized(Integer.class) {
				System.out.println("Took look on Integer class level monitor");
				synchronized (String.class) {
					System.out.println("Took look on String class level monitor");
				}
			}
		});
		
		Thread t2 = new Thread(() -> {
			synchronized (String.class) {
				System.out.println("Took look on String class level monitor");
				synchronized(Integer.class) {
					System.out.println("Took look on Integer class level monitor");
				}
			}
		});
		
		t1.start();
		t2.start();
	}
	
	public Integer defaultValue() {
		return null;
	}
}