public class Teste01 {
    public static void heapify(int[] array, int n, int i) {
        int maior = i; //Inicializar o maior como raiz
        int esq = 2 * i + 1; //Esquerda = 2 * i + 1
        int dir = 2 * i + 2; //Direita = 2 * i + 2

        //Se o filho da esquerda for maior que a raiz
        if (esq < n && array[esq] > array[maior]) {
            maior = esq;
        }

        //Se o filho da direita for maior do que o maior ate agora
        if (dir < n && array[dir] > array[maior]) {
            maior = dir;
        }

        //Se o maior nao e a raiz
        if (maior != i) {
            int swap = array[i];
            array[i] = array[maior];
            array[maior] = swap;

            //Montar recursivamente a subarvore
            heapify(array, n, maior);
        }
    }

    public static void sort(int[] array, int n) {
        //Construir heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        //Extrair um por um dos elementos da pilha
        for (int i = n - 1; i > 0; i--) {
            //Mover a raiz atual para o fim do array
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            //chamar heap reduzido
            heapify(array, i, 0);
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int[] array = new int[n];
        int k = 0;

        for (int i = n - 1; i > 0; i--) {
            array[k] = i * 2;
            k++;
        }

        for (int m = 0; m < n; m++) {
            MyIO.println(array[m]);
        }

        sort(array, n);

        MyIO.println("\nOrdenado: \n");
        for (int p = 0; p < n; p++) {
            MyIO.println(array[p]);
        }
    }
}
