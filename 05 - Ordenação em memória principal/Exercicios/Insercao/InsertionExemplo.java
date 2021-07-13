class InsertionSort {
    public InsertionSort() {

    }

    // Ordenar
    public void sort(int array[]) {
        int tmp = 0;
        int n = array.length;

        for (int i = 1; i < n; i++) {
            tmp = array[i];
            int j = i - 1;

            while ((j >= 0) && (array[j] > tmp)) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = tmp;
        }
    }

    // Printar
    public void print(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}

public class InsertionExemplo {
    public static void main(String[] args) {
        InsertionSort bo = new InsertionSort();

        int array[] = {64, 34, 25, 12, 22, 11, 90, 34, 123, 27};

        bo.sort(array);

        bo.print(array);
    }
}
