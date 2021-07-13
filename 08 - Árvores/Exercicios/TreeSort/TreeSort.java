import java.util.*;

class No {
    // Atributos
    public int elemento;
    public No esq;
    public No dir;

    // Metodos Especiais
    public No() {
        this.elemento = 0;
        this.esq = null;
        this.dir = null;
    }

    public No(int elemento) {
        this.elemento = elemento;
        this.esq = null;
        this.dir = null;
    }

    public No(int elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}

class TreeSort {
    //--------------------------- Atributos -------------------------------//
    public No raiz;
    private int n;

    //--------------------------- Metodos Especiais -------------------------------//
    public TreeSort() {
        raiz = null;
        n = 0;
    }

    //--------------------------- Metodos e Funcoes -------------------------------//

    // Metodo para organizar a arvore
    public int[] sort() {
        int[] array = new int[n];
        n = 0;
        sort(raiz, array);
        return array;
    }

    public void sort(No no, int[] array) {
        if (no != null) {
            sort(no.esq, array);
            array[n++] = no.elemento;
            sort(no.dir, array);
        }
    }

    // Metodo para inserir um elemento na treesort
    public void inserir(int elemento) throws Exception {
        n++;
        raiz = inserir(elemento, raiz);
    }

    public No inserir(int elemento, No no) throws Exception {
        if (no == null) {
            no = new No(elemento);
        } else if (elemento < no.elemento) {
            no.esq = inserir(elemento, no.esq);
        } else if (elemento >= no.elemento) {
            no.dir = inserir(elemento, no.dir);
        } else {
            throw new Exception("Erro");
        }

        return no;
    }
}


public class BinaryTree06 {
    public static void main(String[] args) throws Exception {
        /*Um algoritmo de ordenação e o TreeSort que insere os elementos do array
        em uma arvore binaria: Pesquisa e Caminhamento e utiliza um "caminhar"
        para ordenar os elementos do array. Implemente o TreeSort e faça a analise
        de complexidade do mesmo*/
        TreeSort arvore1 = new TreeSort();
        int array[] = {5, 4, 7, 2, 11};

        for (int i = 0; i < array.length; i++) {
            System.out.println("antes: " + array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            arvore1.inserir(array[i]);
        }

        array = arvore1.sort();

        for (int i = 0; i < array.length; i++) {
            System.out.println("depois: " + array[i]);
        }
        
    }
}
