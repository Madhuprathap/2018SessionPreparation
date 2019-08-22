package com.random.reflection;

import java.util.HashMap;
import java.util.Map;

public class Manager {
	private static final Manager INSTANCE = new Manager();
	private Map<String, String> executors;
	private Manager() {
		executors = new HashMap<>();
	}
	
	public static void addToMap(String s1, String s2) {
		INSTANCE.executors.put(s1, s2);
	}
	
	public static void stop() {
		INSTANCE.test();
	}
	
	public synchronized void test() {
		notify();
	}
}
