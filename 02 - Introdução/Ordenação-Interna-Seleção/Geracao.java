import java.util.Random;
import java.util.Date;

class Geracao {
    //Atributos
    protected int[] array;
    protected int n;

    //Metodos especiais
    public Geracao() {
        array = new int[100];
        n = array.length;
    }

    public Geracao(int tamanho) {
        array = new int[tamanho];
        n = array.length;
    }

    public int[] getArray() {
        return this.array;
    }

    public void setArray(int array[]) {
        this.array = array;
    }

    public int getN() {
        return this.n;
    }

    public void setN(int n) {
        this.n = n;
    }

    //Metodos
    public void crescente() {
        for(int i = 0; i < n; i++) {
            array[i] = i;
        }
    }

    public void decrescente() {
        for(int i = 0; i < n; i++) {
            array[i] = n - 1 - i;
        }
    }

    public void aleatorio() {
        Random rand = new Random();
        crescente();
        for(int i = 0; i < n; i++) {
            swap(i, Math.abs(rand.nextInt()) % n);
        }
    }

    public void entradaPadrao() {
        n = MyIO.readInt();
        array = new int[n];
        for(int i = 0; i < n; i ++) {
            array[i] = MyIO.readInt();
        }
    }

    public void entrada(int[] vet) {
        n = vet.length;
        array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = vet[i];
        }
    }

    public void mostrar() {
        System.out.println("[");
        for(int i = 0; i < n; i++) {
            System.out.println(" (" + i + ")" + array[i]);
        }
        System.out.println("]");
    }

    public void swap(int i, int k) {
        int temp = array[i];
        array[i] = array[k];
        array[k] = temp;
    }

    public long now() {
        return new Date().getTime();
    }

    public boolean isOrdenado() {
        boolean resp = true;

        for (int i = 1; i < n; i++) {
            if(array[i] < array[i - 1]) {
                i = n;
                resp = false;
            }
        }
        
        return resp;
    }

    public void sort() {
        System.out.println("Método a ser implementado nas subclasses.");
    }
}
