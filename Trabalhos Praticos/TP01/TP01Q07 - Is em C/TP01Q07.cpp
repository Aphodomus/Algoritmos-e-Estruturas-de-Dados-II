#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<string.h>

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

char toUpper(char c) {
    return (c >= 'a' && c <= 'z') ? ((char) (c - 32)) : c;
}

bool isNumber(char c) {
    if ((c >= '0' && c <= '9') || (c == '.' || c == ',')) {
        return true;
    }

    return false;
}

bool apenasVogais(char palavra[]) {
    char aux = '-';
    int tamanho = length(palavra);

    for (int i = 0; i < tamanho; i = i + 1) {
        aux = palavra[i];
        aux = toUpper(aux);
        if (aux != 'A' && aux != 'E' && aux != 'I' && aux != 'O' && aux != 'U') {
            return false;
        }
    }
    return true;
}

bool apenasConsoantes(char palavra[]) {
    char aux = '-';
    int tamanho = length(palavra);
    
    for (int i = 0; i < tamanho; i = i + 1) {
        aux = palavra[i];
        aux = toUpper(aux);
        if (aux != 'B' && aux != 'C' && aux != 'D' && aux != 'F' && aux != 'G'&& aux != 'J' && aux != 'K' && aux != 'L' && aux != 'M' && aux != 'N' && aux != 'P' && aux != 'Q' && aux != 'R' && aux != 'S' && aux != 'T'&& aux != 'V' && aux != 'W' && aux != 'X' && aux != 'Z') {
            return false;
        }
    }
    return true;
}

bool apenasInteiros(char palavra[]) {
    char aux = '-';
    int tamanho = length(palavra);

    for (int i = 0; i < tamanho; i = i + 1) {
        aux = palavra[i];
        if (isNumber(aux)) {
            if (aux == '.' || aux == ',') {
                return false;
            }
        } else {
            return false;
        }
    }

    return true;
}

bool apenasReais(char palavra[]) {
    char aux = '-';
    int count = 0;
    int tamanho = length(palavra);

    for (int i = 0; i < tamanho; i = i + 1) {
        aux = palavra[i];
        if (isNumber(aux)) {
            if (aux == '.' || aux == ',') {
                count = count + 1;
            }
        } else {
            return false;
        }
    }
    
    if (count == 1 || count == 0) {
        return true;
    } else {
        return false;
    }
}

void verificar(char palavra[]) {
    if (apenasVogais(palavra)) {
        printf("SIM ");
    } else {
        printf("NAO ");
    }

    if (apenasConsoantes(palavra)) {
        printf("SIM ");
    } else {
        printf("NAO ");
    }

    if (apenasInteiros(palavra)) {
        printf("SIM ");
    } else {
        printf("NAO ");
    }

    if (apenasReais(palavra)) {
        printf("SIM ");
    } else {
        printf("NAO ");
    }
}

int main(void) {
    char entrada[1000] = "";
    
    while(isFim(entrada) == false) {
        fgets(entrada, 1000, stdin);
        if(isFim(entrada) == false) {
            verificar(entrada);
            printf("\n");
        }
    }

    return 0;
}