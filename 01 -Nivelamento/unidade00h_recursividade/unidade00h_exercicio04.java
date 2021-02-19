// Por que o código abaixo imprime 2, 1, 0, 0, 1 e 2?

public class unidade00h_exercicio04 {
    public static void printRecursivo(int i) {
        System.out.println(i);
        if (i > 0) {
            printRecursivo(i - 1);
        }
        System.out.println(i);
    }

    public static void main(String[] args) {
        int numero = 5;
        printRecursivo(numero);
    }
}

//Temos como se cada chamada recursiva fosse um metodo diferente
