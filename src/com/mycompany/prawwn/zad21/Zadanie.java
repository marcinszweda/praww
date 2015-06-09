
package com.mycompany.prawwn.zad21;

import java.math.BigInteger;

public class Zadanie  {

    public static int N=1000;
    
    public static String liczSilnie(int n){
        BigInteger bi =new BigInteger("1");
        for (int i = 1;i < n;i++){
            bi=bi.multiply(new BigInteger(String.valueOf(i)));
        }
        return bi.toString();
    }
    
    public static void main(String [ ] args){
       
        Runnable r = new Runnable() {
           
            @Override
            public void run() {
                for(int j=0;j<10;j++) {
                    System.out.println("Watek o nazwie :" + Thread.currentThread().getName() + " obliczyl silnie w kroku nr" + j + "  :" + liczSilnie(N));
                }
            }
        };      
               
        new Thread(r,"watek_a").start();
        new Thread(r,"watek_b").start();
    
    
    }   
    
    
}
