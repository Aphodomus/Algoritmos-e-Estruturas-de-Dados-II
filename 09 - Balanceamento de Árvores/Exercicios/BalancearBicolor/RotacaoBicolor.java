class ArvoreBicolor {
    public void inserir(int elemento) throws Exception {

        // Se a arvore estiver vazia
        if (raiz == null) {
            raiz = new NoAN(elemento);

            // Senao, se a arvore tiver um elemento
        } else if (raiz.esq == null && raiz.dir == null) {
            if (elemento < raiz.elemento) {
                raiz.esq = new NoAN(elemento);
            } else {
                raiz.dir = new NoAN(elemento);
            }

            // Senao, se a arvore tiver dois elementos (raiz e dir)
        } else if (raiz.esq == null) {

            if (elemento < raiz.elemento) {
                raiz.esq = new NoAN(elemento);
            } else if (elemento < raiz.dir.elemento) {
                raiz.esq = new NoAN(raiz.elemento);
                raiz.elemento = elemento;
            } else {
                raiz.esq = new NoAN(raiz.elemento);
                raiz.elemento = raiz.dir.elemento;
                raiz.dir.elemento = elemento;
            }

            raiz.esq.cor = raiz.dir.cor = false;

            // Senao, se a arvore tiver dois elementos (raiz e esq)
        } else if (raiz.dir == null) {

            if (elemento > raiz.elemento) {
                raiz.dir = new NoAN(elemento);
            } else if (elemento > raiz.esq.elemento) {
                raiz.dir = new NoAN(raiz.elemento);
                raiz.elemento = elemento;
            } else {
                raiz.dir = new NoAN(raiz.elemento);
                raiz.elemento = raiz.esq.elemento;
                raiz.esq.elemento = elemento;
            }

            raiz.esq.cor = raiz.dir.cor = false;

            // Senao, a arvore tem tres ou mais elementos
        } else {
            inserir(elemento, null, null, null, raiz);
        }

        raiz.cor = false;
    }

    private void balancear(NoAN bisavo, NoAN avo, NoAN pai, NoAN i) {

        // Se o pai tambem e preto, reequilibrar a arvore, rotacionando o avo
        if (pai.cor == true) {

            // 4 tipos de reequilibrios e acoplamento
            if (pai.elemento > avo.elemento) { // rotacao a esquerda ou direita-esquerda
                if (i.elemento > pai.elemento) {
                    avo = rotacaoEsq(avo);
                } else {
                    avo = rotacaoDirEsq(avo);
                }

            } else { // rotacao a direita ou esquerda-direita
                if (i.elemento < pai.elemento) {
                    avo = rotacaoDir(avo);
                } else {
                    avo = rotacaoEsqDir(avo);
                }
            }

            if (bisavo == null) {
                raiz = avo;
            } else if (avo.elemento < bisavo.elemento) {
                bisavo.esq = avo;
            } else {
                bisavo.dir = avo;
            }

            // reestabelecer as cores apos a rotacao
            avo.cor = false;
            avo.esq.cor = avo.dir.cor = true;
        }
    }

    private void inserir(int elemento, NoAN bisavo, NoAN avo, NoAN pai, NoAN i) throws Exception {
        if (i == null) {

            if (elemento < pai.elemento) {
                i = pai.esq = new NoAN(elemento, true);
            } else {
                i = pai.dir = new NoAN(elemento, true);
            }

            if (pai.cor == true) {
                balancear(bisavo, avo, pai, i);
            }

        } else {

            // Achou um 4-no: eh preciso fragmeta-lo e reequilibrar a arvore
            if (i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true) {
                i.cor = true;
                i.esq.cor = i.dir.cor = false;
                if (i == raiz) {
                    i.cor = false;
                } else if (pai.cor == true) {
                    balancear(bisavo, avo, pai, i);
                }
            }

            if (elemento < i.elemento) {
                inserir(elemento, avo, pai, i, i.esq);
            } else if (elemento > i.elemento) {
                inserir(elemento, avo, pai, i, i.dir);
            } else {
                throw new Exception("Erro inserir (elemento repetido)!");
            }
        }
    }

    private NoAN rotacaoDir(NoAN no) {
        NoAN noEsq = no.esq;
        NoAN noEsqDir = noEsq.dir;

        noEsq.dir = no;
        no.esq = noEsqDir;

        return noEsq;
    }

    private NoAN rotacaoEsq(NoAN no) {
        NoAN noDir = no.dir;
        NoAN noDirEsq = noDir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;
        return noDir;
    }

    private NoAN rotacaoDirEsq(NoAN no) {
        no.dir = rotacaoDir(no.dir);
        return rotacaoEsq(no);
    }

    private NoAN rotacaoEsqDir(NoAN no) {
        no.esq = rotacaoEsq(no.esq);
        return rotacaoDir(no);
    }
}

public class RotacaoBicolor {
    public static void main(String[] args) {

    }
}