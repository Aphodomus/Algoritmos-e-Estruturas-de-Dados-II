public class Celula {
    // Atributo
    public int elemento;
    public Celula prox;

    // Metodos Especiais
    public Celula() {
        this.elemento = 0;
        this.prox = null;
    }

    public Celula(int elemento) {
        this.elemento = elemento;
        this.prox = null; 
    }
}
