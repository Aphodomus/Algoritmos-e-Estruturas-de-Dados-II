class No {
    // Atributos
    public int elemento;
    public No esq;
    public No dir;
    // Metodos especiais
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
    // Funcoes e metodos
}


class ArvoreBinaria {
    // Atributos
    public No raiz;

    // Metodos especiais
    public ArvoreBinaria() {
        this.raiz = null;
    }

    // Funcoes e metodos
    public void inserir(int elemento) {
        boolean resp = false;
        No no = new No(elemento);
        No aux = this.raiz;

        // Caso a raiz seja null
        if (aux == null) {
            raiz = no;
            resp = true;
        }

        // Percorrer a arvore para inserir
        while (resp == false && aux != null) {
            if (aux == null) {
                aux = no;
                resp = true;
            } else if (no.elemento <= aux.elemento) {
                aux = aux.esq;
            } else {
                aux = aux.dir;
            }
        }
    }
}

public class BinaryTree {
    public static void main(String[] args) {

    }
}
