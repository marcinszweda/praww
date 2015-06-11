/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prawwn.zad12;

/**
 *
 * @author admin
 */
public class Zadanie {
    
    
    public static void main(String[] args) { 
        TCPServer tcpServer = new TCPServer();
    
        Thread newtcpServer = new Thread (tcpServer);
    
        newtcpServer.start();
    
    
        while(true) {
          //dddd
         }
    
    
    }
    
    
    
    
}
