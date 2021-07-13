class ArvoreBinaria {
    
    //------------------------------------------------ Atributos ---------------------------------//
    public No raiz;

    //------------------------------------------------ Metodos Especiais ---------------------------------//
    public ArvoreBinaria() {
        raiz = null;
    }

    //------------------------------------------------ Metodos e funcoes ---------------------------------//

    // Inserir um elemento na arvore
    public void inserir(int elemento) throws Exception {
        raiz = inserir(elemento, raiz);
    }

    public No inserir(int elemento, No no) throws Exception {
        if (no == null) {
            no = new No(elemento);
        } else if (elemento < no.elemento) {
            no.esq = inserir(elemento, no.esq);
        } else if (elemento > no.elemento) {
            no.dir = inserir(elemento, no.dir);
        } else {
            throw new Exception("Erro, nao pode inserir um elemento repetido");
        }

        return no;
    }

    // Inserir elemento com passagem de pai (um metodo diferente, mas faz "a mesma coisa")
    public void inserirPai(int elemento) throws Exception {
        if (raiz == null) {
            raiz = new No(elemento);
        } else if (elemento < raiz.elemento) {
            inserirPai(elemento, raiz.esq, raiz);
        } else if (elemento > raiz.elemento) {
            inserirPai(elemento, raiz.dir, raiz);
        } else {
            throw new Exception("Erro, nao pode inserir um elemento repetido");
        }
    }

    public void inserirPai(int elemento, No no, No pai) throws Exception {
        if (no == null) {
            if (elemento < pai.elemento) {
                pai.esq = new No(elemento);
            } else {
                pai.dir = new No(elemento);
            }
        } else if (elemento < no.elemento) {
            inserirPai(elemento, no.esq, no);
        } else if (elemento > no.elemento) {
            inserirPai(elemento, no.dir, no);
        } else {
            throw new Exception("Erro, nao pode inserir um elemento repetido");
        }
    }

    // Pesquisar um valor na arvore e retornar true caso encontrar
    public boolean pesquisar(int elemento) {
        return pesquisar(elemento, raiz);
    }

    public boolean pesquisar(int elemento, No no) {
        boolean resp;

        if (no == null) {
            resp = false;
        } else if (elemento == no.elemento) {
            resp = true;
        } else if (elemento < no.elemento) {
            resp = pesquisar(elemento, no.esq);
        } else {
            resp = pesquisar(elemento, no.dir);
        }

        return resp;
    }

    // Vai printar os elementos em ordem crescente
    public void caminharCentral(No no) {
        if (no != null) {
            caminharCentral(no.esq);
            System.out.println(no.elemento + " ");
            caminharCentral(no.dir);
        }
    }

    // Uma forma de caminhar pelos elementos, mas não tem uma vantagem especifica
    public void caminharPos(No no) {
        if (no != null) {
            caminharPos(no.esq);
            caminharPos(no.dir);
            System.out.println(no.elemento + " ");
        }
    }

    // Uma forma de caminhar pelos elementos, mas não tem uma vantagem especifica
    public void caminharPre(No no) {
        if (no != null) {
            System.out.println(no.elemento + " ");
            caminharPre(no.esq);
            caminharPre(no.dir);
        }
    }

    // Metodo para retornar altura da arvore
    public int getAltura() {
        int altura = 0;
        return getAltura(raiz, altura);
    }

    public int getAltura(No no, int altura) {
        if (no == null) {
            altura--;
        } else {
            int alturaEsq = getAltura(no.esq, altura + 1);
            int alturaDir = getAltura(no.dir, altura + 1);
            altura = (alturaEsq > alturaDir) ? alturaEsq : alturaDir;
        }

        return altura;
    }

    // Metodo para retornar a soma dos elementos existentes na arvore binaria
    public int soma() {
        return soma(raiz);
    }

    public int soma(No no) {
        int resp = 0;
        
        if (no != null) {
            resp = no.elemento + soma(no.esq) + soma(no.dir);
        }

        return resp;
    }

    // Metodo para retornar o numero de elementos pares existentes na arvore binaria
    public int quantidadePares() {
        return quantidadePares(raiz);
    }

    public int quantidadePares(No no) {
        int resp = 0;
        
        if (no != null) {
            resp = ((no.elemento % 2 == 0) ? 1 : 0) + quantidadePares(no.esq) + quantidadePares(no.dir);
        }

        return resp;
    }

    // Metodo estatico que recebe dois objetos arvore e retorna um booleano indicando se são iguais
    public static boolean iguais(ArvoreBinaria arvore1, ArvoreBinaria arvore2) {
        return iguais(arvore1.raiz, arvore2.raiz);
    }

    public static boolean iguais(No no1, No no2) {
        boolean resp;

        if (no1 != null && no2 != null) {
            resp = (no1.elemento == no2.elemento) && iguais(no1.esq, no2.esq) && iguais(no1.dir, no2.dir);
        } else if (no1 == null && no2 == null) {
            resp = true;
        } else {
            resp = false;
        }

        return resp;
    }

    // Metodo para retornar true caso a arvore contenha algum elemento divisivel por onze
    public boolean divisivelPor11() {
        return divisivelPor11(raiz);
    }

    public boolean divisivelPor11(No no) {
        boolean resp = false;

        if (no != null) {
            resp = (no.elemento % 11 == 0) || divisivelPor11(no.esq) || divisivelPor11(no.dir);
        }

        return resp;
    }

    // Metodo que recebe o nó cabeca de uma lista simples e outra dupla e intercala ambos os elementos em uma arvore
    public No toAB(Celula p1, CelulaDupla p2) throws Exception {
        No resp = null;
        p1 = p1.prox;
        p2 = p2.prox;

        while (p1 != null && p2 != null) {
            resp = inserir(p1.elemento, resp);
            resp = inserir(p2.elemento, resp);
            p1 = p1.prox;
            p2 = p2.prox;
        }

        while (p1 != null) {
            resp = inserir(p1.elemento, resp);
            p1 = p1.prox;
        }

        while(p2 != null) {
            resp = inserir(p2.elemento, resp);
            p2 = p2.prox;
        }

        return resp;
    }

    // Metodo para retornar o MAIOR elemento de uma arvore
    public int getMaior() {
        int resp = -1;

        if (raiz != null) {
            No i;

            //Caminha para a direita ate parar no ultimo elemento, e por ser em arvore, ele sera o maior
            for (i = raiz; i.dir != null; i = i.dir);
            resp = i.elemento;
        }

        return resp;
    }

    // Metodo para retornar o MENOR elemento de uma arvore
    public int getMenor() {
        int resp = -1;

        if (raiz != null) {
            No i;

            //Caminha para a esquerda ate parar no ultimo elemento, e por ser em arvore, ele sera o menor
            for (i = raiz; i.esq != null; i = i.esq);
            resp = i.elemento;
        }

        return resp;
    }

    // Metodo para remover um elemento da arvore, remover UM ELEMENTO que precisa existir na arvore
    public void remover(int elemento) throws Exception {
        raiz = remover(elemento, raiz);
    }

    public No remover(int elemento, No no) throws Exception {
        if (no == null) {
            throw new Exception("Erro! no nulo");
        } else if (elemento < no.elemento) {
            no.esq = remover(elemento, no.esq);
        } else if (elemento > no.elemento) {
            no.dir = remover(elemento, no.dir);
        } else if (no.dir == null) {
            no = no.esq;
        } else if (no.esq == null) {
            no = no.dir;
        } else {
            no.esq = maiorEsq(no, no.esq);
        }

        return no;
    }

    public No maiorEsq(No i, No j) {
        if (j.dir == null) {
            i.elemento = j.elemento;
            j = j.esq;
        } else {
            j.dir = maiorEsq(i, j.dir);
        }

        return j;
    }

    // Metodo para remover e retornar void
    public void remover2(int elemento) throws Exception {
        if (raiz == null) {
            throw new Exception("Erro remover2, raiz vazia");
        } else if (elemento < raiz.elemento) {
            remover2(elemento, raiz.esq, raiz);
        } else if (elemento > raiz.elemento) {
            remover2(elemento, raiz.dir, raiz);
        } else if (raiz.dir == null) {
            raiz = raiz.esq;
        } else if (raiz.esq == null) {
            raiz = raiz.dir;
        } else {
            raiz.esq = antecessor(raiz, raiz.esq);
        }
    }

    private void remover2(int elemento, No no, No pai) throws Exception {
        if (no == null) {
            throw new Exception("Erro ao remover2 ! raiz vazia");
        } else if (elemento < no.elemento) {
            remover2(elemento, no.esq, no);
        } else if (elemento > no.elemento) {
            remover2(elemento, no.dir, no);
        } else if (elemento < pai.elemento) {
            if (elemento < pai.elemento) {
                pai.esq = no.esq;
            } else {
                pai.dir = no.esq;
            }
        } else if (no.esq == null) {
            if (elemento < pai.elemento) {
                pai.esq = no.dir;
            } else {
                pai.dir = no.dir;
            }
        } else {
            no.esq = antecessor(no, no.esq);
        }
    }

    // Metodo para trocar no removido pelo antecessor
    private No antecessor(No i, No j) {
        // Existe no a direita.
        if (j.dir != null) {
           // Caminha para direita.
            j.dir = antecessor(i, j.dir);
  
        // Encontrou o maximo da subarvore esquerda.
        } else {
            i.elemento = j.elemento; // Substitui i por j.
            j = j.esq; // Substitui j por j.ESQ.
        }

        return j;
    }

    // Metodo para remove um elemento e retornar ele
    public int remover3(int elemento) throws Exception {
        No resp;
        resp = remover3(elemento, raiz);
        return resp.elemento;
    }

    public No remover3(int elemento, No no) throws Exception {
        if (no == null) {
            throw new Exception("Erro! no nulo");
        } else if (elemento < no.elemento) {
            no.esq = remover(elemento, no.esq);
        } else if (elemento > no.elemento) {
            no.dir = remover(elemento, no.dir);
        } else if (no.dir == null) {
            no = no.esq;
        } else if (no.esq == null) {
            no = no.dir;
        } else {
            no.esq = maiorEsq(no, no.esq);
        }

        return no;
    }
}


class HashArvore {
    // Atributos
    public ArvoreBinaria tabela[];
    public int tamanho;
    public int NULO = -1;

    // Metodos Especiais
    public HashArvore(int tamanho) {
        this.tamanho = tamanho;
        tabela = new ArvoreBinaria[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new ArvoreBinaria();
        }
    }

    // Metodos e Funcoes
    public int hash(int elemento) {
        return elemento % tamanho;
    }

    public void inserir(int elemento) {
        int posicao = hash(elemento);
        tabela[posicao].inserir(elemento);
    }

    public boolean pesquisar(int elemento) {
        int posicao = hash(elemento);
        return tabela[posicao].pesquisar(elemento);
    }
}
