package ED;

public class QuickSort {

	public static void main(String[] args) {
		

	}
	
	int particiona(int vetor[], int menor, int direita){ 
        int pivo = vetor[direita];  
        int i = (menor-1); // index of smaller element 
        for (int j = menor; j < direita; j++) 
        { 
            // If current element is smaller than or 
            // equal to pivot 
            if (vetor[j] <= pivo) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = vetor[i]; 
                vetor[i] = vetor[j]; 
                vetor[j] = temp; 
            } 
        } 
  
        int aux = vetor[i+1]; 
        vetor[i+1] = vetor[direita]; 
        vetor[direita] = aux; 
  
        return i+1; 
    } 

}
