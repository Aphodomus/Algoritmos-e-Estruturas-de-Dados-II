

public class teste {
    public static void main(String[] args) {
        //tipo nome = valor
        MyIO.print("Digite o valor do log: ");
        double a = MyIO.readInt();

        double log = Math.log(a);

        MyIO.print("Digite o valor");

        double log10 = Math.log(log);

        MyIO.println("O valor do log de " + a + " e = " + log10);

        
    }
}
