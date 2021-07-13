public class BinarySearch {
    public static void main(String[] args) {
        int n = 12;
        boolean resp = false;
        int direita = n - 1, esquerda = 0, meio;
        int array[] = {1,2,3,4,5,6,7,8,9,10,14,15};
        int x = 0;
        while(esquerda <= direita) {
            meio = (esquerda + direita) / 2;

            if (x == array[meio]) {
                resp = true;
                esquerda = n;
            } else {
                if (array[meio] < x) {
                    esquerda = meio + 1;
                } else {
                    direita = meio - 1;
                }
            }
        }

        MyIO.println(resp);
    }
}
