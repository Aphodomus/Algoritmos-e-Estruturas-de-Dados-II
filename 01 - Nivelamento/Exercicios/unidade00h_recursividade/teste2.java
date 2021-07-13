public class teste2 {
    public static int fibonacci(int valor) {
        if(valor == 0 || valor == 1) {
            return valor;
        } else {
            return fibonacci(valor - 1) + fibonacci(valor - 2);
        }
    }

    public static void main(String[] args) {
        int numero = MyIO.readInt();
        int resp = fibonacci(numero);
        MyIO.println("\n" + resp);
    }
}
