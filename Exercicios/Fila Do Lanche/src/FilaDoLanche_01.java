import java.util.*;

public class FilaDoLanche_01 {
	
	public static class Lanche{
		int opcao;
		String nome;
		double preco;
		
		Lanche(int opcao, String nome, double preco){
			this.opcao = opcao;
			this.nome = nome;
			this.preco = preco;
		}
		
		public String mostrarLanche() {
			return this.nome + " - " + this.preco;
		}
	}
	
	public static class Pedido{
		Lanche lanche;
		String nomeDoCliente;
		Pedido prox;
	}

	public static void main(String[] args) {
		Lanche CQ = new Lanche(1, "Cachorro Quente", 6.00);
		Lanche BS = new Lanche(2, "Bauru Simples", 8.30);
		Lanche BCO = new Lanche(3, "Bauru c/ Ovo", 9.50);
		Lanche HB = new Lanche(4, "Hamburguer", 5.10);
		Lanche CB = new Lanche(5, "Cheeseburguer", 8.30);
		
		Scanner entrada = new Scanner(System.in);
		
		Pedido inicio = null;
		Pedido fim = null;
		
		Pedido aux;
		
		int op;
		
		do {
			System.out.println("Digite Uma Das Opções");
			System.out.println("1 - Fazer Pedido");
			System.out.println("2 - Entregar Pedido No Caixa");
			op = Integer.parseInt(entrada.nextLine());
			
			
			if ( op == 1 ) {
				Pedido pedido = new Pedido();
				pedido.prox = null;
				
				System.out.println("Digite seu nome:");				
				pedido.nomeDoCliente = entrada.nextLine();
				
				System.out.println("Digite seu lanhce");
				System.out.println("1 - Cachorro Quente");
				System.out.println("2 - Bauru Simples");
				System.out.println("3 - Bauru c/ Ovo");
				System.out.println("4 - Hamburguer");
				System.out.println("5 - Cheeseburguer");
				
				
				int opLanche = Integer.parseInt(entrada.nextLine());
				
				switch(opLanche) {
					case 1:
						pedido.lanche = CQ;
						System.out.println("Pedido Feito: " + pedido.lanche.mostrarLanche());
						break;
					case 2:
						pedido.lanche = BS;
						System.out.println("Pedido Feito: " + pedido.lanche.mostrarLanche());
						break;
					case 3:
						pedido.lanche = BCO;
						System.out.println("Pedido Feito: " + pedido.lanche.mostrarLanche());
						break;
					case 4:
						pedido.lanche = HB;
						System.out.println("Pedido Feito: " + pedido.lanche.mostrarLanche());
						break;
					case 5:
						pedido.lanche = CB;
						System.out.println("Pedido Feito: " + pedido.lanche.mostrarLanche());
						break;
					default:
						System.out.println("Numero inválido");
						break;
				}
				
				if ( inicio != null ) {
					fim.prox = pedido;
					fim = pedido;
				} else {
					inicio = pedido;
					fim = pedido;
				}
			}
			
			if( op == 2 ) {
				if(inicio == null) System.out.println("Fila Vazia");
            	else {
            		System.out.println(inicio.nomeDoCliente + " - " + inicio.lanche.mostrarLanche());
            		
            		inicio = inicio.prox;
            		System.out.println("Elemento Removido");
            	}
			}
			
			if(inicio == null) System.out.println("Fila Vazia");
        	else {
        		
        		aux = inicio;
        		while(aux != null) {
        			
        			System.out.println(aux.lanche.mostrarLanche() + " - " + aux.nomeDoCliente);
        			aux = aux.prox;
        		}
        	}
			
			
		} while (op != 3);
		
	}

}
