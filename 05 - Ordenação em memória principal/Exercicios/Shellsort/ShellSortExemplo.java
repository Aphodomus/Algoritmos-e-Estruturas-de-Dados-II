class ShellSort {
    public ShellSort() {

    }
    public void insercaoPorCor(int array[], int cor, int h) {
        int n = array.length;
        for (int i = (h + cor); i < n; i += h) {
            int tmp = array[i];
            int j = i - h;

            while ((j >= 0) && (array[j] > tmp)) {
                array[j + h] = array[j];
                j -= h;
            }
            array[j + h] = tmp;
        }
    }

    // Ordenar
    public void sort(int array[]) {
        int h = 1;
        int n = array.length;

        do {
            h = (h * 3) + 1;
        } while (h < n);

        do {
            h /= 3;
            for (int cor = 0; cor < h; cor++) {
                insercaoPorCor(array, cor, h);
            }
        } while (h != 1);
    }

    // Printar
    public void print(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}

public class ShellSortExemplo {
    public static void main(String[] args) {
        ShellSort bo = new ShellSort();

        int array[] = {64, 34, 25, 12, 22, 11, 90, 34, 123, 27};

        bo.sort(array);

        bo.print(array);
    }
}
