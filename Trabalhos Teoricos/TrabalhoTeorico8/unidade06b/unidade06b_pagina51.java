public class unidade06b_pagina51 {
    public static void main(String[] args) throws Exception {
        PilhaFlex pilha = new PilhaFlex();

        pilha.inserir(5);
        pilha.inserir(1);
        pilha.inserir(9);
        pilha.inserir(7);
        pilha.inserir(24);
        pilha.inserir(19);

        pilha.mostrar();

        int soma = pilha.somaRec();

        System.out.println("\nA soma de todos os elementos e = " + soma);
    }
}