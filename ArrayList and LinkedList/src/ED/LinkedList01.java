package ED;

import java.util.*;

public class LinkedList01 {

	public static void main(String[] args) {
		
		//Criar o LinkedList
		LinkedList<String> ll = new LinkedList<String>();
		
		
		//Adicionar valores no LinkedList
		ll.add("Rodrigo");
		ll.add("Carlos");
		
		
		//Exibição do elemento usando ITERATOR
		Iterator<String> iterator = ll.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}

}
