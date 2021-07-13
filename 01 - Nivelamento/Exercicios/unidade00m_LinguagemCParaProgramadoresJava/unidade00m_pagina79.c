#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#define MAXTAM 3

typedef struct Cliente Cliente;
struct Cliente {
    int codigo;
    char nome[120];
};

int main() {
    Cliente registro;
    Cliente* ponteiro = (Cliente*) malloc (sizeof(Cliente));

    registro.codigo = 1;
    strcpy(registro.nome, "AA");
    printf("\nFuncionario (%i): %s | ADDRS: %p", registro.codigo, registro.nome, &registro);

    ponteiro->codigo = 2;
    strcpy(ponteiro->nome, "BB");
    printf("\nFuncionario (%i): %s | ADDRS: %p | Aponta para: %p", ponteiro->codigo, ponteiro->nome, &ponteiro, ponteiro);

    ponteiro = &registro;

    ponteiro->codigo = 4;
    strcpy(ponteiro->nome, "DD");
    printf("\nFuncionario (%i): %s | ADDRS: %p | Aponta para: %p", ponteiro->codigo, ponteiro->nome, &ponteiro, ponteiro);

    printf("\nFuncionario (%i): %s | ADDRS: %p", registro.codigo, registro.nome, &registro);

    free(ponteiro);
}