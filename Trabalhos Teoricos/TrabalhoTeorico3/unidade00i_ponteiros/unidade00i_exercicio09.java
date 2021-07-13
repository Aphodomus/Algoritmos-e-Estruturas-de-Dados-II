/*Um estudante de Algoritmos e Estruturas de Dados (em JAVA) implementou uma
classe Hora, cujo construtor recebe e armazena uma hora, minuto e segundo. O que
acontece se a classe X abaixo for colocada na mesma pasta que a classe Hora?
*/
public class unidade00i_exercicio09 {
    public static void main(String[] args) {
        Hora h1 = new Hora(12, 30, 30);
        Hora h2 = new Hora(12, 30, 30);

        //Fazendo da maneira abaixo, h1 e h2 seria identico

        //Hora h2 = null;
        //h2 = h1;

        //Vai apontar como diferentes, pq o if esta comparando de o endereço de memoria de h1 e h2 sao iguais
        //O que e falso, os enderecos sao diferentes

        if (h1 == h2) {
            MyIO.println("ADRRs:");
            MyIO.println("h1 = " + h1);
            MyIO.println("h2 = " + h2);
            MyIO.println("Identicos !");
        } else {
            MyIO.println("ADRRs:");
            MyIO.println("h1 = " + h1);
            MyIO.println("h2 = " + h2);
            MyIO.println("Diferentes !");
        }
    }
}
