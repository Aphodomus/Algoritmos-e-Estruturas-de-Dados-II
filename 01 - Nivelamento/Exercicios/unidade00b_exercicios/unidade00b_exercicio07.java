public class unidade00b_exercicio07 {
    /* Qual das duas versões é mais fácil de entender? */
    //A primeira versao e mais facil de entender, pois utiliza o operador == false que deixa mais explicito
    //Que a comparacao quer saber se o valor e falso e o uso do else if facilita a leitura do codigo

    public static boolean isConsoante1(String s, int i) {
        boolean resp = true;
        if (i == s.length()) {
            resp = true;
        } else if (isConsoante1(s.charAt(i)) == false) {
            resp = false;
        } else {
            resp = isConsoante1(s, i + 1);
        }
        return resp;
    }

    public static boolean isConsoante2(String s, int i) {
        boolean resp = true;
        if (i < s.length()) {
            if (!isConsoante2(s.charAt(i))) {
                resp = false;
            } else {
                resp = isConsoante2(s, i + 1);
            }
        } else {
            resp = true;
        }
        return resp;
    }

    public static void main(String[] args) {

    }
}
