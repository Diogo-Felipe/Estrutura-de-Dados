package ED;

public class QuickSort {

	public static void main(String[] args) {
		

	}
	
	void quickSort(int arr[], int comeco, int fim){ 
        if (comeco < fim){ 
            int pi = particiona(arr, comeco, fim); 
  
            quickSort(arr, comeco, pi-1); 
            quickSort(arr, pi+1, fim); 
        } 
    }
	
	int particiona(int vetor[], int comeco, int fim){ 
        int pivo = vetor[fim];  
        int i = (comeco-1);
        for (int j = comeco; j < fim; j++) 
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
        vetor[i+1] = vetor[fim]; 
        vetor[fim] = aux; 
  
        return i+1; 
    } 

}
