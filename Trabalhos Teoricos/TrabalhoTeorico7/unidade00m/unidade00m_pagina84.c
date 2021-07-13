#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

typedef struct Cliente Cliente;
struct Cliente {
    int codigo;
    char nome[120];
};

int main() {
    Cliente c;
    c.codigo = 5;

    printf("Valor de c: %d | ADDRS de c: %p\n", c.codigo, &c);

    Cliente *p = NULL;
    p = (Cliente*) malloc (sizeof(Cliente));
    p->codigo = 6;

    printf("Valor de p: %d | ADDRS de p: %p | p Aponta para: %p\n", p->codigo, &p, p);

    Cliente *p2 = &c;
    p2->codigo = 7;

    printf("Valor de p2: %d | ADDRS de p2: %p | p2 Aponta para: %p\n", p2->codigo, &p2, p2);
    printf("Valor de c: %d | ADDRS de c: %p\n", c.codigo, &c);

    free(p);
}