/*Repita o exercício acima considerando que os elementos do
array estão ordenados de forma crescente. Uma sugestão
seria começar a pesquisa pelo meio do array*/

public class unidade00b_exercicio02 {
    public static void bubble_sort(int array[]) {
        int aux;

        for (int x = 0; x < array.length; x = x + 1) {

            for (int y = x + 1; y < array.length; y = y + 1) {
                if (array[x] > array[y]) {
                    aux = array[x];
                    array[x] = array[y];
                    array[y] = aux;
                }
            }
        }
    }

    public static boolean encontrar_valor_meio(int array[], int valor) {
        int limite_esquerda = 0;
        int limite_direita = array.length - 1;
        int meio;

        while (limite_esquerda <= limite_direita) {
            meio = (limite_esquerda + limite_direita) / 2;

            if (valor == array[meio]) {
                return true;
            }

            if (array[meio] < valor) {
                limite_esquerda = meio + 1;
            } else {
                limite_direita = meio - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] array = { 10, 20, 25, 30, 35, 60, 80, 85, 90, 95, 100 };

        int valor = MyIO.readInt("Digite um valor para ser procurado: ");

        bubble_sort(array);

        boolean resultado = encontrar_valor_meio(array, valor);

        MyIO.print("O valor foi encontrado ? " + resultado + "\n");

        MyIO.pause("Aperte ENTER para fechar o programa.");
    }
}
