class Hash {
    //Atributos
    public int tabela[];
    public int tamanhoTabela, tamanhoReserva, tamanhoTotal, contadorReserva;
    public int NULO = -1;

    //Metodos especiais
    public Hash() {
        this(13, 7);
    }

    public Hash(int tamanhoTabela, int tamanhoReserva) {
        this.tamanhoTabela = tamanhoTabela;
        this.tamanhoReserva = tamanhoReserva;
        this.tamanhoTotal = tamanhoTabela + tamanhoReserva;
        this.tabela = new int[this.tamanhoTotal];

        for (int i = 0; i < tamanhoTotal; i++) {
            tabela[i] = NULO;
        }

        contadorReserva = 0;
    }

    //Metodos e funcoes
    public int hash(int elemento) {
        return elemento % tamanhoTabela;
    }

    //Inserir void
    public void inserir(int elemento) throws Exception {
        int posicao = hash(elemento);

        if (elemento == NULO) {
            throw new Exception("Erro!");
        } else if (tabela[posicao] == NULO) {
            tabela[posicao] = elemento;
        } else if (contadorReserva < tamanhoReserva) {
            tabela[tamanhoReserva + contadorReserva] = elemento;
            contadorReserva++;
        } else {
            throw new Exception("Erro!");
        }
    }

    //Inserir que retorna um boolean
    public boolean inserir2(int elemento) {
        boolean resp = false;

        if (elemento != NULO) {
            int pos = hash(elemento);

            if (tabela[pos] == NULO) {
                tabela[pos] = elemento;
                resp = true;
            } else if (contadorReserva < tamanhoReserva) {
                tabela[tamanhoTabela + contadorReserva] = elemento;
                contadorReserva++;
                resp = true;
            }
        }

        return resp;
    }

    //Pesquisar
    public int pesquisar(int elemento) {
        int posicao = hash(elemento), resp = NULO;

        if (tabela[posicao] == elemento) {
            resp = posicao;
        } else if (tabela[posicao] != NULO) {
            for (int i = 0; i < tamanhoReserva; i++) {
                if (tabela[tamanhoReserva + i] == elemento) {
                    resp = tamanhoReserva + i;
                    i = tamanhoReserva;
                }
            }
        }

        return resp;
    }

    public boolean pesquisar2(int elemento) {
        boolean resp = false;

        int pos = hash(elemento);

        if (tabela[pos] == elemento) {
            resp = true;
        } else {
            for (int i = 0; i < contadorReserva; i++) {
                if (tabela[tamanhoTabela + 1] == elemento) {
                    resp = true;
                    i = contadorReserva;
                }
            }
        }

        return resp;
    }

    //Remover
    public int remover(int elemento) {
        int resp = -1;

        int pos = hash(elemento);

        if (tabela[pos] == elemento) {
            resp = tabela[pos];
            if (tabela[tamanhoTabela + contadorReserva] != 0) {
                for (int i = tamanhoTabela; i < tamanhoTotal; i++) {
                    if (pos == hash(tabela[i])) {
                        tabela[pos] = tabela[tamanhoTabela];
                        contadorReserva--;
                        tabela[tamanhoTabela] = tabela[tamanhoTabela + contadorReserva];
                        tabela[tamanhoTabela + contadorReserva] = NULO;
                    }
                }
            }
        } else if (tabela[pos] != NULO) {
            
        }

        return resp;
    }

    public void mostrar() {
        System.out.print("[");
        for (int i = 0; i < tamanhoTabela; i++) {
            System.out.print(tabela[i] + ", ");
        }
        System.out.print("] ");
        System.out.print("[");
        for (int i = tamanhoTabela; i < tamanhoTotal; i++) {
            System.out.print(tabela[i] + ", ");
        }
        System.out.print("]\n");
    }
}

public class HashOverflow {
    public static void main(String[] args) throws Exception {
        Hash hash = new Hash();

        hash.mostrar();

        hash.inserir2(5);
        hash.inserir2(1);
        hash.inserir2(6);
        hash.inserir2(7);
        hash.inserir2(8);
        hash.inserir2(2);
        hash.inserir2(13);
        hash.inserir2(13);
        hash.inserir2(13);
        hash.inserir2(13);
        hash.inserir2(13);

        hash.mostrar();

        hash.pesquisar(13);

        System.out.println(hash.pesquisar2(17));
       
    }
}
