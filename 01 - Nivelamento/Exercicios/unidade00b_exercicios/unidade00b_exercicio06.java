public class unidade00b_exercicio06 {
    /* Um aluno desenvolveu o código abaixo, corrija-o: */
    //Primeira coisa a se melhorar e a identacao
    //Segunda coisa a se melhorar e simplificar o codigo

    public static boolean isConsoante(String s, int i) {
        boolean resp = true;
        if (i == s.length()) {
            resp = true;
        } else if (isConsoante(s.charAt(i)) == false) {
            resp = false;
        } else {
            resp = isConsoante(s, i + 1);
        }
        return resp;
    }

    public static char toUpper(char c) {
        return (c >= 'a' && c <= 'z') ? ((char) (c - 32)) : c;
    }

    public static boolean isVogal(char c) {
        c = toUpper(c);
        return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }

    public static boolean isLetra(char c) {
        return (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'Z');
    }

    public static boolean isConsoante(char c) {
        return (isLetra(c) == true && isVogal(c) == false);
    }

    public static void main(String[] args) {

        boolean resultado = isConsoante("Daniel", 2);

        MyIO.print("Resultado : " + resultado);
    }
}
