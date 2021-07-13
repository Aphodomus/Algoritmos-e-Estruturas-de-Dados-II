#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    char palavra[400] = "";
    char invertida[400] = "";

    while (strcmp(palavra, "FIM") != 0) {
        gets(palavra);

        strcpy(invertida, palavra);

        strrev(invertida);

        if (strcmp(palavra, "FIM") != 0) {
            if (strcmp(palavra, invertida) == 0) {
                printf("SIM\n");
            } else {
                printf("NAO\n");
            }
        }
    }

    return 0;
}