package ED;

import java.util.*;

public class CadastroCompras {
	
	//Criar estrutura de produtos
	//Classe Interna
	public static class Produto{
		public String nome;
		public int quantidade;
	}

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		//Variável do tipo produtos
		Produto p;
		
		//Criando uma lista encadeada de produtos
		LinkedList<Produto> lista = new LinkedList<Produto>();
		
		int op;
		
		do {
			System.out.println("\nMenu DE OPCOES\n");
			System.out.println("1 - Inserir Produto");
			System.out.println("2 - Consultar Lista");
			System.out.println("3 - Remover Elemento da Lista");
			System.out.println("4 - Sair");
			System.out.printf("Digite sua opção: ");
			
			op = Integer.parseInt(entrada.nextLine());
			
			//Opções
			if ( op == 1) {
				System.out.println("Inserindo Produto");
				p = new Produto();
				
				System.out.printf("Digite o nome do produto: ");
				p.nome = entrada.nextLine();
				
				System.out.printf("Digite a quantidade desse produto: ");
				p.quantidade = Integer.parseInt(entrada.nextLine());
				
				lista.add(p);
				
			} else if ( op == 2) {
				System.out.println("\nListanto Produtos");
				
				if(lista.isEmpty()) {
					
					System.out.println("Lista Vazia!");
					
				} else {
					
					for(Produto consulta : lista) {
						System.out.println("Produto: " + consulta.nome);
						System.out.println("Quantidade: " + consulta.quantidade);
					}
					
				}	
			}
			
			
		}while( op != 4);
		
	}

}
