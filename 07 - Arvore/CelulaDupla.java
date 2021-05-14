public class CelulaDupla {
    // Atributos
    public int elemento;
    public CelulaDupla prox;
    public CelulaDupla ant;

    // Metodos Especiais
    public CelulaDupla() {
        this.elemento = 0;
        this.prox = null;
        this.ant = null;
    }

    public CelulaDupla(int elemento) {
        this.elemento = elemento;
        this.prox = null;
        this.ant = null; 
    }
}
