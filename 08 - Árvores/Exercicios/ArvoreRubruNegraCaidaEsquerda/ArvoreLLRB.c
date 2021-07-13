#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "ArvoreLLRB.h"
#define RED 1
#define BLACK 0

// Estruturas
struct No {
    int elemento;
    struct No *esq;
    struct No *dir;
    int cor;
};

struct No* rotacaoEsquerda(struct No* A) {
    struct No* B = A->dir;
    A->dir = B->esq;
    B->esq = A;
    B->cor = A->cor;
    A->cor = RED;

    return B;
};

struct No* rotacaoDireita(struct No* A) {
    struct No* B = A->esq;
    A->esq = B->dir;
    B->dir = A;
    B->cor = A->cor;
    A->cor = RED;

    return B;
};

// Metodos e funcoes
int cor(struct No* no) {
    if (no == NULL) {
        return BLACK;
    } else {
        return no->cor;
    }
}

void trocarCor(struct No* no) {
    no->cor = !no->cor;

    if (no->esq != NULL) {
        no->esq->cor = !no->esq->cor;
    }

    if (no->dir != NULL) {
        no->dir->cor = !no->dir->cor;
    }
}

struct No* inserirRec(struct No* no, int elemento, int *resp) {
    if (no == NULL) {
        struct No *novo;
        novo = (struct No*)malloc(sizeof(struct No));

        // Verifica se a alocacao deu certo
        if (novo == NULL) {
            *resp = 0;
            return NULL;
        }

        // Inserir
        novo->elemento = elemento;
        novo->cor = RED;
        novo->dir = NULL;
        novo->esq = NULL;
        *resp = 1;

        return novo;
    } else if (no->elemento == elemento) {
        *resp = 0;
    } else if (elemento < no->elemento) {
        no->esq = inserirRec(no->esq, elemento, resp);
    } else if (elemento > no->elemento) {
        no->dir = inserirRec(no->dir, elemento, resp);
    } else {
        printf("\nErro ao tentar inserir\n");
    }

    if (cor(no->dir) == RED && cor(no->esq) == BLACK) {
        no = rotacaoEsquerda(no);
    }

    if (cor(no->esq) == RED && cor(no->esq->esq) == RED) {
        no = rotacaoDireita(no);
    }

    if (cor(no->esq) == RED && cor(no->dir) == RED) {
        trocarCor(no);
    }

    return no;
}

int inserir(ArvoreLLRB *raiz, int elemento) {
    int resp;

    *raiz = inserirRec(*raiz, elemento, &resp);

    if (*raiz != NULL) {
        (*raiz)->cor = BLACK;
    }

    return resp;
}

bool consultaRec(struct No* no, int elemento) {
    bool resp = false;

    if (no == NULL) {
        resp = false;
    } else if (elemento == no->elemento) {
        resp = true;
    } else if (elemento < no->elemento) {
        resp = consultaRec(no->esq, elemento);
    } else {
        resp = consultaRec(no->dir, elemento);
    }

    return resp;
}

bool consulta(ArvoreLLRB *raiz, int elemento) {
    return consultaRec(*raiz, elemento);
}

struct No* move2EsqRED(struct No* no) {
    trocarCor(no);

    if (cor(no->dir->esq) == RED) {
        no->dir = rotacaoDireita(no->dir);
        no = rotacaoEsquerda(no);
        trocarCor(no);
    }

    return no;
}

struct No* balancear(struct No* no) {
    if (cor(no->dir) == RED) {
        no = rotacaoEsquerda(no);
    }

    if (no->esq != NULL && cor(no->dir) == RED && cor(no->esq->esq) == RED) {
        no = rotacaoDireita(no);
    }

    if (cor(no->esq) == RED && cor(no->dir) == RED) {
        trocarCor(no);
    }

    return no;
}

struct No* removerMenor(struct No* no) {
    if (no->esq == NULL) {
        free(no);
        return NULL;
    }

    if (cor(no->esq) == BLACK && cor(no->esq->esq) == BLACK) {
        no = move2EsqRED(no);
    }

    no->esq = removerMenor(no->esq);

    return balancear(no);
}

struct No* procurarMenor(struct No* atual) {
    struct No *no1 = atual;
    struct No *no2 = atual;

    while (no2 != NULL) {
        no1 = no2;
        no2 = no2->esq;
    }

    return no1;
}

struct No* removerRec(struct No* no, int elemento) {
    if (elemento < no->elemento) {
        if (cor(no->esq) == BLACK && cor(no->esq->esq) == BLACK) {
            no = move2EsqRED(no);
        }

        no->esq = removerRec(no->esq, elemento);
    } else {
        if (cor(no->esq) == RED) {
            no = rotacaoDireita(no);
        }

        if (elemento == no->elemento && (no->dir == NULL)) {
            free(no);
            return NULL;
        }

        if (cor(no->dir) == BLACK && cor(no->dir->esq) == BLACK) {
            no = move2EsqRED(no);
        }

        if (elemento == no->elemento) {
            struct No* x = procurarMenor(no->dir);
            no->elemento = x->elemento;
            no->dir = removerMenor(no->dir);
        } else {
            no->dir = removerRec(no->dir, elemento);
        }
    }

    return balancear(no);
}

int remover(ArvoreLLRB *raiz, int elemento) {
    if (consulta(raiz, elemento)) {
        struct No* no = *raiz;
        *raiz = removerRec(no, elemento);

        if (*raiz != NULL) {
            (*raiz)->cor = BLACK;
        }

        return 1;
    } else {
        return 0;
    }
}

// Principal
int main(){
    ArvoreLLRB *raiz;

    int elemento = 9;

    int resp = inserir(raiz, elemento);

    printf("Inseriu ? %d\n", resp);

    int x = remover(raiz, elemento);

    printf("Removeu ? %d\n", x);

    return 0;
}