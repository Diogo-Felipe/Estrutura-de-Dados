package ED;

import java.util.*;

public class Pilha {
	
	private static class STACK{
		public int num;
		public STACK prox;
	}

	public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        STACK topo = null;
        
        STACK aux;
            
        int op;
        
        do {
        	
        	System.out.println("\nMENU DE OPCOES\n");
            System.out.println("1 - Inserir na pilha");         
            System.out.println("2 - Consultar toda a pilha");
            System.out.println("3 - Remover da pilha");
            System.out.println("4 - Esvaziar a pilha");
            System.out.println("5 - sair");
            System.out.print("Digite sua opção");
            
            if(op < 1 || op > 5) System.out.println("Opção inválida!");
            
            //CRIAR O NO E EMPILHAR (PUSH)
            if(op == 1){
            
            	System.out.println("Digite o número a ser inserido na pilha: ");
             
            	STACK novo = new STACK();
            	novo.num = entrada.nextInt();
            	novo.prox = topo;
            	topo = novo;          
            
            	System.out.println("Número inserido na pilha");
            }
            
            //CONSULTA A PILHA
            if(op == 2) {
            	if(topo == null) System.out.println("Pilha vazia!");
                else {
                    aux = topo;
                    while(aux != null){
                        System.out.println(aux.num + " ");
                        aux = aux.prox;
                    }
                }  
            }
            
          //DESEMPILHAR (POP)
          if(op == 3) {
              if(topo == null) System.out.println("Pilha vazia!");
              else {
              
                  System.out.println("Número " + topo.num + " removido!");
                  topo = topo.prox;
              
              } 
          }
            
        }while();
	}

}
