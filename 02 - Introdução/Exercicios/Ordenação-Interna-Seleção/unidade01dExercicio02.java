//Selection sort
import java.util.Arrays;
import java.util.Random;

//Mostre todas as comparações e movimentações do algoritmo anterior para o array abaixo:

public class unidade01dExercicio02 {
    public static void swap(int array[], int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static int[] gerarVetor(int numero) {
        int []v = new int[numero];

        Random gerador = new Random();

        for (int i = 0; i < numero; i = i + 1) {
            v[i] = gerador.nextInt(100);
        }

        return v;
    }

    public static void selectSort(int array[]) {
        int mov = 0;
        for (int i = 0; i < array.length; i = i + 1) {
            int menor = i;
            for (int j = i + 1; j < array.length; j = j + 1) {
                if (array[j] < array[menor]) {
                    menor = j;
                }
            }
            swap(array, i, menor);
            System.out.println((array.length - i - 1));
            mov = mov + 3;
        }
        MyIO.println(mov);
    }

    public static void main(String[] args) {
        int []array = gerarVetor(6);
        selectSort(array);
        System.out.println(Arrays.toString(array));
        
    }
}

/**
 * O algoritmo realiza  3(n – 1) movimentações, ou seja, 3(18 - 1) = 51 movimentações
 * O algoritmo realiza (n - i - 1) comparações
 * n(n-1) = n^2 - n
 * 
 * 
 * 
 */
