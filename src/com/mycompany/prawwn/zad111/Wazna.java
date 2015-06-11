package com.mycompany.prawwn.zad111;

public class Wazna {
	private static int dana = 1;
        
        public synchronized static void setDana( int value){
            dana=value;
        }
        
        public synchronized static int getDana(){
            return dana;
        }
}