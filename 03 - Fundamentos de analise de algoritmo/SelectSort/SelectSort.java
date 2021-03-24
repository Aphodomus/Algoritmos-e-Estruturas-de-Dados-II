public class SelectSort {
    public static int comparisons = 0;
    public static int moves = 0;

    //Ordenar as musicas por meio do Selecao
    public static void sortBySelection(int[] array, int n) {
        int temp = 0;
        int menor = 0;
        int comparasionsSelection = 0;

        for (int i = 0; i < (n - 1); i++) {
            menor = i;
            for (int j = (i + 1); j < n; j++) {
                if (array[menor] > array[j]) {
                    menor = j;
                }
            }
            
            //Trocar o menor elemento encontrado
            if (menor != i) {
                temp = array[i];
                array[i] = array[menor];
                array[menor] = temp;
            }
        }

        moves = 3*(n - 1);
        comparasionsSelection = (int) (Math.pow((n - 1), 2) + (n - 1))/2;
        comparisons = comparisons + comparasionsSelection;
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

        sortBySelection(array, array.length);
        MyIO.println("\nOrdenado: \n");
        for (int p = 0; p < array.length; p++) {
            MyIO.println(array[p]);
        }
    }
}
