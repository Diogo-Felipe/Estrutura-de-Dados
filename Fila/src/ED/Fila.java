package ED;

import java.util.Scanner;

public class Fila {
	
	private static class FILA{
		public int num;
		public FILA prox;
	}

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		//Apontadores de inicio e fim de fila. Armazenam endereços de memória
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
            System.out.print("Digite sua opção");
			
		}while(true);
	}
}
