/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prawwn.zad85;

import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;

/**
 *
 * @author admin
 */
public class Gracz implements Runnable{
    int name;
    Random random = new Random();    
    PipedReader pr;
    PipedWriter pw;

    public Gracz(int name, PipedReader pr, PipedWriter pw) {
        this.name = name;
        this.pr = pr;
        this.pw = pw;
    }
    
    

    
    
        
    
    @Override
    public void run() {
        
    }
    
    
}
