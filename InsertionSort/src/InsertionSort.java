
public class InsertionSort {

	public static void main(String[] args) {
		int vetor[] = {3,1,4,5,2};
		int aux = 0;
		
		System.out.println("Vetor desordenado:");
		for(int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}
				
		
		for(int i = 1; i < vetor.length; i++) {
			aux = vetor[i];
			int j = i - 1;
			
			while(j >= 0 && vetor[j] > aux) {
				vetor[j + 1] = vetor[j];
				j = j - 1;
			}
			
			vetor[j + 1] = aux;
		}
		
		
		System.out.println("\nVetor Ordenado");
		for(int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}

	}

}
