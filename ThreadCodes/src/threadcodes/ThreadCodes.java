/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadcodes;

import java.util.Scanner;

/**
 *
 * @author pravisin
 */
public class ThreadCodes {

     /**
      * @param args the command line arguments
      */
    static  volatile  boolean flag=true;
     public static void main(String[] args) {
         
          Scanner sc=new Scanner(System.in);
          sc.nextLine();
          Thread t=new Thread(new Runnable() {
               @Override
               public void run() {
                    int i=0;
                    while(true){
                         System.out.println("p"+(i++));
                    }
               }
          });
          
          t.start();
         //  sc.nextLine();
           System.out.println("End of main thread");
          
     }
     
}
