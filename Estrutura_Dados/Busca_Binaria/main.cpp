#include <iostream> 
#include <vector> //propriedades do vetor
#include <algorithm> 
#include <stdlib.h> //funcao random

using namespace std; 

// Método de ordenação (Bubble Sort) 

void ordenarVetor(vector<int> &vetor) { 

    int n = vetor.size(); 
    for (int i = 0; i < n-1; i++) { 
        for (int j = 0; j < n-i-1; j++) { 
            if (vetor[j] > vetor[j+1]) { 
                swap(vetor[j], vetor[j+1]); 

            } 
        } 
    } 
} 

  

// Método da busca binária 

int buscaBinaria(const vector<int> & vetor, int valor) { 

    int esquerda = 0; 
    int direita = vetor.size() - 1; 
    while (esquerda <= direita) { 

        int meio = esquerda + (direita - esquerda) / 2; 

        if (vetor[meio] == valor) { 
            return meio; // valor encontrado, retorna o índice 
        } 

        if (vetor[meio] < valor) { 
            esquerda = meio + 1; // descarta metade esquerda 

        } else { 
            direita = meio - 1; // descarta metade direita 
        } 
        
    } 

    return -1; // valor não encontrado 

} 

  

int main() { 
	
	//Populando vetor com Random (25 indices com numeros de 0 a 100)
    int vet[25];
		for(int i = 0; i < 25; i++){
        vet[i] =  (rand() % 100);
    }
	  
	vector<int> arr(vet, vet+25); //setamos o vetor 'arr' com o primeiro indice vet[0] e o último vet[24] (posicao 0 + 25 iterações = posicao 24)

	  
	//Imprime vetor desordenado
    cout << "Vetor desordenado: "<<endl; 

    for (int num : arr) { 
        cout << num << " "; 
    } 
    cout << endl<<endl; 	


    // Imprime vetor ordenado 
    ordenarVetor(arr); 
    cout << "Vetor ordenado: "<<endl; 

    for (int num : arr) { 
        cout << num << " "; 
    } 
    cout << endl<<endl; 


    // Realizando a busca binária  
    int valorBusca; 
    cout<<"Qual numero deseja buscar no vetor: ";
	cin>>valorBusca;
    

    int indice = buscaBinaria(arr, valorBusca); 
    if (indice != -1) { 
        cout << "O valor " << valorBusca << " foi encontrado no indice " << indice << endl;
		 
    } else { 
		cout << buscaBinaria(arr, valorBusca)<<endl;
        cout << "O valor " << valorBusca << " nao foi encontrado no vetor." << endl; 
    } 
    
    return 0; 

} 
