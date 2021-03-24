public class Teste01 {
    public static void main(String[] args) {
        int[] array = new int[11];
        array[0] = 9;
        array[1] = 8;
        array[2] = 3;
        array[3] = 7;
        array[4] = 6;
        array[5] = 1;
        array[6] = 2;
        array[7] = 5;
        array[8] = 4;
        array[9] = 0;
        array[10] = 31;
        int n = array.length;
        int tmp = 0;
        for (int i = n; i >= 1; i/= 2) {
            if (array[i] < array[n]) {
                tmp = array[n];
                array[n] = array[i];
                array[i] = tmp;
            }
            n = i;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(array[i]);
        }
    }
}
