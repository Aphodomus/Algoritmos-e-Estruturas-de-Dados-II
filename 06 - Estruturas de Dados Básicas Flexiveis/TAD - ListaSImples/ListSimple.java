public class ListSimple {
    // Atributos
    private Celula primeiro, ultimo;

    // Metodos especiais
    public ListSimple() {
        //O primeiro vai ser "Café com leite", na verdade nao guarda elemento algum
        primeiro = new Celula();
        ultimo = primeiro;
    }

    // Funcoes e metodos

    // Inserir um elemento na lista
    public void inserirFim(int x ) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    // Inserir um elemento no inicio
    public void inserirInicio(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        }
        tmp = null;
    }

    // Inserie em um elemento em uma posicao
    public void inserir(int x, int posicao) throws Exception {
        int tamanho = tamanho();

        if (posicao < 0 || posicao > tamanho) {
            throw new Exception("Erro !!!");
        } else if (posicao == 0) {
            inserirInicio(x);
        } else if (posicao == tamanho) {
            inserirFim(x);
        } else {
            Celula i = primeiro;

            for (int j = 0; j < posicao; j++, i = i.prox);
            
            Celula tmp = new Celula(x);
            tmp.prox = i.prox;
            i.prox = tmp;
            tmp = null;
            i = null;
        }
    }

    // Remover um elemento na lista
    public int removerInicio() throws Exception {
        // Verificar se a lista esta vazia
        if (primeiro == ultimo) {
            throw new Exception("Erro !!!");
        }

        Celula tmp = primeiro;
        primeiro = primeiro.prox; // Ou primeiro.prox.prox
        int elemento = primeiro.elemento;
        tmp.prox = null;
        tmp = null;
        
        return elemento;
    }

    // Remover do fim
    public int removerFim() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro !!!");
        }

        Celula i;
        for (i = primeiro; i.prox != ultimo; i = i.prox); 

        int elemento = ultimo.elemento;
        ultimo = i;
        i = null;
        ultimo.prox = null;
        
        return elemento;
    }
    
    // Remover um elemento de uma posicao da fila
    public int remover(int posicao) throws Exception {
        int elemento = 0;
        int tamanho = tamanho();

        if (primeiro == ultimo || posicao < 0 || posicao >= tamanho) {
            throw new Exception("Erro !!!");
        } else if (posicao == 0) {
            removerInicio();
        } else if (posicao == tamanho - 1) {
            removerFim();
        } else {
            Celula i = primeiro;

            for (int j = 0; j < posicao; j++, i = i.prox);
            
            Celula tmp = i.prox;
            elemento = tmp.elemento;
            i.prox = tmp.prox;
            tmp.prox = null;
            i = null;
            tmp = null;
        }

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

    // Retornar o tamanho da lista simples
    public int tamanho() {
        int contador = 0;

        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            contador++;
        }

        return contador;
    }
}
