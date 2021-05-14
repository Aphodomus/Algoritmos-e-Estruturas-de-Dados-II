public class TreeSort {
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
        raiz = inserir(elemento, raiz);
        n++;
    }

    public No inserir(int elemento, No no) throws Exception {
        if (no == null) {
            no = new No(elemento);
        } else if (elemento < no.elemento) {
            no.esq = inserir(elemento, no.esq);
        } else if (elemento > no.elemento) {
            no.dir = inserir(elemento, no.dir);
        } else {
            throw new Exception("Erro, nao pode inserir um elemento repetido");
        }

        return no;
    }
}
