package ED;

import java.util.*;

public class ArrayList01 {

	public static void main(String[] args) {
		
		//Criar o ArrayList
		List<Integer> al = new ArrayList();
		
		//Adicionar elementos ao ArrayList
		al.add(3);
		al.add(30);
		
		//Exibir elemento no ArrayList usando get
		System.out.println("Usando get - " + al.get(1));
	}

}
