class CelulaDupla {
    // Atributos
    public int elemento;
    public CelulaDupla prox;
    public CelulaDupla inf;

    // Metodos especiais
    public CelulaDupla() {
        this.elemento = 0;
        this.prox = null;
        this.inf = null;
    }

    public CelulaDupla(int elemento) {
        this.elemento = elemento;
        this.prox = null;
        this.inf = null;
    }
}

class Celula {
    // Atributos
    public int elemento;
    public Celula prox;

    // Metodos especiais
    public Celula() {
        this.elemento = 0;
        this.prox = null;
    }

    public Celula(int x) {
        this.elemento = x;
        this.prox = null;
    }
    
}

class PilhaFlex {
    // Atributos
    public CelulaDupla topo;

    // Metodos especiais
    public PilhaFlex() {
        topo = null;
    }

    public PilhaFlex(int tamanho) {
        for (int i = 0; i < tamanho; i++) {
            CelulaDupla tmp = new CelulaDupla();
            tmp.inf = topo;
            topo = tmp;
            tmp = null;
        }
    }

    // Metodos e funcoes
    // Retorna o topo da pilha
    public CelulaDupla retornarTopo() {
        return this.topo;
    }
}

class Colar {
    //Atributos
    private CelulaDupla primeiro;
    private CelulaDupla ultimo;

    //Metodos Especiais
    public Colar(int m, int n) {
        primeiro = new CelulaDupla();
        PilhaFlex pilha = new PilhaFlex(n - 1);
        CelulaDupla topo = pilha.retornarTopo();
        primeiro.inf = topo;
        topo = null;

        ultimo = primeiro;
        for (int i = 0; i < m - 1; i++) { 
            CelulaDupla tmp = new CelulaDupla();
            ultimo.prox = tmp;
            pilha = new PilhaFlex(n - 1);
            topo = pilha.retornarTopo();
            tmp.inf = topo;
            ultimo = tmp;
            tmp = null;
            topo = null;
            pilha = null;
        }           
    }
}

public class Exercicio {
    public static void main(String[] args) {
        Colar colar = new Colar(5, 5);
    }
}
