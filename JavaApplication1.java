/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Scanner;

/**
 *
 * @author aliel
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        
        int[] array = new int[n];
        
        if(n>=2 && n<=100){
           for(int i=0;i<n;i++)
               array[i] = input.nextInt();     
        }
        
        else
            return;
       
        int m = input.nextInt();
        
        int[] array2 = new int[m];
        
         if(m>=2 && m<=100){
           for(int i=0;i<m;i++)
               array2[i] = input.nextInt(); 
        }
         else
             return;
         
         for (int i=0;i<n;i++){
             boolean auxiliar = true;
             for (int j=0;j<m;j++){
                 if(array[i]==array2[j])
                     auxiliar = false;
             }
             if(auxiliar == true){
                 System.out.print("" + array[i] + " ");
             }
             
         }
         
         
             
         
    }

    
    
}
  
    

