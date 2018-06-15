/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adaindex;

import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author aliel
 */

class LSE{
    private No cabecaLista;
    private int nElementos;
    public class No{
        private String conteudo;
        private No prox;
        
        public No() {
            setProx(null);
        }
        public void setConteudo(String s){
            conteudo = s;
        }
        public String getConteudo(){
            return conteudo;
        }
        public void setProx(No prox){
            this.prox = prox;
        }
        public No getProx(){
            return prox;
        }
    }
    public LSE(){
        cabecaLista = null;
        nElementos = 0;
    }
    public void insereFimLista(String palavra){
    try{
        if(nElementos == 0){
            No novoNo = new No();
	    novoNo.setConteudo(palavra);
	    novoNo.setProx(cabecaLista);
	    cabecaLista = novoNo;
	    nElementos++;
        }
        else{
            No novoNo = new No();
            novoNo.setConteudo(palavra);
            No aux = this.cabecaLista;
            while(aux.getProx() != null){
                aux = aux.getProx();
            }        
            novoNo.setProx(null);
            aux.setProx(novoNo);
            this.nElementos++;
        }
        }catch(Exception e) {} 
    }
    public String elemento(int pos){
    
        No aux = cabecaLista;
        for(int i=1;i<pos;i++){
            aux = aux.getProx();
    
        }
       
        return aux.getConteudo();
       
    }
    //peguei essa estrutura de lista toda pronta já no site de estrutura é necesasrio pra fazer a questão
 
    public static void main(String[] args) throws IOException{
    try{   
        int N,Q;
        //quantidade de palavras e prefixos
        int contador = 0;
        LSE palavras = new LSE();
        //onde elas serão armazenadas
        LSE prefixos = new LSE();
       
        BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
        
        String aux,aux2,aux3;
        
        aux3 = entrada.readLine(); 
        String valores[];
        valores = aux3.split(" ");// para fazer a entrada como o spoj pede
        N = Integer.parseInt(valores[0]);
        Q = Integer.parseInt(valores[1]);
   
    
        
        for(int i = 1;i<=N;i++){
           String k = entrada.readLine(); 
           palavras.insereFimLista(k);
            
           //inserindo palavras
        }
        
        for(int i = 1;i<=Q;i++){
           String k = entrada.readLine(); 
           prefixos.insereFimLista(k);
           
           //inserindo prefixos
        }  //encontrado prefixos
        for (int i = 1; i <= Q; i++){
          aux = (String) prefixos.elemento(i);
         for(int j = 1; j <= N; j++){
             aux2 = (String) palavras.elemento(j);
             if((aux2.startsWith(aux))== true){
                 contador++; 
                 
             }   
         }
            System.out.println(contador);  
            contador = 0; //zerando para não acumular com o anterior
       
    }
   }catch(Exception e) {}   
   
  } 
    
  
}   
     
