public class InsertionSortBinary {
    public static int binarySearch(int array[], int procurar, int esquerda, int direita) {
        if (direita <= esquerda) {
            return (procurar > array[esquerda]) ? (esquerda + 1) : esquerda;
        }

        int meio = (esquerda + direita) / 2;

        if (procurar == array[meio]) {
            return meio + 1;
        }

        if (procurar > array[meio]) {
            return binarySearch(array, procurar, meio + 1, direita);
        }

        return binarySearch(array, procurar, esquerda, meio - 1);
    }
    
    public static void insertionSort(int[] array) {
        int n = array.length;
        int local = 0;

        for (int i = 1; i < n; i++) {
            int tmp = array[i];
            int j = i - 1;

            //Encontrar a posicao onde deveria ser inserido
            local = binarySearch(array, tmp, 0, j);

            //Mova todos os elementos após a localização para criar espaço
            while (j >= local) {
                array[j + 1] = array[j]; // Deslocamento
                j--;
            }
            array[j + 1] = tmp;
        }
    }
    public static void main(String[] args) {
        int[] array = new int[223];
        int i = 0;

        for (i = 0; i < array.length/2; i++) {
            array[i] = (i - 4) * 2;
        }

        for (int k = i; k < array.length; k++) {
            array[k] = k - 23;
        }

        MyIO.println("\nDesordenado: \n");

        for (int m = 0; m < array.length; m++) {
            MyIO.println(array[m]);
        }

        insertionSort(array);
        MyIO.println("\nOrdenado: \n");
        for (int p = 0; p < array.length; p++) {
            MyIO.println(array[p]);
        }
    }
}

/**
Comparações = C(n) = TETO log(n)
Complexidade = O(n^2)
 */