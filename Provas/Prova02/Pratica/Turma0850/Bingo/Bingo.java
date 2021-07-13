import java.util.ArrayList;
import java.util.List;

class CelulaDupla {
    // Atributos
    public int elemento;
    public CelulaDupla ant;
    public CelulaDupla prox;

    // Metodos especiais
    public CelulaDupla() {

    }

    public CelulaDupla(int elemento) {
        this.elemento = elemento;
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
    public int size;

    //----------------------------------------------- Metodos especiais -------------------------------------------------------//

    public ListaDupla() {
        primeiro = new CelulaDupla();
        ultimo = primeiro;
        size = 0;
    }

    //----------------------------------------------- Funcoes e Metodos -------------------------------------------------------//

    // Inserir um elemento no inicio da lista dupla
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

    // Inserir um elemento no fim da lista dupla
    public void inserirFimListaDupla(int x) {
        int music = x;
        ultimo.prox = new CelulaDupla(x);
        ultimo.prox.ant = ultimo;
        ultimo = ultimo.prox;
        this.size++;
    }

    // Inserir um elemento em uma posicao da lista dupla
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

    // Pesquisar um elemento dentro da lista dupla e retornar ele caso encontrar
    public CelulaDupla pesquisarelementoListaDupla(int posicao) {
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
         if(i.elemento == x){
            resp = true;
            i = ultimo;
         }
        }
        return resp;
    }

    // Mostrar os elementos
    public void mostrarListaDupla() {
        for(CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
            MyIO.println(i.elemento);
        }
    }

    // Remover um elemento de uma posicao da lista dupla
    public void pesquisarRemover(int valor) throws Exception {
        CelulaDupla temp = primeiro;
        int posicao = 0;

        for (temp = primeiro; temp != null; temp = temp.prox, posicao++) {

            if (temp.elemento == valor) {
                //MyIO.println("elemento = " + temp.elemento);
                //MyIO.println("posicao = " + posicao - 1);
                removerListaDupla(posicao - 1);
                //MyIO.println("valor = " + valor);
            }
        }
    }

    public void removerListaDupla(int pos) throws Exception {
        boolean achou = false;
        int contador = 0;

        if (pos != this.size - 1) {
            CelulaDupla ant = primeiro;
            for (int i = 0; i < pos; i++) {
                ant = ant.prox;
            }

            CelulaDupla temp = ant.prox;

            temp.prox.ant = ant;
            ant.prox = temp.prox;

            this.size--;
        } else if (pos == this.size - 1) {
            removerFimListaDupla2();
        }

        
    }

    // Remover um elemento do fim da lista dupla
    public void removerFimListaDupla2() throws Exception {
        int music = 0;

        if (primeiro.equals(ultimo)) {
            throw new Exception("Erro ao remover (Lista dupla vazia) !!!");
        }

        CelulaDupla temp = ultimo;
        music = temp.elemento; // pode ter erro

        ultimo = ultimo.ant;
        ultimo.prox = null;
        this.size--;
    }

    // Remover um elemento do fim da lista dupla
    public void removerFimListaDupla() throws Exception {
        int music = 0;

        if (primeiro.equals(ultimo)) {
            throw new Exception("Erro ao remover (Lista dupla vazia) !!!");
        }

        CelulaDupla temp = ultimo;
        music = temp.elemento; // pode ter erro

        ultimo = ultimo.ant;
        ultimo.prox = null;
        this.size--;
    }
}

public class Questao3 {
    public static void main(String[] args) throws Exception {
        String string = MyIO.readLine();
        String[] corteString = string.split(" ");
        int p = 0;

        int n = Integer.parseInt(corteString[0]); //Numero de cartelas
        int k = Integer.parseInt(corteString[1]); //Numeros que a cartela contem
        int u = Integer.parseInt(corteString[2]); //Maior natural

        ListaDupla[] cartela = new ListaDupla[n];
        //List<Integer> array= new ArrayList<Integer>();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            cartela[i] = new ListaDupla();
        }

        for (int m = 0; m < n; m++) {
            String linha = MyIO.readLine();
            String[] corteLinha = linha.split(" ");

            for (int j = 0; j < k; j++) {
                cartela[m].inserirFimListaDupla(Integer.parseInt(corteLinha[j]));
            }

            linha = "";
        }

        String bingo = MyIO.readLine();
        String[] corteBingo = bingo.split(" ");
        boolean achou = false;
        
        for (int i = 0; i < corteBingo.length && achou == false; i++){
            int numero = Integer.parseInt(corteBingo[i]);

            for (int j = 0; j < n; j++) {
                cartela[j].pesquisarRemover(numero);

                if (cartela[j].size == 0) {
                    array[p] = j + 1;
                    p++;
                    achou = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (array[i] != -1) {
                MyIO.println(array[i]);
            }
        }
    }
}
