package com.mycompany.prawwn.zad60;

public class AssertTest {

	public static void checkAssertionsEnabled() {
		boolean enabled = false;
		assert (enabled = true);
		if (!enabled) {
			System.out.println("Wlacz asercje!!!");
			System.exit(0);
		}
	}
}
