public class unidade00b_exercicio10 {
    /* O que o programa abaixo mostra na tela? */
    //Ele vai criar um loop infinito e vai ir incrementando + 1 em todas as variáveis b, s, i e l
    public static void main(String[] args) {
        byte b = 0;
        short s = 0;
        int i = 0;
        long l = 0;
        while (true) {
            b++;
            s++;
            i++;
            l++;
            System.out.println(b + " " + s + " " + i + " " + l);
        }
    }
}
