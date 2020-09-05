/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadcodes;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pravisin
 */
public class ThreadVolatile {

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
                    while(flag){
                         System.out.println("p"+(i++));
                    }
                  System.out.println("End of child thread");
               }
          });
          
          t.start();
          sc.nextLine();
          flag=false;
         try {
              Thread.sleep(2000);
         } catch (InterruptedException ex) {
              Logger.getLogger(ThreadVolatile.class.getName()).log(Level.SEVERE, null, ex);
         }
         
           System.out.println("End of main thread");
          
     }
     
}
