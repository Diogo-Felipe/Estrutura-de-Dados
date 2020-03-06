package ED;

import java.util.Scanner;

public class Biblioteca {
	
	private static class STACK{
		String nomeDoUsuario;
		String tituloDoLivro;
		String autor;
		int ano;

		public STACK prox;
	}

	public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        STACK topo = null;
        
        STACK aux;
            
        int opcao;
        
        do {
        	System.out.println("\nMENU DE OPCOES\n");
            System.out.println("1 - Devolver livro");         
            System.out.println("2 - Consultar todos os livros");
            System.out.println("3 - Remover livro");
            System.out.println("4 - sair");
            System.out.print("Digite sua opção");
            
            opcao = entrada.nextInt();
            
            if(opcao < 1 || opcao > 4) System.out.println("Opção inválida!");
            
            if( opcao == 1 ) {
            	STACK novoLivro = new STACK();
            	
            	System.out.print("Digite o nome: ");
            	novoLivro.nomeDoUsuario = entrada.next();
            	
            	System.out.print("Digite o título do livro: ");
            	novoLivro.tituloDoLivro = entrada.next();
            	
            	System.out.print("Digite o autor: ");
            	novoLivro.autor = entrada.next();
            	
            	System.out.print("Digite o ano do livro: ");
            	novoLivro.ano = entrada.nextInt();
            	
            	novoLivro.prox = topo;
            	topo = novoLivro;
            }
            
            if( opcao == 2 ) {
            	if(topo == null) System.out.println("Pilha vazia!");
            	else {
            		aux = topo;
            		while(aux != null) {
            			System.out.println("Usuario: " + aux.nomeDoUsuario);
            			System.out.println("Título: " + aux.tituloDoLivro);
            			System.out.println("Autor: " + aux.autor);
            			System.out.println("Ano: " + aux.ano);
            			
            			aux = aux.prox;
            		}
            	}
            }
            
            if( opcao == 3 ) {
            	if(topo == null) System.out.println("Pilha vazia!");
                else {
                	System.out.println("Usuario: " + topo.nomeDoUsuario);
        			System.out.println("Título: " + topo.tituloDoLivro);
        			System.out.println("Autor: " + topo.autor);
        			System.out.println("Ano: " + topo.ano);
        			
        			topo = topo.prox;
                }
            }
            
        } while(opcao != 4);

	}

}
