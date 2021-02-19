/**
 * Seja a classe X abaixo e a Animal implementada e não mostrada, avalie as afirmações listadas a seguir
 */

public class unidade00i_exercicio10 {
    public static void main(String[] args) {
        Animal a = new Animal("Cao", 32, 'a');
        Animal b = new Animal("Cao", 'x');
        Animal c = b;
        c.setNome("Gato");
        MyIO.println(c.getNome());
        c.setIdade(45);
    }
}

/**
 *  I - Possivelmente, a Classe Animal tem três ou mais atributos. Além disso, no construtor com três parâmetros, o atributo que receb o valor do primeiro parâmetro pode ser do tipo String e os que recebem os outros dois podem ser do tipo int.
 * II - O comando System.out.println(b.nome) imprime a palavra "Gato".
 *III - A classe Animal deve ter um atributo idade e esse será obrigatoriamente privado.
 * IV - Na classe animal o atributo nome tem que ser estático.
 * 
 * É correto apenas o que se afirma em: 
 * A) I e II. 
 * B) II e III. 
 * C) III e IV. 
 * D) I, II e III.
 * 
 * Resposta: A
 * 
 */
