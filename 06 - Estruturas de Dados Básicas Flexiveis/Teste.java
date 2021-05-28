class Celula {
    // Atributos
    public int elemento;
    public Celula prox;

    // Metodos especiais
    public Celula() {
        this(0);
    }

    public Celula(int x) {
        this.elemento = x;
        this.prox = null;
    }
    
}

class  ListaSimples {
    // Atributos
    private Celula primeiro, ultimo;

    // Metodos especiais
    public  ListaSimples() {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    // Metodos es funcoes
    public boolean isFibonacciRecursivo(int i) {
        boolean resp = true;
    
        //Tem que ser diferente de null, mostrando que a lista nao esta vazia
        if (primeiro.prox != null) {
            resp = resp && isFibonacciRecursivo(i, primeiro.prox, resp);
        } else {
            resp = false;
        }
    
        return resp;
    }
    
    public boolean isFibonacciRecursivo(int i, Celula verificar, boolean resp) {
        //Tem que ser diferente de null
        if (verificar != null) {
            if (Fibonacci(i) == verificar.elemento) {
                resp = isFibonacciRecursivo(++i, verificar.prox, resp);
            } else {
                resp = false;
            }
        }
    
        return resp;
    }

    // Retorna o elemento correspondente a sequencia de fibonacci na
    public int Fibonacci(int i) {
        if (i < 2) {
            return i;
        } else {
            return Fibonacci(i - 1) + Fibonacci(i - 2);
        }
    }

    // Inserir um elemento na lista
    public void inserirFim(int x ) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }
}

public class Teste {
    public static void main(String[] args) {
        ListaSimples lista = new ListaSimples();
        lista.inserirFim(1);
        lista.inserirFim(1);
        lista.inserirFim(2);
        lista.inserirFim(3);
        System.out.println(lista.isFibonacciRecursivo(1));
    }
}
