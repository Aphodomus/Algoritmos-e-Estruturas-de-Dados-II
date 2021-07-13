#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

bool isUpperCase(char c) {
    if (c >= 'A' && c <= 'Z') {
        return true;
    }
    return false;
}

int main() {    
    char palavra[50] = "";
    int count = 0;

    while (strcmp(palavra, "FIM") != 0) {
        count = 0;
        gets(palavra);
        for (int i = 0; i < strlen(palavra); i = i + 1) {
            if (isUpperCase(palavra[i]) == true) {
                count = count + 1;
            }
        }

        if (strcmp(palavra, "FIM") != 0) {
            printf("%d\n", count);
        }
    }
    
    return 0;
}