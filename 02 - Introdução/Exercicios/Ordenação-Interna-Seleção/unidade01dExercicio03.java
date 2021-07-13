/* Execute a versão abaixo do Seleção para arrays gerados aleatoriamente.
Em seguida, discuta sobre os números de comparações inseridas e
movimentações evitadas pela nova versão do algoritmo
*/
import java.util.Arrays;
import java.util.Random;

public class unidade01dExercicio03 {
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
        for (int i = 0; i < (array.length - 1); i++) {
            int menor = i;
            for (int j = (i + 1); j < array.length; j++){
                if (array[menor] > array[j]){
                    menor = j;
                }
            }
            if (menor != i){
                swap(array ,menor, i);
                mov = mov + 3;
            }
            System.out.println((array.length - i - 1));
        }
        MyIO.println(mov);
    }

    public static void main(String[] args) {
        int []array = gerarVetor(18);
        selectSort(array);
        System.out.println(Arrays.toString(array));  
    }
}

/*Sobre o numero de comparações, agora o algoritmo faz uma comparação a menos, pois ele não vai comparar quando o menor for igual a i
* Sobre a movimentação, ele se movimenta menos pois agora faz menos comparações também
 * 
 */
