#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define MAXTAM 3

int main() {
    double M [3][3];
    double *p = M[0];

    for (int i = 0; i < pow(MAXTAM, 2); i++, p++){
        *p = 0.0;
    }

    for (int i = 0; i < 3; i++, p++ ) {
        for (int j = 0; j < 3; j++) {
            printf("Valor M[%d][%d]: %lf | ADDRS M[%d][%d]: %p\n", i, j, M[i][j], i, j, &M[i][j]);
        }
    }

}