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
    public void mostrar() {
        System.out.print("[ ");
        for (Celula i = topo; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.print("]");
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
        int maior = topo.elemento;
        return maiorElementoRec(topo, maior);
    }

    public int maiorElementoRec(Celula tmp, int maior) {

        if (tmp != null) {
            if (tmp.elemento > maior) {
                maior = tmp.elemento;
            }
            maiorElementoRec(tmp.prox, maior);
        }

        return maior;
    }

}
