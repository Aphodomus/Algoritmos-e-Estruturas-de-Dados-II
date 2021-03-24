public class ShellSort {
    //Ordenar as musicas por meio do Selecao
    public static void sortByShellSort(int[] array, int n) {
        int temp = 0;
        int menor = 0;
        int j = 0;
        int comparasionsSelection = 0;

        //Iniciar com um gap grande, depois ir diminuindo
        for (int gap = n/2; gap > 0; gap /= 2) { // Divisoes sucessivas, log ?
            //A partir daqui e basicamente um insertion sort
            for (int i = gap; i < n; i++) {
                temp = array[i];
                for (j = i; j >= gap && array[j - gap] > temp; j--) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }

        //moves = 3*(n - 1);
        comparasionsSelection = (int) (Math.pow((n - 1), 2) + (n - 1))/2;
        //comparisons = comparisons + comparasionsSelection;
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

        sortByShellSort(array, array.length);
        MyIO.println("\nOrdenado: \n");
        for (int p = 0; p < array.length; p++) {
            MyIO.println(array[p]);
        }
    }
}
