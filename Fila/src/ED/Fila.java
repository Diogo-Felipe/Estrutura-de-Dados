package ED;

import java.util.Scanner;

public class Fila {
	
	private static class FILA{
		public int num;
		public FILA prox;
	}

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		//Apontadores de inicio e fim de fila. Armazenam endere�os de mem�ria
		FILA inicio = null;
		FILA fim = null;
		
		FILA aux;
		
		int op;
		
		do {
			
			System.out.println("\nMENU DE OPCOES\n");
            System.out.println("1 - Inserir na fila");          
            System.out.println("2 - Consultar toda a fila");
            System.out.println("3 - Remover da fila");
            System.out.println("4 - Esvaziar a fila");
            System.out.println("5 - sair");
            System.out.print("Digite sua op��o");
            
            op = entrada.nextInt();
            
            if(op < 1 || op > 5) System.out.println("Op��o Inv�lida!");
			
            if(op == 1) {
            	
            	//Cria��o e Inser��o na Fila
            	
            	//Criar Elemento da Fila
            	FILA novo = new FILA();
            	novo.num = entrada.nextInt();
            	novo.prox = null;
            	
            	if(inicio != null) {
            		fim.prox = novo;
            		fim = novo;            		
            	} else {
            		inicio = novo;
            		fim = novo;
            	}
            }
            
		}while(true);
	}
}
