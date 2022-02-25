package com.yzq.thisfunc;

import org.junit.jupiter.api.Test;

import java.util.*;
  
/**
 * @author yanni
 */
public class DiffDemoTest {
 @Test
   void timeTest() {
      try {
         long start = System.currentTimeMillis( );
         System.out.println(new Date( ) + "\n");
         Thread.sleep(5*60*10);
         System.out.println(new Date( ) + "\n");
         long end = System.currentTimeMillis( );
         long diff = end - start;
         System.out.println("Difference is : " + diff);
      } catch (Exception e) {
         System.out.println("Got an exception!");
      }
   }
}