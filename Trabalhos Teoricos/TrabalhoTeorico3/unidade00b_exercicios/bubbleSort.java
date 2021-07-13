public class bubbleSort {
    public static void imprime_array(int array[]) {
        for (int i = 0; i < array.length; i = i + 1) {
            MyIO.print("Valor na posicao [" + i + "] = " + array[i] + "\n");
        }
    }

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
    public static void main(String[] args) {
        int[] array = {23, 56, 34, 29, 21, 87, 98, 32, 115, 78, 54};

        bubble_sort(array);

        imprime_array(array);

        MyIO.pause("Aperte ENTER para sair do programa");
    }
}
