class CelulaQuadrupla {
    // Atributos
    public int elemento;
    public CelulaQuadrupla ant;
    public CelulaQuadrupla prox;
    public CelulaQuadrupla sup;
    public CelulaQuadrupla inf;

    // Metodos Especiais
    public CelulaQuadrupla() {

    }

    public CelulaQuadrupla(int elemento) {
        this.elemento = elemento;
        this.ant = null;
        this.prox = null;
        this.sup = null;
        this.inf = null;
    }
}

class MatrizDinamica {
    static int comparisons = 0;
    static int moves = 0;

    //----------------------------------------------- Atributos -------------------------------------------------------//

    private CelulaQuadrupla inicio;
    private CelulaQuadrupla fim;
    private int size;

    //----------------------------------------------- Metodos especiais -------------------------------------------------------//

    // Construtor
    public MatrizDinamica() {
        inicio = new CelulaQuadrupla();
        fim = inicio;
        size = 0;
    }

    // Construtor
    public MatrizDinamica(int tamanho) {
        inicio = new CelulaQuadrupla();
        fim = inicio;
        this.size = tamanho;
    }

    //----------------------------------------------- Funcoes e Metodos -------------------------------------------------------//

    // Criando a matriz
    public void CriarMatriz(int tamanho) {
        CelulaQuadrupla tmp1 = fim;
        fim = inicio;

        //Criando a primeira linha, vai servir como base (crio ela de cima pra baixo)
        for (int i = 0; i < (tamanho - 1); i++) {
            fim.prox = new CelulaQuadrupla();
            fim.prox.ant = fim;
            fim = fim.prox;
        }

        //Criando o restante da matriz (parte de baixo)
        CelulaQuadrupla tmp2 = inicio;
        for (int j = 0; j < (tamanho - 1); j++) {
            tmp1.inf = new CelulaQuadrupla();
            tmp1.inf.sup = tmp1;
            tmp1 = tmp1.inf;
            tmp2 = tmp2.prox;
            for (int k = 0; k < (tamanho - 1); k++) {
                tmp1.prox = new CelulaQuadrupla();
                tmp1.prox.ant = tmp1;
                tmp1 = tmp1.prox;
                tmp2.inf = tmp1;
                tmp2.inf.sup = tmp2;
                if (tmp2.prox != null) {
                    tmp2 = tmp2.prox;
                }
            }
            //Aponta para o ultimo
            fim = tmp1;

            //Retorna para o primeiro da esquerda
            CelulaQuadrupla i;
            for (i = tmp1; i.ant != null; tmp1 = tmp1.ant, i = i.ant);
            i = null;

            //Aponta para o primeiro primeiro da esquerda
            tmp2 = tmp1;
        }

        tmp1 = null;
        tmp2 = null;

    }

    // Preenchendo a matriz com elementos
    public void PreencherMatriz(int tamanho, String musica[]) {
        //Criando a primeira linha, vai servir como base (crio ela de cima pra baixo)
        CelulaQuadrupla linha = inicio;
        CelulaQuadrupla coluna = inicio;
        int count = 0;
        int w = 0;
        MyIO.println("aqui");
        for (int j = 0; j < (tamanho); j++) {
            for (int i = 0; i < (tamanho); i++) {
                linha.elemento = Integer.parseInt(musica[w++]);
                linha = linha.prox;
            }
            coluna = coluna.inf;
            linha = coluna;
        }
        MyIO.println("aqui");
        linha = null;
        coluna = null;
    }

    // Imprimir elementos da matriz
    public void ImprimirMatriz(int tamanho) {
        //Criando a primeira linha, vai servir como base (crio ela de cima pra baixo)
        CelulaQuadrupla linha = inicio;
        CelulaQuadrupla coluna = inicio;
        int count = 0;
        
        for (int j = 0; j < (tamanho); j++) {
            for (int i = 0; i < (tamanho); i++) {
                MyIO.println("Valor = " + linha.elemento);
                linha = linha.prox;
            }
            coluna = coluna.inf;
            linha = coluna;
        }   
        linha = null;
        coluna = null;
    }
}

public class Questao01 {
    public static void main(String[] args) {
        int tamanho = MyIO.readInt();

        MatrizDinamica matriz = new MatrizDinamica();
        matriz.CriarMatriz(tamanho);


        String[] elementos = new String[tamanho * tamanho];

        for (int i = 0; i < (tamanho * tamanho); i++) {
            elementos[i] = Integer.toString(i + 1);
        }

        for (int n = 0; n < elementos.length; n++) {
            MyIO.println(elementos[n]);
        }

        matriz.PreencherMatriz(tamanho, elementos);
        //matriz.ImprimirMatriz(tamanho);
    }
}
