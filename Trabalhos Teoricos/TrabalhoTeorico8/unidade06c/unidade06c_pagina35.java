public class unidade06c_pagina35 {
    public static void main(String[] args) throws Exception {
        FilaFlex fila = new FilaFlex();

        fila.inserir(6);
        fila.inserir(3);
        fila.inserir(1);
        fila.inserir(8);
        fila.inserir(2);
        fila.inserir(5);
        fila.inserir(10);

        int resposta = fila.contar();

        System.out.println("Resposta = " + resposta);
    }
}
