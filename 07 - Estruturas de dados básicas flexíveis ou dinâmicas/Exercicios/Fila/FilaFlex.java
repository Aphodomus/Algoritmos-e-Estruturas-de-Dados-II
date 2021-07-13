public class FilaFlex {
    // Atributos
    private Celula primeiro, ultimo;

    // Metodos especiais
    public FilaFlex() {
        //O primeiro vai ser "Café com leite", na verdade nao guarda elemento algum
        primeiro = new Celula();
        ultimo = primeiro;
    }

    // Funcoes e metodos
    // Inserir um elemento na fila
    public void inserir(int x ) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    // Remover um elemento na fila
    public int remover() throws Exception {
        // Verificar se a fila esta vazia
        if (primeiro == ultimo) {
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

    // Mostrar o maior elemento da fila
    public int maiorElemento() throws Exception {
        int maior = -1;

        if (primeiro != ultimo) {
            maior = primeiro.prox.elemento;

            for (Celula i = primeiro.prox; i != null; i = i.prox) {
                if (i.elemento > maior) {
                    maior = i.elemento;
                }
            }
        } else {
            throw new Exception("Erro !!! Fila vazia");
        }

        return maior;
    }

    // Mostrar o terceiro elemento da fila, suponto que ele exista
    public int mostrarTerceiro() {
        return (primeiro.prox.prox.prox.elemento);
    }

    // Fazer a soma dos elementos e retorna-la
    public int soma() throws Exception {
        int soma = 0;

        if (primeiro != ultimo) {
            for (Celula i = primeiro.prox; i != null; i = i.prox) {
                soma += i.elemento;
            }
        } else {
            throw new Exception("Erro !!! Fila vazia");
        }

        return soma;
    }

    // Inverter a ordem dos elementos
    public void inverter() {
        Celula fim = ultimo;

        while (primeiro != fim) {
            Celula nova = new Celula(primeiro.prox.elemento);
            nova.prox = fim.prox;
            fim.prox = nova;
            Celula tmp = primeiro.prox;
            primeiro.prox = tmp.prox;
            nova = null;
            tmp.prox = null;
            tmp = null;
            if (ultimo == fim) {
                ultimo = ultimo.prox;
            }
        }

        fim = null;
    }

    // Contar elementos pares e multiplos de cinco na fila RECURSIVAMENTE
    public int contar() {
        return contar(primeiro.prox);
    }

    public int contar(Celula i) {
        int resp;

        if (i == null) {
            resp = 0;
        } else if (i.elemento % 2 == 0 && i.elemento % 5 == 0) {
            resp = 1 + contar(i.prox);
        } else {
            resp = contar(i.prox);
        }
        
        return resp;
    }
}
