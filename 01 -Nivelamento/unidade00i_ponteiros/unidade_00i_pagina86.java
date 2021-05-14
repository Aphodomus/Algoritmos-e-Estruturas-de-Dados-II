public class unidade_00i_pagina86 {
    public static void main(String[] args) {
        Animal a = new Animal("Cao", 32, 'a');
        Animal b = new Animal("Cao", 'x');
        Animal c = b;
        c.nome = "Gato";
        System.out.println(b.nome);
        System.out.println(a.getCaracter());
        c.setIdade(45);
    }
}

/**
 * 
 * I – Possivelmente, a Classe Animal tem três ou mais atributos. Além disso, no
 * construtor com três parâmetros, o atributo que recebe o valor do primeiro
 * parâmetro pode ser do tipo String e os que recebem os outros dois podem ser
 * do tipo int.
 * 
 * II - O comando System.out.println(b.nome) imprime a palavra
 * "Gato". 
 * 
 * III - A classe Animal deve ter um atributo idade e esse será
 * obrigatoriamente privado. 
 * 
 * IV - Na classe animal o atributo nome tem que ser
 * estático.
 * 
 * A) I e II.
 * 
 */