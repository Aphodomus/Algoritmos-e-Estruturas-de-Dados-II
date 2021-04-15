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
    Celula e1;

    Celula* e2 = (Celula*) malloc(3 * sizeof(Celula));
    e2->elemento = 7;

    Celula e3[3];
    Celula** e4 = (Celula**) malloc(3 * sizeof(Celula*));
    e4[0] = (Celula*) malloc(sizeof(Celula*));
    e4[1] = (Celula*) malloc(sizeof(Celula*));
    e4[2] = (Celula*) malloc(sizeof(Celula*));

    e4[0]->elemento = 13;
    e4[1]->elemento = 27;
    e4[2]->elemento = 43;

    printf("Elemento e2: %d | ADDRS: %p\n", e2->elemento, &e2);
    printf("Elemento e4[0]: %d | ADDRS: %p | Aponta para: %p\n", e4[0]->elemento, &e4[0], e4[0]);
    printf("Elemento e4[1]: %d | ADDRS: %p | Aponta para: %p\n", e4[1]->elemento, &e4[1], e4[1]);
    printf("Elemento e4[2]: %d | ADDRS: %p | Aponta para: %p\n", e4[2]->elemento, &e4[2], e4[2]);

    free(e2);
}