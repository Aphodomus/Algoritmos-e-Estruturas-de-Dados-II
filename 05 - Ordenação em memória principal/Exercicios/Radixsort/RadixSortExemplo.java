class RadixSort {
    public RadixSort() {

    }

    public int getMax(int arr[], int n) {
        int mx = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
            }
        }
    
        return mx;
    }

    public void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
 
        for (i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
 
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
 
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
 
        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // Ordenar
    public void sort(int array[]) {
        int m = getMax(array, array.length);

        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(array, array.length, exp);
        }
    }

    // Printar
    public void print(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}

public class RadixSortExemplo {
    public static void main(String[] args) {
        RadixSort bo = new RadixSort();

        int array[] = {64, 34, 25, 12, 22, 11, 90, 34, 123, 27};

        bo.sort(array);

        bo.print(array);
    }
}
