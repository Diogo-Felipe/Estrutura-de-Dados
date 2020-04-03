package ED;

import java.util.Scanner;

public class ArvoreAVL {
	
	private static class NoArvore{
		public int valor;
		public int alturaSAD;
		public int alturaSAE;
		public NoArvore direita, esquerda;
	}

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		NoArvore raiz = null;
		
		int opcao;
		
		do {
			
			System.out.println("\nMENU DE OPCOES\n");
			System.out.println("1 - Inserir na arvore");
			System.out.println("2 - Consultar o no da arvore");
			System.out.println("4 - Consultar toda a arvore - pre-ordem");
			System.out.println("3 - Consultar toda a arvore - ordem");
			System.out.println("5 - Consultar toda a arvore - pos-ordem");
			System.out.println("6 - excluir um no da arvore");
			System.out.println("7 - Esvaziar a lista");
			System.out.println("8 - sair");
			System.out.print("Digite sua opcao");
			
			opcao = entrada.nextInt();
			
			if(opcao < 1 || opcao > 8) System.out.println("Opcao invalida");
			
			if(opcao == 1) {		
				System.out.println("Digite o número a ser inserido na árvore: ");
				int valor = entrada.nextInt();
				
				raiz = inserir(raiz, valor);
				
				System.out.println("Numero inserido na árvore");
				
			} else if (opcao == 2){
				if(raiz == null) System.out.println("Arvore vazia");
				else {
					System.out.println("Digite o número procurado: ");
					int valor = entrada.nextInt();
					boolean achou = false;
					
					achou = consulta(raiz, valor, achou);
				}
				
			} else if(opcao == 3) {
				if(raiz == null)System.out.println("Arvore vazia ");
				else{

					System.out.println("Listando todos os elementos da arvore EM PRE-ORDEM");
					mostrarEmPreOrdem(raiz);			
				}
				
			} else if(opcao == 4){

				if(raiz == null)System.out.println("Arvore vazia ");
				else{

					System.out.println("Listando todos os elementos da arvore EM ORDEM");
					mostrarEmOrdem(raiz);				
				}				

			}
			
		} while(opcao != 8);

	}
	
	public static NoArvore inserir(NoArvore auxiliar, int valor) {
		
		if(auxiliar == null) {
			NoArvore novo = new NoArvore();
			novo.valor = valor;
			novo.alturaSAD = 0;
			novo.alturaSAE = 0;
			novo.direita = null;
			novo.esquerda = null;
			auxiliar = novo;
			
		} else if (valor < auxiliar.valor) {
			
			auxiliar.esquerda = inserir(auxiliar.esquerda, valor);
			
			if(auxiliar.esquerda.alturaSAD > auxiliar.esquerda.alturaSAE)
				auxiliar.alturaSAE = auxiliar.esquerda.alturaSAD + 1;
			else
				auxiliar.alturaSAE = auxiliar.esquerda.alturaSAE + 1; 
				
			
		} else {
			
			auxiliar.direita = inserir(auxiliar.direita, valor);
			
			if(auxiliar.direita.alturaSAD > auxiliar.direita.alturaSAE)
				auxiliar.alturaSAD = auxiliar.direita.alturaSAD + 1;
			else
				auxiliar.alturaSAD = auxiliar.direita.alturaSAE + 1;
			
			
		}
		
		return auxiliar;
	}
	
	public static NoArvore balanceamento(NoArvore auxiliar) {
		
		int fatorDeBalanceamento, fatorDeBalanceamentoDoFilho;
		
		fatorDeBalanceamento = auxiliar.alturaSAD = auxiliar.alturaSAE;
		
		if(fatorDeBalanceamento == 2) {
			
			fatorDeBalanceamentoDoFilho = auxiliar.direita.alturaSAD - auxiliar.direita.alturaSAE;
			
			if(fatorDeBalanceamentoDoFilho >= 0) {
				auxiliar = rotacaoEsquerda(auxiliar);
			} else {
				auxiliar.direita = rotacaoDireita(auxiliar.direita);
				auxiliar = rotacaoEsquerda(auxiliar);
			}
				
		} else if (fatorDeBalanceamento == -2) {
			
			fatorDeBalanceamentoDoFilho = auxiliar.esquerda.alturaSAD - auxiliar.esquerda.alturaSAE;
			
			if(fatorDeBalanceamentoDoFilho <= 0) {
				auxiliar = rotacaoDireita(auxiliar);
			} else {
				auxiliar.esquerda = rotacaoEsquerda(auxiliar.esquerda);
				auxiliar = rotacaoDireita(auxiliar);
			}
		}
		
		return auxiliar;
	}
	
	public static NoArvore rotacaoEsquerda(NoArvore auxiliar) {
		
		NoArvore auxiliar1, auxiliar2;
		
		auxiliar1 = auxiliar.direita;
		auxiliar2 = auxiliar1.esquerda;
		
		auxiliar.direita = auxiliar2;
		auxiliar1.esquerda = auxiliar;
		
		if(auxiliar.direita == null) {
			auxiliar.alturaSAD = 0;
		} else if(auxiliar.direita.alturaSAE > auxiliar.direita.alturaSAD) {
			auxiliar.alturaSAD = auxiliar.direita.alturaSAE + 1;
		} else {
			auxiliar.alturaSAD = auxiliar.direita.alturaSAD + 1;
		}
		
		if(auxiliar1.esquerda.alturaSAE > auxiliar1.esquerda.alturaSAD) {
			auxiliar1.alturaSAE = auxiliar1.esquerda.alturaSAE + 1;
		} else {
			auxiliar1.alturaSAE = auxiliar1.esquerda.alturaSAD + 1;
		}
		
		return auxiliar1;
	}
	
	public static NoArvore rotacaoDireita(NoArvore auxiliar){
		
		NoArvore auxiliar1, auxiliar2;
		
		auxiliar1 = auxiliar.esquerda;
		auxiliar2 = auxiliar1.direita;
		
		auxiliar.esquerda = auxiliar2;
		auxiliar.direita = auxiliar;
		
		if(auxiliar.esquerda == null) {
			auxiliar.alturaSAE = 0;
		} else if(auxiliar.esquerda.alturaSAE > auxiliar.esquerda.alturaSAD) {
			auxiliar.alturaSAE = auxiliar.esquerda.alturaSAE + 1;
		} else {
			auxiliar.alturaSAE = auxiliar.esquerda.alturaSAD + 1;
		}
		
		if(auxiliar1.direita.alturaSAE > auxiliar.direita.alturaSAE) {
			auxiliar1.alturaSAD = auxiliar.direita.alturaSAE + 1;
		} else {
			auxiliar1.alturaSAD = auxiliar.direita.alturaSAD + 1;
		}
		
		return auxiliar1;
	}
	
	public static boolean consulta(NoArvore auxiliar, int valor, boolean achou) {
		
		if(auxiliar != null && !achou) {
			if(auxiliar.valor == valor) {
				achou = true;
			} else if(auxiliar.valor > valor) {
				achou = consulta(auxiliar.esquerda, valor, achou);
			} else {
				achou = consulta(auxiliar.direita, valor, achou);
			}
		}
		
		return achou;
	}
	
	public static void mostrarEmPreOrdem(NoArvore auxiliar) {
		
		System.out.print(auxiliar.valor + " ");
		mostrarEmPreOrdem(auxiliar.esquerda);
		mostrarEmPreOrdem(auxiliar.direita);
		
	}
	
	public static void mostrarEmOrdem(NoArvore auxiliar) {
		
		mostrarEmOrdem(auxiliar.esquerda);
		System.out.print(auxiliar.valor + " ");
		mostrarEmOrdem(auxiliar.direita);
		
	}

}
