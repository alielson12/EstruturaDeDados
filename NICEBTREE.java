package nicebtree;

import java.util.Scanner;

/**
 *
 * @author aliel
 */
public class NICEBTREE {

    public static char[] teste = new char[1001];
    //casos de testes ate 1000
    public static int i;
    //lados
     public static int max(int max1, int max2){
        if (max1 > max2) {
            return max1;
        } else {
            return max2;
        }  
    } 
    //comprimento
    public static int tamanho() {
        if (teste[i++] == 'l') {
            return 1;
        } else {
            return max(tamanho(), tamanho()) + 1;
        }
    }
    
  
    
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        int qtd = entrada.nextInt();   
        while(qtd > 0){
            String string = entrada.next();
            teste = string.toCharArray();
            i = 0;
            System.out.println(tamanho()-1);
            qtd--;
        }
    }   
}
