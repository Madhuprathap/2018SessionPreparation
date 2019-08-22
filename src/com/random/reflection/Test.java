package com.random.reflection;

import java.lang.reflect.Field;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		Manager.addToMap("madhu1", "madhu1");
		Manager.addToMap("madhu2", "madhu2");
		Manager.addToMap("madhu3", "madhu3");
		
		try {
			Field instance = Manager.class.getDeclaredField("INSTANCE");
			instance.setAccessible(true);
			Manager manager = (Manager) instance.get(null);
			Field executorsField = Manager.class.getDeclaredField("executors");
            executorsField.setAccessible(true);
            Map<String, String> executors = (Map<String, String>) executorsField.get(manager);
            System.out.println(executors.values());
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Manager.stop();
	}
}
