#include <stdio.h>
#include <stdlib.h>

int main() {
    int *x1; int x2; int *x3;
    x1 = (int *) malloc (sizeof(int));

    printf("\nx1[Aponta para: %p | Valor: %i | ADDRS: %p]\nx2[Valor: %i | ADDRS: %p]\nx3[Aponta para: %p | Valor: %i | ADDRS: %p]\n", x1, *x1, &x1, x2, &x2, x3, *x3, &x3);
    
    *x1 = 20;
    printf("\nx1[Aponta para: %p | Valor: %i | ADDRS: %p]\nx2[Valor: %i | ADDRS: %p]\nx3[Aponta para: %p | Valor: %i | ADDRS: %p]\n", x1, *x1, &x1, x2, &x2, x3, *x3, &x3);
    
    x2 = *x1;
    printf("\nx1[Aponta para: %p | Valor: %i | ADDRS: %p]\nx2[Valor: %i | ADDRS: %p]\nx3[Aponta para: %p | Valor: %i | ADDRS: %p]\n", x1, *x1, &x1, x2, &x2, x3, *x3, &x3);
    
    x3 = &x2;
    printf("\nx1[Aponta para: %p | Valor: %i | ADDRS: %p]\nx2[Valor: %i | ADDRS: %p]\nx3[Aponta para: %p | Valor: %i | ADDRS: %p]\n", x1, *x1, &x1, x2, &x2, x3, *x3, &x3);
    
    x2 = 15;
    printf("\nx1[Aponta para: %p | Valor: %i | ADDRS: %p]\nx2[Valor: %i | ADDRS: %p]\nx3[Aponta para: %p | Valor: %i | ADDRS: %p]\n", x1, *x1, &x1, x2, &x2, x3, *x3, &x3);
}