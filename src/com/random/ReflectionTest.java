package com.random;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectionTest {
	private static boolean sJobRunning = false;
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException  {
		System.out.println(sJobRunning);
		
		Field f = ReflectionTest.class.getDeclaredField("sJobRunning");
        f.setAccessible(true);
//        Field modifiersField = Field.class.getDeclaredField("modifiers");
//        modifiersField.setAccessible(true);
//        modifiersField.setInt(f, f.getModifiers() & ~Modifier.FINAL);
        f.set(null, true);
        
        System.out.println(sJobRunning);
	}
}
