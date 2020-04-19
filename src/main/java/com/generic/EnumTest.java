package com.generic;

import java.util.Arrays;
import java.util.EnumSet;

import org.testng.Assert;

public class EnumTest {
	public static void main(String args[]) 
    { 
        // let's print name of each enum and there action 

  
        for (TitlePage signal : TitlePage.values()) 
        { 
            // use getter method to get the value 
            System.out.println(TitlePage.values()); 
            
            switch(signal) {
		      case MARKET:
		       System.out.println(signal.getAction());
		      default:        
		       System.out.println("What day is it?");;
		   
			}
        } 
        
      
    }
}