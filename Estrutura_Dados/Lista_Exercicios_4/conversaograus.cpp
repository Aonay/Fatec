#include <iostream>
using namespace std;

float calcCel(float f){
    return (f-32)/1.8;
}

float calcFah(float c){
    return (c/5*9)+32;
}

int main()
{
    
    float celsius,fahrenheit;
    int valor;
    
    cout<< "Escolha 1 para converter para Celsius e 2 para Fahrenheit\n";
    cin>>valor;
    
    if(valor == 1){
        cout<<"\n Digite os graus em Fahrenheit: ";
        cin>>fahrenheit;
        celsius = calcCel(fahrenheit);
        cout<<"\n Graus Celsius: "<<celsius<<"\n";
    }
    else{
        cout<<"\n Digite o valor em Celsius: ";
        cin>>celsius;
        fahrenheit = calcFah(celsius);
        cout<<"\n Graus em Fahrenheit: "<<fahrenheit;
        
    }

    return 0;
}
