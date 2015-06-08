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
public class ZadanieA implements Runnable {
    private static final int MAX = 20;
    
     
    
    public static void main(String [ ] args){
       System.setErr(System.out);
          
       Runnable r = new ZadanieA();
       
       new Thread(r,"a").start();
       new Thread(r,"b").start();
       new Thread(r,"c").start();
       
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
    
    
}
