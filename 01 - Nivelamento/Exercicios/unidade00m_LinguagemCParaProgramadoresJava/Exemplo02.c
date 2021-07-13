#include <stdio.h>

int main() {
    int x1, x2, x3;
    int *p;

    x1 = 11;
    x2 = 22; 
    x3 = 33;
    //x1 = 11
    //x2 = 22
    //x3 = 33
    p = &x1;
    //p aponta para x1, tendo valor igual a 11
    x2 = *p;
    //x2 recebe o valor de p, que e 11
    *p = x3;
    //o valor de p, que na verdade aponta para x1, guarda o valor 33
    p = &x3;
    //p aponta para x3, tendo valor igual a 33
    *p = 0;
    //o valor de p, que na verdade aponta para o x3, agora guarda o valor 0

    printf("Valor: x1[%d] | x2[%d] | x3[%d] | p[%d]\n\n", x1, x2, x3, *p);
    printf("ADDRS: x1[%p] | x2[%p] | x3[%p] | p[%p]\n", &x1, &x2, &x3, p);   
}