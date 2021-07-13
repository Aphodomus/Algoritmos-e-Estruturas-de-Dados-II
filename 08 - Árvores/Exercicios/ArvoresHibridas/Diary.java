class Celula {
    Contato contato;
    Celula prox;

    public Celula() {
        this(null, null);
    }

    public Celula(Contato contato) {
        this(contato, null);
    }

    public Celula(Contato contato, Celula prox) {
        this.contato = contato;
        this.prox = prox;
    }
}

class No {
    public char letra;
    public No esq;
    public No dir;
    public Celula primeiro, ultimo;

    public No(char letra) {
        this.letra = letra;
        this.esq = null;
        this.dir = null;
        primeiro = new Celula();
        ultimo = primeiro;
    }
}

class Contato {
    public String nome;
    public String telefone;
    public String email;
    public int cpf;

    public Contato() {
        this("", "", "", -1);
    }

    public Contato(String nome, String telefone, String email, int cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
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

    // Funcao para pesquisar por um nome dentro da estrutura
    public boolean pesquisarNome(String nome) {
        return pesquisarNome(raiz, nome);
    }

    private boolean pesquisarNome(No no, String nome) {
        boolean resp;

        if (no == null) {
            resp = false;
        } else if (Character.toUpperCase(nome.charAt(0)) == no.letra) {
            resp = false;
            
            for (Celula i = no.primeiro.prox; !resp && i != null; i = i.prox) {
                if (i.contato.nome.equals(nome) == true) {
                    resp = true;
                }
            }
        } else if (Character.toUpperCase(nome.charAt(0)) < no.letra) {
            resp = pesquisarNome(no.esq, nome);
        } else {
            resp = pesquisarNome(no.dir, nome);
        }

        return resp;
    }

    // Metodo para inserir um contato na estrutura
    public void inserir(Contato contato) throws Exception {
        if (Character.isLetter(contato.nome.charAt(0))) {
            raiz = inserir(raiz, contato);
        } else {
            throw new Exception("Erro ao inserir");
        }
    }

    private No inserir(No no, Contato contato) throws Exception {
        if (no == null) {
            no = new No(Character.toUpperCase(contato.nome.charAt(0)));
            no.ultimo.prox = new Celula(contato);
            no.ultimo = no.ultimo.prox;
        } else if (Character.toUpperCase(contato.nome.charAt(0)) == no.letra) {
            no.ultimo.prox = new Celula(contato);
            no.ultimo = no.ultimo.prox;
        } else if (Character.toUpperCase(contato.nome.charAt(0)) < no.letra) {
            no.esq = inserir(no.esq, contato);
        } else {
            no.dir = inserir(no.dir, contato);
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
            mostrarLista(no);
            mostrar(no.dir);
        }
    }

    public void mostrarLista(No no) {
        for (Celula i = no.primeiro.prox; i != null; i = i.prox) {
            System.out.println("Nome: " + i.contato.nome);
            System.out.println("CPF: " + i.contato.cpf);
            System.out.println("EMAIL: " + i.contato.email);
        }
    }
}

public class Diary {
    public static void main(String[] args) throws Exception {
        //Agenda agenda = new Agenda();
//
        //Contato c1 = new Contato("Joao", "3175258677", "joaozinho@gmail.com", 87532);
        //Contato c2 = new Contato("Carlos", "3175258677", "joaozinho@gmail.com", 87532);
        //Contato c3 = new Contato("Pedrinho", "3175258677", "joaozinho@gmail.com", 87532);
        //Contato c4 = new Contato("Omar", "3175258677", "joaozinho@gmail.com", 87532);
        //Contato c5 = new Contato("Daniel", "3175258677", "joaozinho@gmail.com", 87532);
        //Contato c6 = new Contato("Jao", "3175258677", "joaozinho@gmail.com", 87532);
        //Contato c7 = new Contato("Daniel2", "3175258677", "joaozinho@gmail.com", 87532);
        //Contato c8 = new Contato("Edu", "3175258677", "joaozinho@gmail.com", 87532);
        //Contato c9 = new Contato("Zdu", "3175258677", "joaozinho@gmail.com", 87532);
        //
        //agenda.inserir(c1);
        //agenda.inserir(c2);
        //agenda.inserir(c3);
        //agenda.inserir(c4);
        //agenda.inserir(c5);
        //agenda.inserir(c6);
        //agenda.inserir(c7);
        //agenda.inserir(c8);
        //agenda.inserir(c9);
//
        //agenda.mostrar();


    }
}
