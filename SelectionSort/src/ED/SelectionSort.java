package ED;

public class SelectionSort {

	public static void main(String[] args) {
		int vetor[] = {3,1,4,5,2};
		int aux = 0;
		int menor;
		
		System.out.println("Vetor desordenado:");
		for(int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}
		
		
		for(int i = 0; i < vetor.length; i++) {
			menor = i;
			for(int j = i + 1; j < vetor.length; j++) {
				if(vetor[j] < vetor[menor]) {
					menor = j;
				}
			}
			aux = vetor[i];
			vetor[i] = vetor[menor];
			vetor[menor] = aux;
		}
		
		
		System.out.println("\nVetor Ordenado");
		for(int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}
	}

}
