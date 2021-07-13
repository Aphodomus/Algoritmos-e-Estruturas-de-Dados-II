// Faça um método recursivo que receba um array de caracteres e retorne um número inteiro indicando a quantidade de vogais do mesmo

public class unidade00h_exercicio08 {
    public static char toUpper(char c){
        return (c >= 'a' && c <= 'z') ? (char)(c - 32) : c ;
    }
    
    public static boolean isVogal(char c) {
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }

    public static int contVogal(String s, int i) {
        int cont = 0;
        if (i < s.length()) {
            if (isVogal(toUpper(s.charAt(i))) == true) {
                cont++;
            }
            cont += contVogal(s, i + 1);
        }
        return cont;
    }

    public static void main(String[] args) {
        String palavra = "As pessoas dividem se entre aquelas que poupam como se vivessem para sempre e aquelas que gastam como se fossem morrer amanha";
        int resp = contVogal(palavra, 0);
        MyIO.println(resp); 
    }
}
