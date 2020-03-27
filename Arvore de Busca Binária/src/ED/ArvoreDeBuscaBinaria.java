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
				

				
				if(auxiliar != raiz) {
					NoArvore anterior = raiz;
					
					while(auxiliar != null && encontrado == false) {
						if(valor == auxiliar.valor) {
							encontrado = true;
						} else if(valor < auxiliar.valor) {
							auxiliar = auxiliar.esquerda;
						} else {
							auxiliar = auxiliar.direita;
						}
					}
					
					while(anterior.direita != auxiliar && anterior.esquerda != auxiliar) { 
						if(anterior.valor > valor)
							anterior = anterior.esquerda;
						else {
							anterior = anterior.direita;
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
						NoArvore auxiliar1;
						
						if(anterior.direita == auxiliar) {
							anterior.direita = auxiliar.direita;
							auxiliar1 = auxiliar.esquerda;
						} else {
							anterior.esquerda = auxiliar.esquerda;
							auxiliar1 = auxiliar.direita;
						}
						
						auxiliar = anterior;
						while(auxiliar != null) {
							if(auxiliar.valor < auxiliar1.valor) {
								if(auxiliar.direita == null) {
									auxiliar.direita = auxiliar1;
									auxiliar = null;
								} else {
									auxiliar = auxiliar.direita;
								}
								
							} else if (auxiliar.valor > auxiliar1.valor) {
								if(auxiliar.esquerda == null) {
									auxiliar.esquerda = auxiliar1;
									auxiliar = null;
								} else {
									auxiliar = auxiliar.esquerda;
								}		
							}
						}
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
							NoArvore auxiliar1;
							raiz = auxiliar.direita;
							auxiliar1 = auxiliar.esquerda;
							
							auxiliar = raiz;
							while(auxiliar != null) {
								if(auxiliar.valor < auxiliar1.valor) {
									if(auxiliar.direita == null) {
										auxiliar.direita = auxiliar1;
										auxiliar = null;
									} else {
										auxiliar = auxiliar.direita;
									}
									
								} else if (auxiliar.valor > auxiliar1.valor) {
									if(auxiliar.esquerda == null) {
										auxiliar.esquerda = auxiliar1;
										auxiliar = null;
									} else {
										auxiliar = auxiliar.esquerda;
									}		
								}
							}
						}
					}
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
