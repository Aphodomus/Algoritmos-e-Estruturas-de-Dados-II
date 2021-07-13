class Fila {
    private Celula primeiro;

    public Fila() {
        primeiro = new Celula();
    }

    public void inserir(int elemento) {
        Celula i;
        for (i = primeiro; i.prox != null; i = i.prox);

        i.prox = new Celula(elemento);
        i = null;
    } 

    public int remover() {
        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        int resp = primeiro.elemento;
        tmp.prox = null;
        tmp = null;
        return resp;
    }
}

public class unidade06c_pagina43 {
    public static void main(String[] args) {
        Fila fila = new Fila();

        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);

        fila.remover();
    } 
}
