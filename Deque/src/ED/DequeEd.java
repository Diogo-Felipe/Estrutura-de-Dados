package ED;

import java.util.*;

public class DequeEd {

	public static void main(String[] args) {
		
		Deque<String> deque = new LinkedList<>();
		
		//ADI��O DE ELEMENTOS
		
		deque.add("Elemento 1 (calda)");
		deque.addFirst("Elemento 2 (Cabe�a)");
		deque.addLast("Elemento 3 (Calda");
		
		//Adicionar elementos com retorno de valida��o (Booleano)
		deque.offer("Elemento 5 (Calda)");
		deque.offerFirst("Elemento 6 (Cabe�a)");
		deque.offerLast("Elemento 7 (Calda)");
		

	}

}
