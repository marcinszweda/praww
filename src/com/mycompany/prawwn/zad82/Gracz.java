/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prawwn.zad82;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author admin
 */
public class Gracz  implements Runnable{
    private int imie;
    private int[] wynik;
    private CyclicBarrier readySignal;

    public Gracz(int imie, int[] wynik, CyclicBarrier readySignal) {
        this.imie = imie;
        this.wynik = wynik;
        this.readySignal = readySignal;
    }
   

    

    @Override
    public String toString() {
        
        return "Gracz{" + "imie=" + imie + '}' + getGw(this.wynik);
    }
    
    private static String getGw(Integer length) {
        String ret=null;
        
        for(int i=0;i<length;i++) {
            ret=ret+"*";
        }
        
        return ret + "[" + length + "]";
               
}

    @Override
    public void run() {
       
		readySignal.
		try {
			startSignal.await();
		} catch (InterruptedException e1) {
			System.out.println(this + " has not started!");
			System.out.println("Quiting the game...");
			System.exit(0);
		}
		int tura = System.currentTimeMillis();
		try {
			Thread.sleep(r.nextInt(1000) + 2000);
		} catch (InterruptedException e) {
			System.out.println(this + " has not finished the race...");
			System.out.println("Quiting the race...");
			System.exit(0);
		}
		
		results = results + tura;
		stopSignal.countDown();
        
    }
    
    
    
    
    
}
