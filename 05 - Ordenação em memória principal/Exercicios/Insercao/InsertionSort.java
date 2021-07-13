public class InsertionSort {
    public static void insertionSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int tmp = array[i];
            int j = i - 1;
            while ((j >= 0) && (array[j] > tmp)) {
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