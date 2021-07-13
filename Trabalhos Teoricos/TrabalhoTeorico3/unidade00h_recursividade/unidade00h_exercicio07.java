// Faça um método recursivo que receba um array de caracteres e retorne um valor booleano indicando se esse é um palíndromo

public class unidade00h_exercicio07 {
    public static boolean isPalindromo(String s, int i) {
        boolean resp;
        if (i >= s.length() / 2) {
            resp = true;
        } else if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
            resp = false;
        } else {
            resp = isPalindromo(s, i + 1);
        }
        return resp;
    }

    public static void main(String[] args) {
        String palavra = "anananananana";
        boolean resp = isPalindromo(palavra, 0);
        MyIO.println(resp);
    }
}
