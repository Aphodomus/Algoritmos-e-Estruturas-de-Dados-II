#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#define MAXTAM 3

int main() {
    double a;
    double *p, *q;

    a = 3.14;
    printf("Valor: %f | ADDRS: %p\n", a, &a);
    //Vai atribuir 3.14 a variavel "a" e printar na tela

    p = &a;
    *p = 2.718;
    printf("Valor: %f | ADDRS: %p\n", a, &a);
    //Primeiro, o ponteiro p agora aponta para a, tendo inicialmente o VALOR igual a 3.14, mas depois o VALOR do ponteiro recebe 2.718,

    a = 5;
    printf("Valor: %f | ADDRS: %p | Aponta para: %p\n", *p, &p, p);
    //Vai atrbuir 5 a variavel "a" e printar na tela

    p = NULL;
    p = (double*) malloc(sizeof(double));
    *p = 20;
    q = p;
    printf("Valor: %f | ADDRS: %p | Aponta para: %p\n", *p, &p, p);
    printf("Valor: %f | ADDRS: %p\n", a, &a);
    //Primeiro, o endereco de p, que apontava para "a" agora e NULL, depois p aloca memoria, o VALOR de p recebe 20, e depois q recebe p
    
    printf("Valor: %f | ADDRS: %p | Aponta para: %p\n", *q, &q, q);
    free(p);
    printf("Valor: %f | ADDRS: %p | Aponta para: %p\n", *q, &q, q);
}