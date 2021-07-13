public class PilhaTeste {
    // Atributos
    public Celula topo;

    // Metodos especiais
    public PilhaTeste() {
        topo = new Celula();
    }

    // Metodos e funcoes
    public void inserir(int x) {
        Celula tmp = new Celula(x);
        if (topo.prox == null) {
            topo.prox = tmp;
            System.out.println("entrou");
        }
        tmp.prox = topo.prox;
        tmp = null;
    }
}
