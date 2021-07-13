public class unidade00b_exercicio09 {
    /* Qual é a diferença entre os dois métodos abaixo? */

    //O primeiro metodo decrementa na variavel i antes dela ser utilizada no comando.
    //O segundo metodo decrementa na variavel i depois dela ser utilizada no comando.
    public static int m1(int i) {
        return i--;
    }

    public static int m2(int i) {
        return --i;
    }
    public static void main(String[] args) {
        MyIO.print("Parametro [7] Resultado = " + m1(7) + "\n");
        MyIO.print("Parametro [5] Resultado = " + m2(5) + "\n");

        MyIO.pause("Aperte ENTER para fechar o programa");
    }
}
