package ED;

import java.util.*;

public class Queue01 {

	public static void main(String[] args) {
		
		Queue<String> filaEspera = new LinkedList<>();
		
		filaEspera.add("Rodrigo");
		filaEspera.add("Jo�o");
		filaEspera.add("Adriana");
		
		//Exibe toda fila
		System.out.println("Elementos da fila: " + filaEspera);
		
		//Verifica se a fila est� vazia
		System.out.println("Fila est� vazia: " + filaEspera.isEmpty());

		//Verifica o tamanho da fila
		System.out.println("Tamanho da fila: " + filaEspera.size());
		
		//Verifica se existe algum elemento espec�fico na fila
		String nome = "Adriana";
		System.out.println("Contem o nome: " + filaEspera.contains(nome));
		
		//Pega o primeiro elemento da fila (O que est� em iminencia de rem��o)
		System.out.println("Nome: " + filaEspera.peek() + " � o primeiro");
		
		//Consome o elemento da fila (O primeiro)
		System.out.println("Removendo da fila " + filaEspera.poll());
	}

}
