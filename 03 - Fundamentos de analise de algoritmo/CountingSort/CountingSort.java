public class CountingSort {
    public static int getMaior(int[] array, int n) {
        int maior = array[0];

        for (int i = 0; i < n; i++) {
            if (maior < array[i]) {
                maior = array[i];
            }
        }
        return maior;
    }

    // Ordenar as musicas por meio do Counting Sort
    public static void sortByCountingSort(int[] array, int n) {
        // Array para contar o numero de ocorrencias de cada elemento
        int[] count = new int[getMaior(array, n) + 1];
        int[] ordenado = new int[n];
        // Inicializar cada posicao do array de contagem
        for (int i = 0; i < count.length; count[i] = 0, i++);
        // Agora, o count[i] contem o numero de elemento iguais a i
        for (int i = 0; i < n; count[array[i]]++, i++);
        // Agora, o count[i] contem o numero de elemento menores ou iguais a i
        for (int i = 1; i < count.length; count[i] += count[i - 1], i++);
        // Ordenando
        for (int i = n - 1; i >= 0; ordenado[count[array[i]] - 1] = array[i], count[array[i]]--, i--);

        for (int m = 0; m < getMaior(array, n) + 1; m++) {
            MyIO.println(count[m]);
        }
        // Copiando para o array original
        for (int i = 0; i < n; i++) {

            array[i] = ordenado[i];

        }
    }

    public static void main(String[] args) {
        int n = 10;
        int[] array = new int[n];
        int k = 0;

        for (int i = n - 1; i > 0; i--) {
            array[k] = i * 2;
            k++;
        }

        for (int m = 0; m < n; m++) {
            MyIO.println(array[m]);
        }

        sortByCountingSort(array, n);

        MyIO.println("\nOrdenado: \n");
        for (int p = 0; p < n; p++) {
            MyIO.println(array[p]);
        }
    }
}
