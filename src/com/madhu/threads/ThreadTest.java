package com.madhu.threads;

public class ThreadTest {

	public static void main(String[] args) {
		Thread t = new ThreadServive();
		t.setDaemon(true);
		t.start();
		System.out.println("thread!");
	}
}

class ThreadServive extends Thread {
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 200000; i++) {
			System.out.println(i);
		}
	}
	
}
