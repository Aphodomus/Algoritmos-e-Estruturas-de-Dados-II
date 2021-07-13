class No {
    // Atributos
    public int elemento;
    public No esq, dir;
    public int nivel;

    // Metodos especiais
    public No(int elemento) {
        this(elemento, null, null, 1);
    }

    public No(int elemento, No esq, No dir, int nivel) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
        this.nivel = nivel;
    }

    // Funcoes e metodos
    public void setNivel() {
        this.nivel = 1 + Math.max(getNivel(esq), getNivel(dir));
    }

    public static int getNivel(No no) {
        return (no == null) ? 0 : no.nivel;
    }
}

class ArvoreAVL {
    public No inserir(int x, No i) throws Exception {

        if (i == null) {
            i = new No(x);
        } else if (x < i.elemento) {
            i.esq = inserir(x, i.esq);
        } else if (x > i.elemento) {
            i.dir = inserir(x, i.dir);
        } else {
            throw new Exception("Erro ao inserir!");
        }

        return balancear(i);
    }

    public No remover(int x, No i) throws Exception {

        if (i == null) {
            throw new Exception("Erro ao remover!");
        } else if (x < i.elemento) {
            i.esq = remover(x, i.esq);
        } else if (x > i.elemento) {
            i.dir = remover(x, i.dir);
        } else if (i.dir == null) {
            i = i.esq;
        } else if (i.esq == null) {
            i = i.dir;
        } else {
            i.esq = maiorEsq(i, i.esq);
        }

        return balancear(i);
    }

    private No maiorEsq(No i, No j) {

        if (j.dir == null) {
            i.elemento = j.elemento;
            j = j.esq;
        } else {
            j.dir = maiorEsq(i, j.dir);
        }
        return j;
    }

    public static No balancear(No no) throws Exception {
        if (no != null) {
            int fator = No.getNivel(no.dir) - no.getNivel(no.esq);

            // Se balanceada
            if (Math.abs(fator) <= 1) {
                no.setNivel();

                // Se desbalanceada para a direita
            } else if (fator == 2) {

                int fatorFilhoDir = No.getNivel(no.dir.dir) - No.getNivel(no.dir.esq);

                // Se o filho a direita tambem estiver desbalanceado
                if (fatorFilhoDir == -1) {
                    no.dir = rotacionarDir(no.dir);
                }
                no = rotacionarEsq(no);

                // Se desbalanceada para a esquerda
            } else if (fator == -2) {

                int fatorFilhoEsq = No.getNivel(no.esq.dir) - No.getNivel(no.esq.esq);

                // Se o filho a esquerda tambem estiver desbalanceado
                if (fatorFilhoEsq == 1) {
                    no.esq = rotacionarEsq(no.esq);
                }
                no = rotacionarDir(no);

            } else {
                throw new Exception(
                        "Erro no No(" + no.elemento + ") com fator de balanceamento (" + fator + ") invalido!");
            }
        }

        return no;
    }

    public static No rotacionarDir(No no) {
        No noEsq = no.esq;
        No noEsqDir = noEsq.dir;

        noEsq.dir = no;
        no.esq = noEsqDir;

        no.setNivel();
        noEsq.setNivel();

        return noEsq;
    }

    public static No rotacionarEsq(No no) {
        No noDir = no.dir;
        No noDirEsq = noDir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;

        no.setNivel();
        noDir.setNivel();
        return noDir;
    }
}

public class RotacaoAVL {
    public static void main(String[] args) {

    }
}
