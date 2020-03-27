package ED;

import java.util.Scanner;

public class ArvoreDeBuscaBinaria {
	
	public static class NoArvore {
		
		public int valor;
		public NoArvore esquerda;
		public NoArvore direita;
		
		public NoArvore(int valor, NoArvore esquerda, NoArvore direita) {
			
			this.valor = valor;
			this.esquerda = esquerda;
			this.direita = direita;
			
		}
		
	}

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		NoArvore raiz = null;
		
		int opcao;
		
		do {
			System.out.println("Digite uma opção:");
			System.out.println("1 - Inserir Elemtno");
			System.out.println("2 - Consulta de Elemento");
			System.out.println("9 - Sair");
			
			opcao = entrada.nextInt();
			
			//Inserção
			if (opcao == 1) {
				System.out.println("Digite o valor: ");
				int valor = entrada.nextInt();
				
				NoArvore novoNo = new NoArvore(valor, null, null);
				
				if(raiz == null) {					
					raiz = novoNo; 
					
				} else {
					NoArvore auxiliar = raiz;
					boolean encontrado = false;
					
					while(!encontrado) {
						
						if(novoNo.valor < auxiliar.valor) {
							
							if(auxiliar.esquerda == null) {
								
								auxiliar.esquerda = novoNo;
								encontrado = true;
								
							} else {
								
								auxiliar = auxiliar.esquerda;
							}
							
						} else {
							
							if(auxiliar.direita == null) {
								
								auxiliar.direita = novoNo;
								encontrado = true;
								
							} else {
								
								auxiliar = auxiliar.direita;
								
							}
							
						}
						
					}
					
				}
								
			}
			
			//Consulta de Elemento
			if(opcao == 2) {
				System.out.println("Digite o valor: ");
				int valor = entrada.nextInt();
				
				NoArvore auxiliar = raiz;
				boolean encontrado = false;
				
				while(auxiliar != null && encontrado == false) {
					if(valor == auxiliar.valor) {
						encontrado = true;
					} else if(valor < auxiliar.valor) {
						auxiliar = auxiliar.esquerda;
					} else {
						auxiliar = auxiliar.direita;
					}
				}
				
				if(encontrado) {
					System.out.println("Elemento encontrado");
				} else {
					System.out.println("Elemento não presente");
				}
				
			}
			
		}while(opcao != 9);
		
	}

}
