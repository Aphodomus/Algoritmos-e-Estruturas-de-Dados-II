class CountingSort {
    public CountingSort() {

    }

    // Ordenar
    public void sort(int array[]) {
        int[] count = new int[getMaior(array) + 1];
        int[] ordenado = new int[array.length];

        for (int i = 0; i < count.length; count[i] = 0, i++);

        for (int i = 0; i < array.length; count[array[i]]++, i++);

        for (int i = 1; i < count.length; count[i] += count[i - 1], i++);
    
        for (int i = array.length - 1; i >= 0; ordenado[count[array[i]] - 1] = array[i], count[array[i]]--, i--);

        for (int i = 0; i < array.length; i++) {
            array[i] = ordenado[i];
        }
    }

    // Maior elemento
    public int getMaior(int array[]) {
        int maior = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > maior) {
                maior = array[i];
            }
        }

        return maior;
    }

    // Printar
    public void print(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}

public class CountingExemplo {
    public static void main(String[] args) {
        CountingSort bo = new CountingSort();

        int array[] = {64, 34, 25, 12, 22, 11, 90, 34, 123, 27};

        bo.sort(array);

        bo.print(array);
    }
}
