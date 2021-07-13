class MergeSort {
    public MergeSort() {

    }

    // Ordenar
    public void sort(int array[], int esq, int dir) {
        if (esq < dir) {
            int m = esq + (dir - esq) / 2;

            sort(array, esq, m);
            sort(array, m + 1, dir);

            merge(array, esq, m, dir);
        }
    }

    public void merge(int array[], int esq, int m, int dir) {
        int n1 = m - esq + 1;
        int n2 = dir - m;

        int ESQ[] = new int[n1];
        int DIR[] = new int[n2];
        
        for (int i = 0; i < n1; ++i) {
            ESQ[i] = array[esq + i];
        }

        for (int j = 0; j < n2; ++j) {
            DIR[j] = array[m + 1 + j];
        }

        int i = 0, j = 0;

        int k = esq;

        while (i < n1 && j < n2) {
            if (ESQ[i] <= DIR[j]) {
                array[k] = ESQ[i];
                i++;
            } else {
                array[k] = DIR[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = ESQ[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = DIR[j];
            j++;
            k++;
        }
    }

    // Printar
    public void print(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}

public class MergeSortExemplo {
    public static void main(String[] args) {
        MergeSort bo = new MergeSort();

        int array[] = {64, 34, 25, 12, 22, 11, 90, 34, 123, 27};

        bo.sort(array, 0, array.length - 1);

        bo.print(array);
    }
}
