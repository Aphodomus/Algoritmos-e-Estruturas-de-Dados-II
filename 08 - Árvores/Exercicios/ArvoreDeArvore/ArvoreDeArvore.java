class No {
    char letra;
    No esq;
    No dir;
    Arvore arvore;

    public No(char letra) {
        this.letra = letra;
        this.esq = null;
        this.dir = null;
        this.arvore = new Arvore();
    }
}

class No2 {
    String elemento;
    No2 esq;
    No2 dir;
    Arvore arvore;

    public No2(String string) {
        this.elemento = string;
        this.esq = null;
        this.dir = null;
        this.arvore = new Arvore();
    }
}

class Agenda {
    //------------------------------------------ Atributos --------------------------------------//
    public No raiz;

    //------------------------------------------ Metodos Especiais --------------------------------------//
    public Agenda () throws Exception {
        inserirInicial();
    }

    public void inserirInicial() throws Exception {
		char[] vetor = {'M', 'G', 'T', 'A', 'Z', 'I', 'P', 'Q', 'R', 'S', 'U', 'V', 'X', 'W', 'Y', 'B', 'C', 'D', 'E', 'F', 'H', 'J', 'K', 'L', 'N', 'O'};

		for (int i = 0; i < 26; i++) {
			inserirCriando(vetor[i]);
		}
	}

    public void inserirCriando(char elemento) throws Exception {
        raiz = inserirCriando(elemento, raiz);
    }

    private No inserirCriando(char elemento, No no) throws Exception {
        if (no == null) {
            no = new No(elemento);
        } else if (elemento < no.letra) {
            no.esq = inserirCriando(elemento, no.esq);
        } else if (elemento > no.letra) {
            no.dir = inserirCriando(elemento, no.dir);
        } else {
            throw new Exception("Erro, nao pode inserir um elemento repetido");
        }

        return no;
    }

    //------------------------------------------  Metodos e funcoes --------------------------------------//

    //// Funcao para pesquisar por um nome dentro da estrutura
    //public boolean pesquisarNome(String nome) {
    //    return pesquisarNome(raiz, nome);
    //}
//
    //private boolean pesquisarNome(No no, String nome) {
    //    boolean resp;
//
    //    if (no == null) {
    //        resp = false;
    //    } else if (Character.toUpperCase(nome.charAt(0)) == no.letra) {
    //        resp = false;
    //        
    //        for (Celula i = no.primeiro.prox; !resp && i != null; i = i.prox) {
    //            if (i.contato.nome.equals(nome) == true) {
    //                resp = true;
    //            }
    //        }
    //    } else if (Character.toUpperCase(nome.charAt(0)) < no.letra) {
    //        resp = pesquisarNome(no.esq, nome);
    //    } else {
    //        resp = pesquisarNome(no.dir, nome);
    //    }
//
    //    return resp;
    //}

    // Metodo para inserir um contato na estrutura
    public void inserir(String nome) throws Exception {
        if (Character.isLetter(nome.charAt(0))) {
            nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
            raiz = inserir(raiz, nome);
        } else {
            throw new Exception("Erro ao inserir");
        }
    }

    private No inserir(No no, String nome) throws Exception {
        if (nome.charAt(0) == no.letra) {
            no.arvore.inserir(nome);
        } else if (nome.charAt(0) < no.letra) {
            inserir(no.esq, nome);
        } else if (nome.charAt(0) > no.letra) {
            inserir(no.dir, nome);
        } else {
            throw new Exception("Erro ao inserir um nome");
        }

        return no;
    }

    // Metodo para remover um contato da estrutura
    public void remover(String nome) throws Exception {
        raiz = remover(nome, raiz);
    }

    public No remover(String elemento, No no) throws Exception {
        if (no == null) {
            throw new Exception("Erro, a raiz esta vazia");
        } else if (Character.toUpperCase(elemento.charAt(0)) < no.letra) {
            no.esq = remover(elemento, no.esq);
        } else if (Character.toUpperCase(elemento.charAt(0)) > no.letra) {
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
            i.letra = j.letra;
            j = j.esq;
        } else {
            j.dir = maiorEsq(i, j.dir);
        }

        return j;
    }

    // Vai printar os elementos em ordem crescente
    public void caminharCentral(No no) {
        if (no != null) {
            caminharCentral(no.esq);
            System.out.println(no.letra + " ");
            caminharCentral(no.dir);
        }
    }

    // Mostrar
    public void mostrar() throws Exception {
        mostrar(raiz);
    }

    public void mostrar(No no) throws Exception {
        if (no != null) {
            mostrar(no.esq);
            mostrarLista(no.arvore.raiz);
            mostrar(no.dir);
        }
    }

    public void mostrarLista(No2 no) {
        if (no != null) {
            mostrarLista(no.esq);
            System.out.println("Nome: " + no.elemento);
            mostrarLista(no.dir);
        }
    }
}

class Arvore {
    //------------------------------------------------ Atributos ---------------------------------//
    public No2 raiz;

    //------------------------------------------------ Metodos Especiais ---------------------------------//
    public Arvore() {
        raiz = null;
    }

    //------------------------------------------------ Metodos e funcoes ---------------------------------//

    // Inserir um elemento na arvore
    public void inserir(String elemento) throws Exception {
        raiz = inserir(elemento, raiz);
    }

    public No2 inserir(String elemento, No2 no) throws Exception {
        if (no == null) {
            no = new No2(elemento);
        } else if (elemento.compareTo(no.elemento) < 0) {
            no.esq = inserir(elemento, no.esq);
        } else if (elemento.compareTo(no.elemento) > 0) {
            no.dir = inserir(elemento, no.dir);
        } else {
            throw new Exception("Erro, nao pode inserir um elemento repetido");
        }

        return no;
    }

    //// Pesquisar um valor na arvore e retornar true caso encontrar
    //public boolean pesquisar(int elemento) {
    //    return pesquisar(elemento, raiz);
    //}
//
    //public boolean pesquisar(int elemento, No2 no) {
    //    boolean resp;
//
    //    if (no == null) {
    //        resp = false;
    //    } else if (elemento == no.elemento) {
    //        resp = true;
    //    } else if (elemento < no.elemento) {
    //        resp = pesquisar(elemento, no.esq);
    //    } else {
    //        resp = pesquisar(elemento, no.dir);
    //    }
//
    //    return resp;
    //}
//
    //// Vai printar os elementos em ordem crescente
    //public void caminharCentral(No2 no) {
    //    if (no != null) {
    //        caminharCentral(no.esq);
    //        System.out.println(no.elemento + " ");
    //        caminharCentral(no.dir);
    //    }
    //}
//
    //// Metodo para remover um elemento da arvore, remover UM ELEMENTO que precisa existir na arvore
    //public void remover(int elemento) throws Exception {
    //    raiz = remover(elemento, raiz);
    //}
//
    //public No2 remover(int elemento, No2 no) throws Exception {
    //    if (no == null) {
    //        throw new Exception("Erro! no nulo");
    //    } else if (elemento < no.elemento) {
    //        no.esq = remover(elemento, no.esq);
    //    } else if (elemento > no.elemento) {
    //        no.dir = remover(elemento, no.dir);
    //    } else if (no.dir == null) {
    //        no = no.esq;
    //    } else if (no.esq == null) {
    //        no = no.dir;
    //    } else {
    //        no.esq = maiorEsq(no, no.esq);
    //    }
//
    //    return no;
    //}
//
    //public No2 maiorEsq(No2 i, No2 j) {
    //    if (j.dir == null) {
    //        i.elemento = j.elemento;
    //        j = j.esq;
    //    } else {
    //        j.dir = maiorEsq(i, j.dir);
    //    }
//
    //    return j;
    //}
}

public class ArvoreDeArvore {
    public static void main(String[] args) throws Exception {
        Agenda agenda = new Agenda();

        agenda.inserir("Daniel");
        agenda.inserir("Gabriel");
        agenda.inserir("Joao");
        agenda.inserir("zacobe");
        agenda.inserir("Yuri");
        agenda.inserir("Pedro");
        agenda.inserir("Marcelo");

        agenda.mostrar();
    }
}
