class Celula {
    public int elemento;
    public Celula prox;

    public Celula() {
        this.elemento = 0;
        this.prox = null;
    }

    public Celula(int elemento) {
        this.elemento = elemento;
        this.prox = null;
    }
}

class FilaCircular {
    private Celula primeiro;
    private Celula ultimo;

    public FilaCircular() {
        //O primeiro vai ser "Café com leite", na verdade nao guarda elemento algum
        primeiro = new Celula();
        ultimo = primeiro;
    }

    // Inserir um elemento na fila
    public void inserir(int x ) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
        ultimo.prox = primeiro;
    }

    // Remover um elemento na fila
    public int remover() throws Exception {
        // Verificar se a fila esta vazia
        if (primeiro == ultimo) {
            throw new Exception("Erro !!!");
        }

        Celula tmp = primeiro;
        primeiro = tmp.prox;
        int elemento = tmp.elemento;
        tmp.prox = null;
        tmp = null;
        ultimo.prox = primeiro;
        
        return elemento;
    }

    // Mostrar os elementos na fila
    public void mostrar() {
        System.out.print("[ ");

        for (Celula i = primeiro.prox; i != ultimo.prox; i = i.prox) {
            System.out.print(i.elemento + " ");
        }

        System.out.print("]");
    }

    // separar duas filas, uma recebendo pares e outra impares
    public void separar(FilaCircular f1, FilaCircular f2) throws Exception {
        // Variavel temporaria para armazenar f1 e f2
        FilaCircular tmp = new FilaCircular();

        //loop para percorrer f2 e inserir todos os elementos dele em uma variavel auxiliar
        for (Celula i = f2.primeiro.prox; i != f2.ultimo.prox; i = i.prox) {
            //Inserir o elemento
            tmp.ultimo.prox = new Celula(i.elemento);
            tmp.ultimo = tmp.ultimo.prox;
            tmp.ultimo.prox = tmp.primeiro;

            //Remover o elemento
            if (f2.primeiro == f2.ultimo) {
                throw new Exception("Erro !!! Primeiro igual ao ultimo");
            }

            Celula aux = f2.primeiro;
            f2.primeiro = aux.prox;
            aux.prox = null;
            aux = null;
            f2.ultimo.prox = f2.primeiro;
        }

        //loop para percorrer f1 e inserir todos os elementos dele em uma variavel auxiliar
        for (Celula i = f1.primeiro.prox; i != f1.ultimo.prox; i = i.prox) {
            //Inserir o elemento
            tmp.ultimo.prox = new Celula(i.elemento);
            tmp.ultimo = tmp.ultimo.prox;
            tmp.ultimo.prox = tmp.primeiro;

            //Remover o elemento
            if (f1.primeiro == f1.ultimo) {
                throw new Exception("Erro !!! Primeiro igual ao ultimo");
            }

            Celula aux = f1.primeiro;
            f1.primeiro = aux.prox;
            aux.prox = null;
            aux = null;
            f1.ultimo.prox = f1.primeiro;
        }

        //loop para percorrer a lista com todos os elementos e separar os pares para f2 e impares para f1
        for (Celula i = tmp.primeiro.prox; i != tmp.ultimo.prox; i = i.prox) {
            if (i.elemento % 2 == 0) {
                //Inserir elemento par
                f2.ultimo.prox = new Celula(i.elemento);
                f2.ultimo = f2.ultimo.prox;
                f2.ultimo.prox = f2.primeiro;
            } else {
                //Inserir elemento impar
                f1.ultimo.prox = new Celula(i.elemento);
                f1.ultimo = f1.ultimo.prox;
                f1.ultimo.prox = f1.primeiro;
            }
        }
    }
}

public class Exercicio {
    public static void main(String[] args) throws Exception {
        FilaCircular f1 = new FilaCircular();
        FilaCircular f2 = new FilaCircular();

        
        f1.inserir(4);
        f1.inserir(1);
        f1.inserir(5);
        f1.inserir(6);
        f1.inserir(9);
        f1.inserir(8);
        f1.inserir(7);
        f1.inserir(0);

        f2.inserir(3);
        f2.inserir(2);
        f2.inserir(4);
        f2.inserir(1);
        f2.inserir(5);
        f2.inserir(6);
        f2.inserir(9);
        f2.inserir(8);
        f2.inserir(7);
        f2.inserir(0);

        System.out.println("f1 antes:");
        f1.mostrar();
        System.out.println("\nf2 antes:");
        f2.mostrar();

        f1.separar(f1, f2);

        System.out.println("\n\nf1 DEPOIS:");
        f1.mostrar();
        System.out.println("\nf2 DEPOIS:");
        f2.mostrar();
    }
}