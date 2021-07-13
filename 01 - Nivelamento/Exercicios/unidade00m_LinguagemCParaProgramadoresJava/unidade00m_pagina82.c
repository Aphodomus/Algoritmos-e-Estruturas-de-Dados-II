#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#define MAXTAM 3

int main() {
    int a[10], *b;
    b = a;

    b[5] = 100;
    for (int i = 0; i < 10; i++) {
        printf("\nValor a[%d]: %d | ADDRS: a[%d]: %p          Valor b[%d]: %d | ADDRS: b[%d]: %p", i, a[i], i, &a[i], i, b[i], i, &b[i]);
    }

    b = (int*) malloc(10*sizeof(int));
    b[7] = 100;
    
    printf("\n\nDepois de alocar\n");

    for (int i = 0; i < 10; i++) {
        printf("\nValor a[%d]: %d | ADDRS: a[%d]: %p          Valor b[%d]: %d | ADDRS: b[%d]: %p", i, a[i], i, &a[i], i, b[i], i, &b[i]);
    }
    //O comando a = b gera um erro de compilação

    free(b);
}