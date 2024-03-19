#include <iostream>
using namespace std;

bool verPrimo(int num){
    
    int cont=0;
    
    for(int i =num;i>=1;i--){
        
        
        if(num%i==0){
            cont++;
        }
        
    }
    
    if(cont<=2){
        return 1;
    }
    else{
        return 0;
    }
    
}

int main()
{
    
    int num, resultado;
    
    cout<<"\n Digite um numero parar verificar se é primo: ";
    cin>>num;
    resultado = verPrimo(num);
    cout<<"\n"<<resultado<<"\n";
    
    
    

    return 0;
}
