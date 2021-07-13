#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

typedef struct Celula Celula;
struct Celula {
    int elemento;
    struct Celula* prox;
};

Celula* novaCelula(int elemento) {
    Celula* nova = (Celula*) malloc(sizeof(Celula));

    nova->elemento = elemento; //Mesma coisa que nova.lemento = elemento (caso nao fosse um ponteiro)
    nova->prox = NULL;

    return nova;
}

int main() {
    Celula* tmp = novaCelula(3);

    printf("Elemento: %d", tmp->elemento);
}