public class unidade06b_pagina53 {
    public static void main(String[] args) throws Exception {
        PilhaFlex pilha = new PilhaFlex();

        pilha.inserir(5);
        pilha.inserir(1);
        pilha.inserir(9);
        pilha.inserir(7);
        pilha.inserir(24);
        pilha.inserir(19);

        pilha.mostrar();

        int maior = pilha.maiorElementoRec();

        System.out.println("\nMaior elemento = " + maior);
    }
}
