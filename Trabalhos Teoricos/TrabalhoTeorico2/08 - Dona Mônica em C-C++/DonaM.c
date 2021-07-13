#include <stdio.h>

int main() {
    int donaM = -1, filhoVelho = 0, filhoUm = 0, filhoDois = 0;
    while (donaM != 0) {
        scanf("%d", &donaM);
        scanf("%d", &filhoUm);
        scanf("%d", &filhoDois);

        filhoVelho = donaM - (filhoUm + filhoDois);
        if (donaM != 0) {
            printf("%d\n", filhoVelho);
        }
    }

    return 0;
}