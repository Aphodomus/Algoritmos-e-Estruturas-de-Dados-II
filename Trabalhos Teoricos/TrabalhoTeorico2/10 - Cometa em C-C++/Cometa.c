#include <stdio.h>

int main() {
    int year, quantidadeDeVezes;

    while (year != 0) {
        scanf("%d", &year);

        quantidadeDeVezes = (int) (year - 10) / 76;
        quantidadeDeVezes = quantidadeDeVezes + 1;

        if (year != 0) {
            printf("%d\n", quantidadeDeVezes * 76 + 10);
        }
    }

    return 0;
}