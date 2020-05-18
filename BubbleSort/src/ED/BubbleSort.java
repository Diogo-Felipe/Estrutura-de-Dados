package ED;

public class BubbleSort {

	public static void main(String[] args) {
		int vetor[] = {3,1,4,5,2};
		int aux = 0;
		

		
		for(int i = 0; i < vetor.length; i++) {
			for(int j = 0; j < vetor.length - 1; j++) {
				if(vetor[j] > vetor[j + 1]) {
					aux = vetor[j];
					vetor[j] = vetor[j + 1];
					vetor[j + 1] = aux;
				}
			}
		}
	}

}
