//Calcular fibonacci

public class unidade00h_exercicio02 {
    public static int fibonacci(int n) {
        int resp;
        if (n == 0 || n == 1) {
            resp = 1;
        } else {
            resp = fibonacci(n - 1) + fibonacci(n - 2);
        }
        return resp;
    }

    public static void main(String[] args) {
        int numero = 0;
        int resp = 0;
        numero = MyIO.readInt("Digite um numero inteiro: ");
        resp = fibonacci(numero);
        MyIO.println(resp);
    }
}

//Chamada recursiva = fibonacci(n - 1) + fibonacci(n - 2)
//Condicao de parada = n == 0 || n == 1
