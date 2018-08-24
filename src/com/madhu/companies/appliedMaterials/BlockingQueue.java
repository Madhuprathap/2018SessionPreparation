package com.madhu.companies.appliedMaterials;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {
	private int size = 100;
//	final Object[] items;
	private final LinkedList<T> queue;
	public BlockingQueue() {
//		items = new Object[size];
		queue = new LinkedList<T>();
	}
	BlockingQueue(int size) {
		this.size = size;
//		items = new Object[size];
		queue = new LinkedList<T>();
	}
	
	private final ReentrantLock lock = new ReentrantLock(true);
	private final Condition notFull = lock.newCondition();
	private final Condition notEmpty = lock.newCondition();
	
	private void put(T element) throws InterruptedException {
		if (element == null) {
			throw new NullPointerException();
		}
		lock.lock();
		try{
			while (queue.size() == size) {
				notFull.await();
			}
			queue.add(element);
			notEmpty.signalAll();
		} finally {
			lock.unlock();
		}
		
	}
	
	private T take() throws InterruptedException {
		lock.lock();
		try{
			while (queue.isEmpty()) {
				notEmpty.await();;
			}
			T out = queue.getFirst();
			notFull.notifyAll();
			return out;
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		final int[] test = new int[5];
		test[0] = 2;
		test[1] = 1;
		test[2] = 4;
		test[3] = 5;
		test[4] = 3;
		
		Arrays.sort(test);
		Arrays.stream(test).forEach(System.out::print);
		
	}
	
}
