#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

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

bool verificar(char palavra[]) {
    bool resp = true;
    int j = length(palavra) - 1;

    for(int i = 0; i < ((length(palavra) - 1)/2); i++, j--) {
        if (palavra[i] != palavra[j]) {
            resp = false;
            i = length(palavra);
        }
    }

    return resp;
}

int main(void) {
    //Declarando o tamanho das variáveis, coloquei 400 pois existem palavras bem grandes no pub.in
    char palavra[400] = "";

    //Um loop que vai ser realizado enquanto a palavra por diferente de FIM
    while (isFim(palavra) == 0) {
        //Pega o valor digitado na linha
        fgets(palavra, 400, stdin);

        //Verifica novamente se a palavra e igual a FIM, se for ele não vai imprimir nada
        if (isFim(palavra) == 0) {
            //Faz o teste, verificando se a palavra invertida e igual a palavra  normal, se ela e um palindromo
            if (verificar(palavra) == true) {
                printf("SIM\n");
            } else {
                printf("NAO\n");
            }
        }
    }

    return 0;
}