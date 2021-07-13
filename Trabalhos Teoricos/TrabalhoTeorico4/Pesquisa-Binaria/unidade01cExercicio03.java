//Resposta as seguintes questoes abaixo sobre o algoritmo

public class unidade01cExercicio03 {
    public static boolean PesquisaBinaria(int array[], int procurar, int tamanho) {
        boolean resp = false;
        int direita = tamanho - 1;
        int esquerda = 0;
        int meio;

        while (esquerda <= direita) {
            meio = (esquerda + direita)/2;

            if (array[meio] == procurar) {
                resp = true;
                esquerda = tamanho;
            } else {
                if (array[meio] < procurar) {
                    esquerda = meio + 1;
                } else {
                    direita = meio - 1;
                }
            }
        }
        
        return resp;
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        
        for (int i = 0; i < array.length; i = i + 1) {
            array[i] = i;
        }
        int procurar = 9;

        boolean resp = PesquisaBinaria(array, procurar, array.length);

        MyIO.println("Valor encontrado: " + resp);
    }
}

/* Qual e a operação relevante ?
*  Comparacao entre elementos do array
*
*  Quantas vezes ela será executada ?
*  No pior caso ela vai ser executada 2*lg(n) ou O(lg(n))
*  No melhor caso ela vai ser executada 1 vez, ou O(1)
*/
