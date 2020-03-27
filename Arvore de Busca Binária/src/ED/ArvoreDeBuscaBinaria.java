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
			
			opcao = entrada.nextInt();
			
			
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
			
			
			
		}while(opcao != 9);
		
	}

}
