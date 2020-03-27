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
			System.out.println("4 - Consulta de Pós-Ordem");
			System.out.println("5 - Consulta de Ordem");
			System.out.println("6 - Remover Elemento");
			System.out.println("7 - Esvaziar Arvore");
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
			
			
			if(opcao == 6) {
				System.out.println("Digite o valor: ");
				int valor = entrada.nextInt();
				
				NoArvore auxiliar = raiz;
				boolean encontrado = false;
				

				
				if(valor != raiz.valor) {
					NoArvore anterior = raiz;
					auxiliar = raiz;
					
					while(auxiliar != null && encontrado == false) {
						if(valor == auxiliar.valor) {
							encontrado = true;
						} else if(valor < auxiliar.valor) {
							anterior = auxiliar;
							auxiliar = auxiliar.esquerda;
						} else {
							anterior = auxiliar;
							auxiliar = auxiliar.direita;
						}
					}	
					
					
					if(auxiliar.esquerda == null && auxiliar.direita == null) {
						if(anterior.esquerda == auxiliar) 
							anterior.esquerda = null;
						else 
							anterior.direita = null;
						
					} else if (auxiliar.esquerda != null && auxiliar.direita == null) {
						if(anterior.esquerda == auxiliar) 
							anterior.esquerda = auxiliar.esquerda;
						else 
							anterior.direita = auxiliar.esquerda;
						
					} else if (auxiliar.esquerda == null && auxiliar.direita != null) {
						if(anterior.esquerda == auxiliar) 
							anterior.esquerda = auxiliar.direita;
						else 
							anterior.direita = auxiliar.direita;
						
					} else {
						NoArvore auxiliar1 = auxiliar.direita;
						NoArvore auxiliar2 = auxiliar.esquerda;
						NoArvore anteriorAtual = null;

						if(auxiliar == anterior.direita) {
							
							auxiliar = auxiliar.esquerda;
							while(auxiliar.direita != null) {
								anteriorAtual = auxiliar;
								auxiliar = auxiliar.direita;
							}
							anterior.direita = auxiliar;
							
						} else if(auxiliar == anterior.esquerda) {
							
							auxiliar = auxiliar.esquerda;
							while(auxiliar.direita != null) {	
								anteriorAtual = auxiliar;
								auxiliar = auxiliar.direita;
							}
							anterior.esquerda = auxiliar;
							
						}
						auxiliar.direita = auxiliar1;
						auxiliar.esquerda = auxiliar2;
						anteriorAtual.direita = null;
					}
					
				} else {
					if(auxiliar.direita == null && auxiliar.esquerda == null) {
						raiz = null;
					} else {
						if (auxiliar.esquerda != null && auxiliar.direita == null) 
							raiz = auxiliar.esquerda;
						else if (auxiliar.esquerda == null && auxiliar.direita != null)
							raiz = auxiliar.direita;
						else if (auxiliar.esquerda != null && auxiliar.direita != null) {
							NoArvore auxiliar1 = raiz.direita;
							NoArvore auxiliar2 = raiz.esquerda;
							NoArvore anteriorAtual = null;

								
							auxiliar = raiz.esquerda;
							while(auxiliar.direita != null) {	
								anteriorAtual = auxiliar;
								auxiliar = auxiliar.direita;
							}
							raiz = auxiliar;
								
							auxiliar.direita = auxiliar1;
							auxiliar.esquerda = auxiliar2;
							anteriorAtual.direita = null;
						}
					}
				}
			}
			
			if(opcao == 7) {
				if(raiz == null) {
					System.out.println("Arvore vazia");
				} else {
					raiz = null;
					System.out.println("Arvore Esvaziada");
				}
			}

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
