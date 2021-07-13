#include <stdio.h>

int main() {
    //Declarando variaveis
    int tamanho;
    int matriz[10][10];
    int soma[10];

    //Lendo tamanho
    scanf("%d", &tamanho);

    //Lendo valores
    for (int i = 0; i < tamanho; i = i + 1) {
        for (int j = 0; j < tamanho; j = j + 1) {
            scanf("%d", &matriz[i][j]);
        }   
    }

    //Somando valores
    for (int m = 0; m < tamanho; m = m + 1) {
        soma[m] = 0;
        for (int n = 0; n < tamanho; n = n + 1) {
            soma[m] = soma[m] + matriz[n][m];
        }
    }

    //Mostrar resultado
    for (int p = 0; p < tamanho; p = p + 1) {
        printf("%d ", soma[p]);
    }

    return 0;
}