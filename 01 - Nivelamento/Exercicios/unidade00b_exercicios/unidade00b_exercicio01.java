/* Faça um método que receba um array de inteiros e um
número inteiro x e retorne um valor booleano informando se o
elemento x está contido no array*/

public class unidade00b_exercicio01 {
    public static boolean procurar_valor(int array[], int valor) {
        for (int i = 0; i < array.length; i = i + 1) {
            if (array[i] == valor) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {6,54,3,78,56,3,98,12,25,45,21,56,45,34};

        int valor = MyIO.readInt("Digite um valor para ser procurado: ");
        boolean resultado = procurar_valor(array, valor);

        MyIO.print("O valor foi encontrado ? " + resultado + "\n\n");

        MyIO.pause("Aperte ENTER para sair do programa.");
    }
}
