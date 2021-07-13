public class FilaFlexWithoutLast {
    // Atributos
    private Celula primeiro;
    
    // Metodos especiais
    public FilaFlexWithoutLast() {
        // O primeiro vai ser "Café com leite", na verdade nao guarda elemento algum
        primeiro = new Celula();
    }

    // Funcoes e metodos
    // Inserir um elemento na fila sem o ultimo
    public void inserir(int x) {
        Celula i;
        for (i = primeiro; i.prox != null; i = i.prox);

        i.prox = new Celula(x);
        i = null;
    }

    // Remover um elemento na fila
    public int remover() throws Exception {
        // Verificar se a fila esta vazia
        if (primeiro.prox == null) {
            throw new Exception("Erro !!!");
        }

        Celula tmp = primeiro.prox;
        primeiro = tmp.prox; // Ou primeiro.prox.prox
        int elemento = tmp.elemento;
        tmp.prox = null;
        tmp = null;
        return elemento;
    }

    // Mostrar os elementos na fila
    public void mostrar() {
        System.out.print("[ ");

        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }

        System.out.print("]");
    }
}
