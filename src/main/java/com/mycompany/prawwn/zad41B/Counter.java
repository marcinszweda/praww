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
public class Counter {
    private int balans=0;
    private int N=1000000;

    public int getBalans() {
        return balans;
    }

    public void setBalans(int balans) {
        this.balans = balans;
    }

    public int getN() {
        return N;
    }
    
    
    public static void main(String [ ] args){
        
        int i=0;
        
        boolean enabled = false;
		assert (enabled = true);
		if (!enabled) {
			System.out.println("Wlacz asercje!!!");
			System.exit(0);
		}
        
        while(true) {
            Counter counter = new Counter();
            int warPocz = counter.getBalans();
        
            Thread plus = new Thread(new Plus(counter));
            Thread minus = new Thread(new Minus(counter));
        
            plus.start();
            minus.start();
        
            while(plus.isAlive() && minus.isAlive()){
                //se czekamy
            }
            
            
            assert(counter.getBalans() != 0);
            
            if (counter.getBalans() != 0){
                System.out.println( "wart pocz :" + warPocz  + " wart koncowa :" + counter.getBalans());
            }
            else {
                 System.out.println( "wart pocz :=  wart koncowa :)" + counter.getBalans());
            }
            
            i++;
        
        }
        
        
    }
    
}
