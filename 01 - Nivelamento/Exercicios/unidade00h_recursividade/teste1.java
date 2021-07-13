public class teste1 {
    public static int fatorial(int valor) {
        int aux;
        MyIO.println("Entrei em fatorial " + valor);
        if (valor == 0) {
            aux = 1;
        } else {
            aux = valor * fatorial(valor - 1);
        }
        MyIO.println("Saindo de fatorial " + valor + " devolve = " + aux);
        return aux;
    }
    public static void main(String[] args) {
        int numero = MyIO.readInt();
        int resp = fatorial(numero);
        MyIO.println(resp);

    }
}


