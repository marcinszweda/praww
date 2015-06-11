package com.mycompany.prawwn.zad111;

import java.util.Random;

public class EskimosMaly implements Runnable {
	private static Random spioch = new Random();
        
        private Wazna wazna;

    public EskimosMaly(Wazna wazna) {
        this.wazna = wazna;
    }
        
        
	private void sekcjaLokalna() throws InterruptedException {
		Thread.sleep(100);
	}

	private void sekcjaKrytyczna() throws InterruptedException {
            
                 synchronized (this.wazna) {
                 wazna.setDana((wazna.getDana())+1);
		System.out.println("maly: Teraz krytyczna dana = " + wazna.getDana());
		assert (wazna.getDana() < 3) : "Wazna dana = " + wazna.getDana();
		Thread.sleep(spioch.nextInt(10));
		wazna.setDana((wazna.getDana())-1);
                 
                 }
            
		
	}

	@Override
	public void run() {
		while (true) {
			try {
				sekcjaKrytyczna();
				sekcjaLokalna();
			} catch (InterruptedException e) {
				System.out.println("maly zakonczyl dzialanie");
				return;
			}
		}
	}
}
