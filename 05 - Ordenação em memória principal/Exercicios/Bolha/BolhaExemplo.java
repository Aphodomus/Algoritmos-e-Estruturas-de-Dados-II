class BubbleSort {
    public BubbleSort() {

    }
    
    // Ordenar
    public void sort(int array[]) {
        int tamanho = array.length;
        int tmp = 0;

        for (int i = tamanho - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    // Printar
    public void print(int array[]) {
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}

public class BolhaExemplo {
    public static void main(String[] args) {
        BubbleSort bo = new BubbleSort();

        int array[] = {64, 34, 25, 12, 22, 11, 90, 34, 123, 27};

        bo.sort(array);

        bo.print(array);
    }
}