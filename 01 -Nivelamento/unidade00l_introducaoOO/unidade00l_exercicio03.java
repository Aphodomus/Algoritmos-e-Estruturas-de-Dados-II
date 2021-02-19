/* Um aluno desenvolveu a classe abaixo e pediu sua ajuda para compilá-la. Para ajudar, você deve criar uma
classe Ponto com as seguintes regras:

    • Quatro atributos privados: double x, double y, int id e int nextID
•   Os atributos id e nextID serão alterados somente por um método construtor.
•   Implemente os métodos get e set tanto para o atributo x como para o y
•   Na declaração do atributo nextID, o mesmo deve receber zero. Além disso, a alteração do valor desse
atributo por um objeto sempre será compartilhada com qualquer objeto da classe ponto
•   Implemente dois construtores sendo que o primeiro não recebe parâmetros e inicializa os valores de x e
y com zero. O segundo recebe dois parâmetros (cujos nomes são obrigatoriamente x e y) e devem ser
utilizados para inicializar os valores dos atributos x e y, respectivamente
•   Os dois construtores devem atribuir o valor corrente do atributo nextID ao atributo id e incrementar o
valor de nextID. Observe que cada objeto terá um ID distinto
•   Implemente qualquer método que seja necessário para compilar a classe LixaoPonto

*/
public class unidade00l_exercicio03 {
    public static void main(String[] args) {
        Ponto p1 = new Ponto(4, 3);
        Ponto p2 = new Ponto(8, 5);
        Ponto p3 = new Ponto(9.3, 10);

        MyIO.println("Distancia entre p1 e p2: " + p1.dist(p2));
        MyIO.println("Distancia entre p1 e (5, 2): " + p1.dist(5, 2));
        MyIO.println("Distancia entre (4, 3) e (5, 2): " + Ponto.dist(4, 3, 5, 2));
    }
}
