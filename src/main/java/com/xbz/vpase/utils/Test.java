package com.xbz.vpase.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

    public static void main(String[] args){
        System.out.println((Math.random()*(999999-100000+1))+100000);
        System.out.println( String.valueOf(new SimpleDateFormat("yyyyMMdd").format(new Date()))+(int)(Math.random()*9+1)*100000);


    }

}
