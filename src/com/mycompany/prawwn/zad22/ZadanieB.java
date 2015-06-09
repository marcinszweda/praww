/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prawwn.zad22;

import java.util.Random;

/**
 *
 * @author admin
 */
public class ZadanieB implements Runnable {
    private static final int MAX = 20;
    
     
    
    public static void main(String [ ] args){
       System.setErr(System.out);
          
       Runnable r = new ZadanieB();
       
       // definicja grupy wraz z handlerem
		ThreadGroup group = new ThreadGroup("grupa") {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				logException(t, e, "Handler grupy");
			}
		};
       
       // rejestracja handlera domyslnego
		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				logException(t, e, "Handler domyslny");
			}
		});

		Thread a = new Thread(group, r, "A");
		// rejestracja handlera dedykowanego dla watka A
		a.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				logException(t, e, "Handler dedykowany");
			}
		});

		// brak handlera dedykowanego
		// jest handler dla grupy
		Thread b = new Thread(group, r, "B");

		// brak handlera dedykowanego i handlera dla grupy
		// jest handler domyslny
		Thread c = new Thread(r, "C");

		a.start();
		b.start();
		c.start();
       
    }   

    @Override
    public void run() {
        Random r = new Random();
        int stop = r.nextInt(MAX);
        
        for(int i=0;i<MAX;i++) {
            System.out.println(Thread.currentThread().getName() + " :" + i);
            if(i==stop){
                throw new RuntimeException("Osiagnieta liczbe " + i);
            }
                        
        }      
        try {
            Thread.sleep(1000);
            }
        catch (InterruptedException e){
        return;
    }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static void logException(Thread t, Throwable e, String title) {
		String excName = e.getClass().getName();
		String message = e.getMessage();
		String threadName = t.getName();
		System.out.print("--- " + title + " ---> ");
		System.out.println("W watku: " + threadName + " wystapil wyjatek: "
				+ excName);
		System.out.println(message + "\n");
	}
}
