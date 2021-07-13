#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#define MAXTAM 3

int main() {
    int *x1;
    int x2; 
    int *x3;
    x1 = (int*) malloc(sizeof(int));
    //Aloca espaco na memoria para x1, inicialmente apontando para qualquer endereco de memoria

    *x1 = 20;
    //O VALOR de x1 recebe 20

    x2 = *x1;
    //x2, que e uma variavel, recebe o VALOR do ponteiro x1, que e 29

    x3 = &x2;
    //x3 aponta para x2

    x2 = 15;
    //x2, que e uma variavel, recebe o valor 15

    x2 = 13 & 3;
    printf("Valor x2: %d | ADDRS x2: %p\n", x2, &x2);
    x2 = 13 | 3;
    printf("Valor x2: %d | ADDRS x2: %p\n", x2, &x2);
    x2 = 13 >> 1;
    printf("Valor x2: %d | ADDRS x2: %p\n", x2, &x2);
    x2 = 13 << 1;

    printf("Valor x1: %d | ADDRS x1: %p | x1 Aponta para: %p\n", *x1, &x1, x1);
    printf("Valor x2: %d | ADDRS x2: %p\n", x2, &x2);
    printf("Valor x3: %d | ADDRS x3: %p | x3 Aponta para: %p\n", *x3, &x3, x3);

    free(x1);
}