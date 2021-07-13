// • Faça métodos ITERATIVO e RECURSIVO para mostrar os números 0 à 3

public class unidade00h_exercicio03 {
    public static void mostrarIterativo() {
        for (int i = 0; i < 4; i = i + 1) {
            MyIO.println(i);
        }
    }

    public static void mostrarRecursivo(int n) {
        if (n < 4) {
            MyIO.println(n);
            mostrarRecursivo(n + 1);
        }
    }
    public static void main(String[] args) {
        mostrarIterativo();
        mostrarRecursivo(0);
    }
}
