class ReHash {
    //Atributos
    public int tabela[];
    public int tamanho;
    public int NULO = -1;

    //Metodos especiais
    public ReHash() {
        this(13);
    }

    public ReHash(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new int[this.tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = NULO;
        }
    }

    //Metodos e funcoes
    public int hash(int elemento) {
        return elemento % tamanho;
    }

    public int rehash(int elemento) {
        return ++elemento % tamanho;
    }

    public void inserir (int elemento) {
        if (elemento != NULO) {
            int posicao = hash(elemento);

            if (tabela[posicao] == NULO) {
                tabela[posicao] = elemento;
            } else {
                posicao = rehash(elemento);
                if (tabela[posicao] == NULO) {
                    tabela[posicao] = elemento;
                }
            }
        }
    }

    public boolean pesquisar (int elemento) {
        boolean resp = false;
        int posicao = hash(elemento);

        if (tabela[posicao] == elemento) {
            resp = true;
        } else {
            posicao = rehash(elemento);
            if (tabela[posicao] == NULO) {
                resp = true;
            }
        }

        return resp;
    }

    public void mostrar() {
        System.out.print("[");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(tabela[i] + ", ");
        }
        System.out.print("]\n");
    }
}

public class ReHashExample {
    public static void main(String[] args) {
        ReHash hash = new ReHash(13);

        hash.inserir(5);
        hash.inserir(2);
        hash.inserir(3);
        hash.inserir(6);
        hash.inserir(6);
        hash.inserir(7);
        hash.inserir(10);
        hash.inserir(11);

        hash.mostrar();
    }
}
