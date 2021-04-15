#include <stdio.h>

int main() {
    int x = 10;
    int* y = & x;

    printf("\nValor: %i", x);
    printf("\nADDRS: %p", &x);
    printf("\nADDRS: %p", y);
    printf("\nADDRS: %p", &y);
    printf("\nValor: %i", *y);    
}