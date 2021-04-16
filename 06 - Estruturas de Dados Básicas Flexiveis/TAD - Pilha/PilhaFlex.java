public class PilhaFlex {
    // Atributos
    public Celula topo;

    // Metodos especiais
    public PilhaFlex() {
        topo = null;
    }

    // Metodos e funcoes
    // Vai criar uma nova "caixinha" e fazer o topo apontar para ela
    public void inserir(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = topo;
        topo = tmp;
        tmp = null; // Tecnicamente essa linha nao precisa, pois quando sair do metodo inserir o tmp iria desaparecer de qualquer maneira
    }

    // Vai remover um elemento, e fazer o topo apontar para o proximo
    public int remover() throws Exception {
        if (topo == null) {
            throw new Exception("Erro !!! topo igual a NULL | A pilha esta vazia.");
        }

        int elemento = topo.elemento;
        Celula tmp = topo;
        topo = topo.prox;
        //Desvincular a caixinha do elemento retirado
        tmp.prox = null;
        tmp = null;

        return elemento;
    }

    // Mostrar os elementos na mesma ordem da remocao
    public void mostrar() throws Exception {
        System.out.print("[ ");
        for (Celula i = topo; i != null; i = i.prox) {
            System.out.println(i.elemento + " ");
        }
        System.out.print("]");
    }
}
