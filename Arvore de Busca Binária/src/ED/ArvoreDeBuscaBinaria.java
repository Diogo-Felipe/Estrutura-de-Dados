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
		
		public int getValor() {
			System.out.println(valor);
			return valor;
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
			System.out.println("3 - Consulta de Pré-Ordem");
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
			
			if(opcao == 3) 
				buscaPreOrdem(raiz);
			
			if(opcao == 4)
				buscaPosOrdem(raiz);
			
			if(opcao == 5)
				buscaOrdem(raiz);

			
		}while(opcao != 9);
		
	}

	public static void buscaPreOrdem(NoArvore raiz) {
		NoArvore auxiliar = raiz;
		
		auxiliar.getValor();
		
		if(auxiliar.esquerda != null) {
			buscaPreOrdem(auxiliar.esquerda);
		} 
		
		if (auxiliar.direita != null) {
			buscaPreOrdem(auxiliar.direita);
		}
		
	}
	
	public static void buscaPosOrdem(NoArvore raiz) {
		NoArvore auxiliar = raiz;
				
		if(auxiliar.esquerda != null) {
			buscaPosOrdem(auxiliar.esquerda);
		} 
		
		if (auxiliar.direita != null) {
			buscaPosOrdem(auxiliar.direita);
		}
		
		auxiliar.getValor();
	}
	
	private static void buscaOrdem(NoArvore raiz) {
		NoArvore auxiliar = raiz;
		
		if(auxiliar.esquerda != null) {
			buscaPosOrdem(auxiliar.esquerda);
		} 
		
		auxiliar.getValor();
		
		if (auxiliar.direita != null) {
			buscaPosOrdem(auxiliar.direita);
		}
	
	}

}
