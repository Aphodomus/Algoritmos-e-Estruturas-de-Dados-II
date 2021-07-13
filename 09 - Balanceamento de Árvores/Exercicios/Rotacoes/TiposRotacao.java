class Rotacoes {
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

    public static No rotacaoDirEsq(No no) {
        no.dir = rotacionarDir(no.dir);
        return rotacionarEsq(no);
    }

    public static No rotacaoEsqDir(No no) {
        no.esq = rotacionarEsq(no.esq);
        return rotacionarDir(no);
    }
}

public class TiposRotacao {
    public static void main(String[] args) {

    }
}
