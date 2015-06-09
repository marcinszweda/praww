package com.mycompany.prawwn.zad72;

import java.util.concurrent.Semaphore;

public class Semafor {
	public static int LICZBA_FILOZOFOW = 5;
	public static final Semaphore[] widelec = new Semaphore[LICZBA_FILOZOFOW];
	static {
		for (int i = 0; i < LICZBA_FILOZOFOW; i++)
			widelec[i] = new Semaphore(1);
	}
}