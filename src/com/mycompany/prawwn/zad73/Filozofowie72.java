package com.mycompany.prawwn.zad73;


import static com.mycompany.prawwn.zad72.Semafor.LICZBA_FILOZOFOW;


public class Filozofowie72 {

	public static void main(String[] args) {
		for (int i = 0; i < LICZBA_FILOZOFOW; i++) {
			new Thread(new Filozof(i)).start();
		}
	}
}
