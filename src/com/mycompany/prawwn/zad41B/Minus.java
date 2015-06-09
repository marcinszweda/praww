/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prawwn.zad41B;

/**
 *
 * @author admin
 */
public class Minus implements Runnable{
    
    Counter counter;

    public Minus(Counter counter) {
        this.counter = counter;
    }
    
    
    
    @Override
    public void run() {
        
        for(int i=0;i<counter.getN();i++){
            counter.setBalans(counter.getBalans()-1);
        }
        
        
    }
    
}
