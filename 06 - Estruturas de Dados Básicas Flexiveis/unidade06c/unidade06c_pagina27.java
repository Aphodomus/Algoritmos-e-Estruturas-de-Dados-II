public class unidade06c_pagina27 {
    public static void main(String[] args) throws Exception {
        FilaFlex fila = new FilaFlex();

        fila.inserir(6);
        fila.inserir(3);
        fila.inserir(1);
        fila.inserir(8);
        fila.inserir(2);

        fila.mostrar();

        int terceiro = fila.mostrarTerceiro();

        System.out.println("\nTerceiro = " + terceiro);
    }
}
