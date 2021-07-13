public class PilhaFlex {
    // Atributos
    public Celula topo;

    // Metodos especiais
    public PilhaFlex() {
        topo = null;
    }

    // Metodos e funcoes
    
    // Vai criar uma nova "caixinha" e fazer o topo apontar para ela
    public void inserir(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = topo;
        topo = tmp;
        tmp = null; // Tecnicamente essa linha nao precisa, pois quando sair do metodo inserir o tmp iria desaparecer de qualquer maneira
    }

    // Vai remover um elemento, e fazer o topo apontar para o proximo
    public int remover() throws Exception {
        if (topo == null) {
            throw new Exception("Erro !!! topo igual a NULL | A pilha esta vazia.");
        }

        int elemento = topo.elemento;
        Celula tmp = topo;
        topo = topo.prox;
        //Desvincular a caixinha do elemento retirado
        tmp.prox = null;
        tmp = null;

        return elemento;
    }

    // Mostrar os elementos na mesma ordem da remocao
    public void mostrar() throws Exception {
        System.out.print("[ ");
        for (Celula i = topo; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.print("]");
    }

    // Mostrar os elementos na mesma ordem da insercao
    public void mostrarOrdemInseridos() {
        System.out.print("[ ");
        int contador = 0;

        for (Celula i = topo; i != null; i = i.prox) {
            //System.out.print(i.elemento + " ");
            contador = contador + 1;
        }

        for (int i = contador; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                
            }
        }

        System.out.print("]");
    }

    // Mostrar os elementos na ordem que serao removidos RECURSIVAMENTE
    public void mostrarRecursivamente1() {
        Celula tmp = topo;
        showRecursive1(tmp);
    }

    public void showRecursive1(Celula tmp) {
        if (tmp != null) {
            System.out.println("\n" + tmp.elemento);
            showRecursive1(tmp.prox);
        }
    }

    // Mostrar os elementos na ordem que serao inseridos RECURSIVAMENTE
    public void mostrarRecursivamente2() {
        Celula tmp = topo;
        showRecursive2(tmp);
    }

    public void showRecursive2(Celula tmp) {
        if (tmp != null) {
            showRecursive2(tmp.prox);
            System.out.println("\n" + tmp.elemento);
        }
    }

    // Metodo que soma os elementos contidos na pilha
    public int somarConteudo() {
        int soma = 0;

        for (Celula i = topo; i != null; i = i.prox) {
            soma += i.elemento; // soma = soma + i.elemento
        }

        return soma;
    }

    // Metodo que soma os elementos recursivamente contidos na pilha
    public int somaRec() { // Chamada inicial do metodo recursivo
        return somaRec(topo);
    }

    public int somaRec(Celula i) {
        int resp = 0;

        if (i != null) {
            resp = i.elemento + somaRec(i.prox);
        }

        return resp;
    }

    // Metodo para retornar o maior elemento da pilha
    public int maiorElemento() {
        Celula tmp = topo;

        int maior = tmp.elemento;

        for (tmp = topo; tmp != null; tmp = tmp.prox) {
            if (tmp.elemento > maior) {
                maior = tmp.elemento;
            }
        }

        return maior;
    }

    // Metodo para retornar o maior elemento da pilha RECURSIVAMENTE
    public int maiorElementoRec() { // Chamada inicial do metodo recursivo
        return maiorElementoRec(topo);
    }

    public int maiorElementoRec(Celula tmp) {
        int maior = topo.elemento;

        if (tmp != null) {
            maior = maiorElementoRec(tmp.prox);
            if (tmp.elemento > maior) {
                maior = tmp.elemento;
            }
        }

        return maior;
    }

    // Metodo para transformar uma pilha em fila
    public Celula toFila(Celula topo) {
        Celula primeiro = new Celula();
        Celula ultimo = primeiro;
        ultimo = toFila(topo, ultimo);
        return primeiro;
    }

    public Celula toFila(Celula i, Celula ultimo) {
        if (i != null) {
            ultimo = toFila(i.prox, ultimo);
            ultimo.prox = new Celula(i.elemento);
            ultimo = ultimo.prox;
        }
        return ultimo;
    }
}
