package ED;

import java.util.*;

public class Queue01 {

	public static void main(String[] args) {
		
		Queue<String> filaEspera = new LinkedList<>();
		
		filaEspera.add("Rodrigo");
		filaEspera.add("João");
		filaEspera.add("Adriana");
		
		System.out.println("Elementos da fila: " + filaEspera);
		
		System.out.println("Fila está vazia: " + filaEspera.isEmpty());

		System.out.println("Tamanho da fila: " + filaEspera.size());
	}

}
