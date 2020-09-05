/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.exmaple;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author pravisin
 */
public class NewClass {
     public static void main(String[] args) {
          AtomicLong lon=new AtomicLong(1000);
          System.out.println(((lon.get()%100)==0l)+ "   hhhh");
     }
}
