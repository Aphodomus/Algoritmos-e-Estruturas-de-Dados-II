class HeapSort {
    public HeapSort() {

    }

    // Ordenar
    public void sort(int array[]) {
        int tamanho = array.length; // -1 ?
        int tmp = 0;

        for (int i = tamanho / 2 - 1; i >= 0; i--) {
            heapify(array, tamanho, i);
        }

        for (int i = tamanho - 1; i > 0; i--) {
            tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;

            heapify(array, i, 0);
        }
    }

    public void heapify(int array[], int n, int i) {
        int maior = i;
        int esq = 2 * i + 1;
        int dir = 2 * i + 2;

        if (esq < n && array[esq] > array[maior]) {
            maior = esq;
        }

        if (dir < n && array[dir] > array[maior]) {
            maior = dir;
        }

        if (maior != i) {
            int tmp = array[i];
            array[i] = array[maior];
            array[maior] = tmp;

            heapify(array, n, maior);
        }
    }
    
    // Printar
    public void print(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}

public class HeapSortExemplo {
    public static void main(String[] args) {
        HeapSort bo = new HeapSort();

        int array[] = {64, 34, 25, 12, 22, 11, 90, 34, 123, 27};

        bo.sort(array);

        bo.print(array);
    }
}
