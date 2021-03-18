#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<string.h>

void lerValoresAndSalvaArquivo(int len) {
    FILE* arquivo = fopen("dadosC.txt", "wb");
    double value = 0.0;

    for (int i = 0; i < len; i++) {
        scanf("%lf", &value);
        fwrite(&value, sizeof(value), 1, arquivo);
    }

    fclose(arquivo);
}

void lerARquivoSalvo(int len) {
    FILE* arquivo = fopen("dadosC.txt", "rb");
    double value = 0.0;
    int inteiro = 0;
    int i = 0;
    int x = 0;

    fseek(arquivo, -8, SEEK_END);
    while (i < len) {
        x = x + 8;
        fseek(arquivo, -x, SEEK_END);
        fread(&value, sizeof(double), 1, arquivo);
        if (value == (int) value) {
            printf("%d\n", (int) value);
        } else {
            printf("%.6g\n", value);
        }
        len--;
    }

    fclose(arquivo);
}

int main() {
    int quantidade = 0;
    scanf("%d", &quantidade);

    lerValoresAndSalvaArquivo(quantidade);
    lerARquivoSalvo(quantidade);

    return 0;
}