//Faça um método recursivo que receba um string e retorne um número inteiro indicando a quantidade de caracteres NOT vogal AND NOT consoante maiúscula da string recebida como parâmetro

public class unidade00h_exercicio09 {
    public static char toUpper(char c){
        return (c >= 'a' && c <= 'z') ? (char)(c - 32) : c ;
    }

    public static boolean isVogal(char c) {
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }

    public static boolean isConsoante(char c) {
        if (c == 'B' || c == 'C' || c == 'D' || c == 'F' || c == 'G' || c == 'J' || c == 'K' || c == 'L' || c == 'M' || c == 'N' || c == 'P' || c == 'Q' || c == 'R' || c == 'S' || c == 'T' || c == 'V' || c == 'W' || c == 'X' || c == 'Z') {
            return true;
        }
        return false;
    }

    public static int verificarString(String palavra, int i) {
        int cont = 0;
        if (i < palavra.length()) {
            if (isVogal(toUpper(palavra.charAt(i))) == false && isConsoante(palavra.charAt(i)) == false) {
                cont++;
            }
            cont += verificarString(palavra, i + 1);
        }
        return cont;
    }
    public static void main(String[] args) {
        String palavra = "DDDaniel Vitor";
        int resp = verificarString(palavra, 0);
        MyIO.println(resp); 
    }
}
