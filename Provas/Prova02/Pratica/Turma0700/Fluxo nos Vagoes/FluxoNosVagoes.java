class CelulaDupla {
    // Atributos
    public int pessoas;
    public CelulaDupla ant;
    public CelulaDupla prox;

    // Metodos especiais
    public CelulaDupla() {

    }

    public CelulaDupla(int pessoas) {
        this.pessoas = pessoas;
        this.ant = null;
        this.prox = null;
    }

}

class ListaDupla {
    static int comparisons = 0;
    static int moves = 0;
    //----------------------------------------------- Atributos -------------------------------------------------------//

    private CelulaDupla primeiro;
    private CelulaDupla ultimo;
    private int size;

    //----------------------------------------------- Metodos especiais -------------------------------------------------------//

    public ListaDupla() {
        primeiro = new CelulaDupla();
        ultimo = primeiro;
        size = 0;
    }

    //----------------------------------------------- Funcoes e Metodos -------------------------------------------------------//

    // Inserir um pessoas no inicio da lista dupla
    public void inserirInicioListaDupla(int x) {
        int music = x;

        CelulaDupla tmp = new CelulaDupla(music);

        tmp.ant = primeiro;
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;

        if (primeiro.equals(ultimo)) {
            ultimo = tmp;
        } else {
            tmp.prox.ant = tmp;
        }

        tmp = null;

        this.size++;
    }

    // Inserir um pessoas no fim da lista dupla
    public void inserirFimListaDupla(int x) {
        int music = x;
        ultimo.prox = new CelulaDupla(x);
        ultimo.prox.ant = ultimo;
        ultimo = ultimo.prox;
        this.size++;
    }

    // Inserir um pessoas em uma posicao da lista dupla
    public void inserirListaDupla(int x, int pos) throws Exception {

        if (pos < 0 || pos > this.size) {
            throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + this.size + ") invalida!");
        } else if (pos == 0) {
            inserirInicioListaDupla(x);
        } else if (pos == this.size) {
            inserirFimListaDupla(x);
        } else {
            int music = x;

            CelulaDupla ant = primeiro;
            for (int i = 0; i < pos; i++) {
                ant = ant.prox;
            }

            CelulaDupla temp = new CelulaDupla(music);
            temp.prox = ant.prox;
            temp.prox.ant = temp;
            temp.ant = ant;
            ant.prox = temp;
            this.size++;
        }
    }

    // Pesquisar um pessoas dentro da lista dupla e retornar ele caso encontrar
    public CelulaDupla pesquisarpessoasListaDupla(int posicao) {
        CelulaDupla celula = new CelulaDupla();

        if (posicao < 0 || posicao > this.size) {
            MyIO.println("Erro !!! a posicao e menor que zero ou maior que o tamanho da lista");
            MyIO.println("posicao ("+ posicao +"/ tamanho = " + this.size +") invalida");
            return celula;
        } else if (posicao == 0) {
            comparisons = comparisons + 2;
            celula = primeiro.prox;
            return celula;
        } else if (posicao == this.size) {
            comparisons = comparisons + 3;
            celula = ultimo;
            return celula;
        } else {
            comparisons = comparisons + 3;
            CelulaDupla ant = primeiro;
            for (int i = 0; i < posicao; i++) {
                ant = ant.prox;
            }

            celula = ant;

            return celula;
        }
    }

    // Pesquisar uma musica dentro da lista dupla e retornar verdadeiro caso encontrar
    public boolean pesquisar(int x) {
        boolean resp = false;
        for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
         if(i.pessoas == x){
            resp = true;
            i = ultimo;
         }
        }
        return resp;
    }

    public void contar(int A, int B, int C, int D) {
        int pessoas = 0;
        
        CelulaDupla celula = pesquisarpessoasListaDupla(A);

        for (int i = 0; i < B; i++) {
            pessoas = pessoas + celula.pessoas;
            celula = celula.prox;
        }

        if (C <= B) {
            while (C <= B) {
                C++;
            }
        }
        celula = pesquisarpessoasListaDupla(C);

        for (int i = 0; i < D; i++) {
            pessoas = pessoas + celula.pessoas;
            celula = celula.prox;
        }

        MyIO.println(pessoas);
    }
}

public class Questao2 {

    public static void main(String[] args) throws Exception {
        ListaDupla lista = new ListaDupla();

        for (int i = 0; i < 20; i++) {
            lista.inserirInicioListaDupla(0);
        }

        String string = MyIO.readLine();
        String[] corte = string.split(" ");

        int pessoas = Integer.parseInt(corte[0]);
        int linhas = Integer.parseInt(corte[1]);

        for (int i = 0; i < linhas; i++) {
            String line = MyIO.readLine();
            String[] corteLine = line.split(" ");

            //Identifica o tipo 1
            if (corteLine[0] == "1") {
                lista.inserirListaDupla(Integer.parseInt(corteLine[2]), Integer.parseInt(corteLine[1]));
            } else {
                lista.contar(Integer.parseInt(corteLine[1]), Integer.parseInt(corteLine[2]), Integer.parseInt(corteLine[3]), Integer.parseInt(corteLine[4]));
            }
            
            line = "";
        }
    }
}
