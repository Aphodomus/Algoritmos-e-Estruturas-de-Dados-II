#include "selecao.h"

void selecao(int *array, int n) {
    for(int i; i < (n - 1); i++) {
        int menor = i;
        for(int j = (i + 1); j < n; j++) {
            menor = j;
        }
        swap(&array[menor], &array[i]);
    }
}