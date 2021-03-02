//Selection sort
import java.util.Arrays;
import java.util.Random;

public class unidade01dExercicio01 {
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
        for (int i = 0; (i < array.length - 1); i = i + 1) {
            int menor = i;
            for (int j = i + 1; j < array.length; j = j + 1) {
                if (array[j] < array[menor]) {
                    menor = j;
                }
            }
            swap(array, i, menor);
            mov = mov + 3;
        }
        MyIO.println(mov);
    }

    public static void main(String[] args) {
        int []array = gerarVetor(20);
        selectSort(array);
        System.out.println(Arrays.toString(array));
        
    }
}

/**
 * (Obs.1): O maior valor de i é (n-2), pois repetimos enquanto i for menor que (n-1)
 * 
 * (Obs.2): No final, o elemento da posição (n-1) será o maior, pois os (n-1) menores elementos já foram separados
 * 
 * Quantas movimentações entre elementos do array sao realizadas ?
 * 3(n-1)
 * 
 * Pq 3 ? pq dentro do swap ele faz 3 movimentações
 * 
 * Quantas comparações entre elementos do array sao realizadas ?
 * (n - i - 1);
 * 
 * 
 * 
 */
