public class unidade_00i_pagina84 {
    public static void main (String[] args){
        Hora h1 = new Hora(12, 30, 30);
        Hora h2 = new Hora(12, 30, 30);
        if (h1 == h2) {
            System.out.println("Identicos!");
            System.out.println("ADDRS h1: " + h1);
            System.out.println("ADDRS h2: " + h2);
        } else {
            System.out.println("Diferentes!");
            System.out.println("ADDRS h1: " + h1);
            System.out.println("ADDRS h2: " + h2);
        }
    }
}

//Porque o if/else esta verificando se o ENDERECO de h1 e h2 sao iguais, o que nao acontece !
