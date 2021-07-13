//Questão de prova

public class unidade06c_pagina38 {
    public static void main(String[] args) throws Exception {
        PilhaFlex pilha = new PilhaFlex();

        pilha.inserir(5);
        pilha.inserir(10);
        pilha.inserir(15);
        pilha.inserir(20);
        pilha.inserir(25);

        FilaFlex fila = new FilaFlex(pilha.toFila(pilha.topo));

        System.out.print("Pilha = ");
        pilha.mostrar();
        System.out.print("\nFila = ");
        fila.mostrar();
    }
}
