public class No {
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
