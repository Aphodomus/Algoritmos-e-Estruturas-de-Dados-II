public class unidade00b_exercicio05 {
    /* O que o código abaixo faz? */
    public static boolean doidao (char c){
        boolean resp= false;
        int v = (int) c;
        if (v == 65 || v == 69 || v == 73 || v == 79 || v == 85 || v == 97 || v == 101 || v ==105 ||
            v == 111 || v == 117){
            resp = true;
        }
        return resp;
    }
    public static void main(String[] args) {
        MyIO.print("\n\nA funcao denominada 'doidao' verifica se o caracter passado como parametro 'c', depois de ser transformado em um inteiro por meio de (int)");
        MyIO.print(" e usando o numero da tabela ASCII corresponde a alguma letra do alfabeto = 'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'");
        MyIO.print(" ou seja, verifica se o caracter e uma vogal. Se for uma vogal, ele atribui o valor true a variavel resp e retorna ela no");
        MyIO.print(" final, caso contrario, retorna a variavel com o valor false.\n\n");

        
    }
}
