public class QuickSort {
    public static int comparisons = 0;
    public static int moves = 0;

    public static void quicksort(int[] array, int esq, int dir) {
        int i = esq, j = dir, pivo = array[(esq + dir) / 2];
        int tmp = 0;

        while (i <= j) {
            while (array[i] < pivo)
                i++;
            while (array[j] > pivo)
                j--;
            if (i <= j) {
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;

                i++;
                j--;
            }
        }
        if (esq < j)
            quicksort(array, esq, j);
        if (i < dir)
            quicksort(array, i, dir);
    }

    public static void main(String[] args) {
        int[] array = new int[223];
        //int i = 0;
        int q = 0;

        for (int i = 222; i > 0; i--) {
            array[q] = i;
            q++;
        }

        for (int m = 0; m < array.length; m++) {
            MyIO.println(array[m]);
        }

        quicksort(array, 0, array.length - 1);

        MyIO.println("\nOrdenado: \n");
        for (int p = 0; p < array.length; p++) {
            MyIO.println(array[p]);
        }
    }
}
