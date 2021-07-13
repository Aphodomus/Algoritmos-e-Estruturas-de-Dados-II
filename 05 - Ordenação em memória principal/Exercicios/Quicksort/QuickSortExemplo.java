class QuickSort {
    public QuickSort() {

    }

    // Ordenar
    public void sort(int array[], int esq, int dir) {
        int i = esq;
        int j = dir;
        int pivo = array[(esq + dir)/2];

        while (i <= j) {
            while (array[i] < pivo) {
                i++;
            }

            while (array[j] > pivo) {
                j--;
            }

            if (i <= j) {
                // swap
                int tmp = array[i];
                array[i] = array[j];
                array[j]= tmp;

                i++;
                j--;
            }
        }

        if (esq < j) {
            sort(array, esq, j);
        }

        if (i < dir) {
            sort(array, i, dir);
        }
    }

    // Printar
    public void print(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}

public class QuickSortExemplo {
    public static void main(String[] args) {
        QuickSort bo = new QuickSort();

        int array[] = {64, 34, 25, 12, 22, 11, 90, 34, 123, 27};

        bo.sort(array, 0, array.length - 1);

        bo.print(array);
    }
}
