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

class No{
    // Atributos
    public int elemento;
    public No esq;
    public No dir;

    // Metodos especiais
    public No() {
        this.elemento = 0;
        this.esq = null;
        this.dir = null;
    }

    public No(int elemento) {
        this.elemento = elemento;
        this.esq = null;
        this.dir = null;
    }

    public No(int elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}

class Doidona {
    //Atributos
    public int tamanhoT1;
    public int tamanhoT2;
    public int NULO = -0x7FFFFF;
    public int[] t1;
    public int[] t2;
    public Celula primeiro, ultimo;
    public No raizArvore1, raizArvore2;

    //Metodos especiais
    public Doidona() {
        this.t1 = new int[10];
        this.t2 = new int[10];
        this.tamanhoT1 = 10;
        this.tamanhoT2 = 10;

        for (int i = 0; i < 10; i++) {
            this.t1[i] = NULO;
        }

        for (int i = 0; i < 10; i++) {
            this.t2[i] = NULO;
        }

        primeiro = new Celula();
        ultimo = primeiro;

        raizArvore1 = null;
        raizArvore2 = null;
    }

    //Metodos especiais
    public Doidona(int tamT1, int tamT2) {
        this.t1 = new int[tamT1];
        this.t2 = new int[tamT2];
        this.tamanhoT1 = tamT1;
        this.tamanhoT2 = tamT2

        for (int i = 0; i < tamT1; i++) {
            this.t1[i] = NULO;
        }

        for (int i = 0; i < tamT2; i++) {
            this.t2[i] = NULO;
        }

        primeiro = new Celula();
        ultimo = primeiro;

        raizArvore1 = null;
        raizArvore2 = null;
    }

    public int hashT1(int elemento) {
        return elemento % tamanhoT1;
    }

    public int hashT2(int elemento) {
        return elemento % tamanhoT2;
    }

    public int rehashT1(int elemento) {
        return elemento % 3;
    }

    public int rehashT2(int elemento) {
        return ++elemento % tamanhoT2;
    }

    public void inserir(int elemento) throws Exception {

        if (elemento != NULO) {
            int posicao = hashT1(elemento);

            if (t1[posicao] == NULO) {
                t1[posicao] = elemento;
            } else {
                posicao = rehashT1(elemento);

                if (posicao == 0) { //Inserir na outra tabela hash
                    inserirHash(elemento);
                } else if (posicao == 1) { //Inserir na lista simples
                    inserirLista(elemento);
                } else { //Inserir na arvore
                    raizArvore1 = inserirArvore(elemento, raizArvore1);
                }
            }
        }
    }

    public void inserirHash(int elemento) {
        if (elemento != NULO) {
            int posicao = hashT2(elemento);

            if (t2[posicao] == NULO) {
                t2[posicao] = elemento;
            } else {
                posicao = rehashT2(elemento);

                if (t2[posicao] == NULO) {
                    t2[posicao] = elemento;
                } else {
                    raizArvore2 = inserirArvore(elemento, raizArvore2);
                }
            }
        }
    }

    public void inserirLista(int x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public No inserirArvore(int elemento, No no) {
        if (no == null) {
            no = new No(elemento);
        } else if (no.elemento < elemento) {
            no.esq = inserirArvore(elemento, no.esq);
        } else if (no.elemento > elemento) {
            no.dir = inserirArvore(elemento, no.dir);
        } else {
            System.out.println("Erro de Insercao");
        }

        return no;
    }

    public boolean pesquisar(int elemento) {
        boolean resp = false;
        int posicao = hashT1(elemento);

        if (t1[posicao] == NULO) {
            return resp;
        } else if (t1[posicao] == elemento) {
            resp = true;
        } else if (rehashT1(elemento) == 0) {
            resp = pesquisarHash(elemento);
        } else if (rehashT1(elemento) == 1) {
            resp = pesquisarLista(elemento);
        } else if (rehashT1(elemento) == 2) {
            resp = pesquisarArvore(elemento, raizArvore1);
        } else {
            System.out.println("ERRO!!!!");
        }

        return resp;
    }

    public boolean pesquisarHash(int elemento) {
        boolean resp = false;
        int posicao = hashT2(elemento)

        if (t2[posicao] == NULO) {
            resp = false;
            return resp;
        } else if (t2[posicao] == elemento) {
            resp = true;
        } else {
            posicao = rehashT2(elemento);

            if (t2[posicao] == NULO) {
                resp = false;
            } else if (t2[posicao] == elemento) {
                resp = true;
            } else {
                resp = pesquisarArvore(elemento, raizArvore2);
            }
        }

        return resp;
    }

    public boolean pesquisarLista(int elemento) {
        boolean resp = false;

        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            if (i.elemento == elemento) {
                resp = true;
                i = ultimo;
            }
        }

        return resp;
    }

    public boolean pesquisarArvore(int elemento, No no) {
        boolean resp;

        if(no == null){
            resp = false;
        } else if (no.elemento < elemento){
            resp = pesquisarArvore(no.esq, elemento);
        } else if (no.elemento > elemento){
            resp = pesquisarArvore(no.dir, elemento);
        } else {
            resp = true;
        }

        return resp;
    }
}

public class HybridStructureHashTADS {
    public static void main(String[] args) throws Exception {
        Doidona doidona = new Doidona(13, 10);

        doidona.inserir(3);
        doidona.inserir(3);
        doidona.inserir(3);
        doidona.inserir(4);
        doidona.inserir(8);
        doidona.inserir(6);
        doidona.inserir(6);
        doidona.inserir(6);
    }
}