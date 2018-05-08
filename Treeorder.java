/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeorder;

import java.util.Scanner;

/**
 *
 * @author aliel
 */
public class Treeorder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Scanner entrada = new Scanner(System.in);
        int no = 0;
        int contador = 0;
        int tamanho = entrada.nextInt();
        int[] auxiliar = new int[2];
        int i,x;
       
        
        
        for(i=0;i<3;i++){
            //percorrer tudo
        for(x=0;x<tamanho;x++){
          //logica da arvore  
            no= entrada.nextInt();
            if(i==0 && x==0)
                auxiliar[0] = no;
            
        
            if(i==0 && x==tamanho-1)
            auxiliar[1] = no;
            
            
            
            if((i== 1 && x == tamanho-1) && auxiliar[0] == no)
             contador++;
            
             
             if(i == 2 && x == tamanho-1 && auxiliar[1] == no)
             contador++;
             
        }   
      }
        if(contador == 2)
            System.out.println("yes");
        //saida
        else
            System.out.println("no");
        
    }
    
    
  }


