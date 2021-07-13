//• Faça um método recursivo que receba dois números inteiros e retorne a multiplicação do primeiro pelo segundo fazendo somas

public class unidade00h_exercicio05 {
    public static int recursive(int x, int y) {
        int resp = 0;

        if (y > 0) {
            resp = x + recursive(x, y - 1);
        }

        return resp;
    }
    public static void main(String[] args) {
        int x = 4;
        int y = 10;
        int resp;
        resp = recursive(x, y);

        MyIO.println(resp);
    }
}
