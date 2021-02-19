public class unidade00b_exercicio04 {

    public static void mostrar_maior_menor(int array[]) {
        int menor, maior;

        menor = array[9];
        maior = array[0];

        for (int i = 0; i < array.length; i = i + 1) {
            if (array[i] < menor) {
                menor = array[i];
            }

            if (array[i] > maior) {
                maior = array[i];
            }
        }

        MyIO.print("\nMaior valor = " + maior);
        MyIO.print("\nMenor valor = " + menor + "\n");
    }
    public static void main(String[] args) {
        int[] array = {23,3,7,76,113,56,3,45,34,98,776,54,334};

        mostrar_maior_menor(array);

        MyIO.pause("Aperte ENTER para fechar o programa.\n");
    }
}