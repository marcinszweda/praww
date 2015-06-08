/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prawwn.zad21;

import java.math.BigInteger;

/**
 *
 * @author admin
 */
public class Zadanie  {

    
    
       
   
 
    public static void main(String [ ] args){
       
        Runnable r = new Runnable() {
               
                

            @Override
            public void run() {
            for(int j=0;j<10;j++) {
            
        
        BigInteger bi =new BigInteger("1");
        for (int i = 1;i < 101;i++){
            bi=bi.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println("Done step :" + j  +" in thred :" + Thread.currentThread().getId());
                
        }
        
           
        }  };      
               
        new Thread(r).start();
        new Thread(r).start();
    
    
    }   
    
    
}
