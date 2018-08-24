package com.madhu.geeksforgeeks.DP.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.madhu.geeksforgeeks.DP.LIS;

public class LISTest {
	@Test
	public void LISTestPositive(){
		int[] array = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int n = LIS.lis(array, array.length);
		assertTrue(n == 5);
	}
	@Test
	public void LISTestNegative(){
		int[] array = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int n = LIS.lis(array, array.length);
		assertTrue(n != 9);
	}
}
