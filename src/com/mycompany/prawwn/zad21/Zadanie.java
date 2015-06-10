
package com.mycompany.prawwn.zad21;

import java.math.BigInteger;

public class Zadanie  {

    private static final int N = 100;

	public static String silnia(int n) {
		BigInteger s = BigInteger.ONE;
		for (int i = 1; i <= n; i++)
			s = s.multiply(BigInteger.valueOf(i));
		return s.toString();
	}

	public static void main(String[] args) {
		Runnable r = new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.printf(Thread.currentThread().getName()
							+ ", powt. %2d, %2d! = %s%n", i, N, silnia(N));
				}
			}
		};
		new Thread(r, "WATEK 1").start();
		new Thread(r, "WATEK 2").start();
	}
    
    
}
