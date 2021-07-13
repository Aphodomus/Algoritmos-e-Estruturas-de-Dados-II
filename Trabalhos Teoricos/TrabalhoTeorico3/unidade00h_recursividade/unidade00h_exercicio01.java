//Para toda recursividade é importante ter um ponto de parada e uma chamada recursiva
//Calcular fatorial

public class unidade00h_exercicio01 {
    public static int fatorial(int n) {
        int resp;
        if (n == 1) {
            resp = 1;
        } else {
            resp = n * fatorial(n - 1);
        }
        return resp;
    }
    public static void main(String[] args) {
        int numero = 0;
        int resp = 0;
        numero = MyIO.readInt("Digite um numero inteiro: ");
        resp = fatorial(numero);
        MyIO.println(resp);
    }
}

//Chamada recursiva = fatorial(n - 1)
//Condicao de parada = n == 1
