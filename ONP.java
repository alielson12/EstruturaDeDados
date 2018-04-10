/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onp;
//alielson 
import java.util.Scanner;
import java.util.Stack;
import java.io.*;

public class ONP {
	public static void main(String[] args) throws IOException{
            try{
                Scanner entrada = new Scanner(System.in);

                int expressoes = entrada.nextInt();
                //esse x e esse array são para a resposta sair como o spoj pede
                int x = expressoes;
                String respostas[] = new String[401];
               //while para dar operar no numero de expressoes desejadas
                while(expressoes-- > 0){
                    String expressao = entrada.next();

                    int tamanhoStr = expressao.length();
                    //pilha para fazer as operações
                    Stack<Character> pilha =  new Stack<Character>();
                    //strin reservada para saida
                    String saida = "";
                    //for para percorrer toda a expressão
                    for(int i = 0;i<tamanhoStr;i++){
                        // para simplificar o codigo fiz isso
                        char teste = expressao.charAt(i);
                        //operei apenas com ')' já que iria dar no mesmo
                        if(teste == '(')
                           continue;

                        if(teste == '+' || teste == '-' || teste == '/'|| teste =='*' || teste =='^' ){
                            pilha.add(teste);

                            continue;
                            // na ocorrencia de um desses sinais adiciona na pilha para retirar depois
                        }

                        else if (teste == ')'){
                            saida += pilha.pop();
                            continue; 
                            //utilizei uma logica bem simples a cada ocorrencia de um ')' significa que vai haver mais um sinal operacional
                            //ou seja você acaba retirando todos que foram adicionados na pilha e esvaziando toda a pilha ordenando como desejado em uma ONP
                        }

                        else{
                            saida += String.valueOf(teste);
                            continue;
                            //transforma em string
                        }


                    }
                    //trim para juntar tudo como desejado
                     respostas[expressoes] = saida.trim();                 
                }
                while(--x>=0){
                    System.out.println(respostas[x]);
                    //saida ordenada 
                }
            }catch(Exception e){
        	System.out.println(e.toString());
            }
                
        }
}