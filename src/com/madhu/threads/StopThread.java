package com.madhu.threads;

public class StopThread {
	public static void main(String[] args) {
		BreakCondition flag = new BreakCondition();
		Thread t = new Thread(new MyThread(flag));
		t.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flag.flag = true;
		System.out.println("stopped");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("stopped");
	}
}

class MyThread implements Runnable {

	BreakCondition flag;
	
	public MyThread(BreakCondition flag) {
		this.flag = flag;
	}
	
	@Override
	public void run() {
		while (true) {
			if (flag.flag) {
				break;
			} else {
				System.out.println("continue..");
			}
		}
	}
}

class BreakCondition {
	public volatile boolean flag = false;
}
