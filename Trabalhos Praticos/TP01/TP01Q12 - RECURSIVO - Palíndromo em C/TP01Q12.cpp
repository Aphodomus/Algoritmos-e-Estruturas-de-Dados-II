#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <locale.h>

int length(char palavra[]) {
    int contador = 0;
    int i = 0;

    while (palavra[i] != '\0') {
        contador = contador + 1;
        i = i + 1;
    }
    
    return contador - 1;
}

bool isFim(char palavra[]) {
    if (palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M') {
        return true;
    }
    return false;
}

int iniciar(char palavra[], int tam, int i) {

    if (i < tam/2) {
        if (palavra[i] == palavra[tam - i - 1]) {
            return 1 * iniciar(palavra, tam, i + 1);
        } else {
            return 0;
        }
    } else {
        return 1;
    }
}

int main(void) {
    //setlocale(LC_ALL, "Portuguese_Brasil");
    //Declarando o tamanho das variáveis, coloquei 400 pois existem palavras bem grandes no pub.in
    char palavra[400] = "";
    int tam = 0;
    int i = 0;

    while (isFim(palavra) == 0) {
        fgets(palavra, 400, stdin);
        tam = strlen(palavra) - 1;

        if (isFim(palavra) == 0) {
            if (iniciar(palavra, tam, i) == 1) {
                printf("SIM\n");
            } else {
                printf("NAO\n");
            }
        }
    
    }

    return 0;
}