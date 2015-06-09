package com.mycompany.prawwn.zad73;


import java.util.concurrent.Semaphore;

public class Semafor {
	public static int LICZBA_FILOZOFOW = 5;
	public static final Semaphore[] widelec = new Semaphore[LICZBA_FILOZOFOW];
        public static final Semaphore lokaj = new Semaphore(LICZBA_FILOZOFOW-1,true);
	static {
		for (int i = 0; i < LICZBA_FILOZOFOW; i++)
			widelec[i] = new Semaphore(1);
	}
}