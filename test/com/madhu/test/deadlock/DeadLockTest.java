package com.madhu.test.deadlock;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.madhu.deadlock.DeadLock;

import mockit.Mock;
import mockit.MockUp;

public class DeadLockTest {
	@Test
	public void testForDeadLok() {
		new MockUp<DeadLock>() {
			@Mock
			public Integer defaultValue() {
				return 0;
			}
		};
		int value = new DeadLock().defaultValue();
		assertEquals(0, value);
	}
}