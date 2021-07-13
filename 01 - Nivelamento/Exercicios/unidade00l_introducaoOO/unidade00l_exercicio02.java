/* Faça uma classe retângulo contendo os atributos base e
altura, pelo menos dois métodos construtores, o método
double getArea() que retorna a área do retângulo, o método
double getPerimetro() que retorna o perímetro do retângulo e
o método double getDiagonal() que retorna a diagonal do
retângulo
*/

public class unidade00l_exercicio02 {
    public static void main(String[] args) {
        Retangulo r1 = new Retangulo(2.4, 5.3);
        
        MyIO.println("Base: " + r1.getBase());
        MyIO.println("Altura: " + r1.getAltura());
        MyIO.println("Area: " + r1.getArea());
        MyIO.println("Perimetro: " + r1.getPerimetro());
        MyIO.println("Diagonal: " + r1.getDiagonal());
    }
}
