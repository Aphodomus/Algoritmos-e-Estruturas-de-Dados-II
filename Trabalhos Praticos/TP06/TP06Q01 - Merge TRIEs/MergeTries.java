class No {
    // Atributos
    public char elemento;
    public final int tamanho = 255;
    public No[] prox;
    public boolean folha;

    // Metodos especiais
    public No() {
        this(' ');
    }

    public No(char elemento) {
        this.elemento = elemento;
        prox = new No[tamanho];

        for (int i = 0; i < tamanho; i++) {
            prox[i] = null;
        }

        folha = false;
    }
}

class ArvoreTrie {
    // Atributos
    public No raiz;

    // Metodos especiais
    public ArvoreTrie() {
        raiz = new No();
    }

    // Funcoes e metodos
    public void inserir(String elemento) throws Exception {
        inserir(elemento, raiz, 0);
    }

    public void inserir(String palavra, No no, int i) throws Exception {
        if (no.prox[palavra.charAt(i)] == null) {
            //Criar no
            no.prox[palavra.charAt(i)] = new No(palavra.charAt(i));

            if (i == palavra.length() - 1) {
                //Folha
                no.prox[palavra.charAt(i)].folha = true;
            } else {
                inserir(palavra, no.prox[palavra.charAt(i)], i + 1);
            }
        } else if (no.prox[palavra.charAt(i)].folha == false && i < palavra.length() - 1) {
            inserir(palavra, no.prox[palavra.charAt(i)], i + 1);
        } else {
            throw new Exception("Erro ao tentar inserir um elemento");
        }
    }

    public boolean pesquisar(String elemento) throws Exception {
        return pesquisar(elemento, raiz, 0);
    }

    public boolean pesquisar(String palavra, No no, int i) throws Exception {
        boolean resp = false;

        if (no.prox[palavra.charAt(i)] == null) {
            resp = false;
        } else if (i == palavra.length() - 1) {
            resp = (no.prox[palavra.charAt(i)].folha == true);
        } else if (i < palavra.length() - 1) {
            resp = pesquisar(palavra, no.prox[palavra.charAt(i)], i + 1);
        } else {
            throw new Exception("Erro ao tentar fazer a pesquisa");
        }

        return resp;
    }

    public void mostrar() {
        mostrar("", raiz);
    }

    public void mostrar(String palavra, No no) {
        if (no.folha == true) {
            System.out.println("Palavra: " + (palavra + no.elemento));
        } else {
            for (int i = 0; i < no.prox.length; i++) {
                if (no.prox[i] != null) {
                    mostrar(palavra + no.elemento, no.prox[i]);
                }
            }
        }
    }

    public int contarLetrasAs() {
        int resp = 0;

        if (raiz != null) {
            resp = contarLetrasAs(raiz);
        }

        return resp;
    }

    public int contarLetrasAs(No no) {
        int resp = (no.elemento == 'A' || no.elemento == 'a') ? 1 : 0;

        if (no.folha == false) {
            for (int i = 0; i < no.prox.length; i++) {
                if (no.prox[i] != null) {
                    resp = resp + contarLetrasAs(no.prox[i]);
                }
            }
        }

        return resp;
    }

    public void mergeTries(ArvoreTrie arvore) throws Exception {
        for (int i = 0; i < raiz.tamanho; i++) {
            if (raiz.prox[i] != null) {
                char palavra = (char) (i + 'a');
                mergeTries(raiz.prox[i], "" + palavra, arvore);
            }
        }
    }

    public void mergeTries(No no, String palavra, ArvoreTrie arvore) throws Exception {
        if (no.folha == false) {
            for (int i = 0; i < no.prox.length; i++) {
                if (no.prox[i] != null) {
                    char word = (char) (i + 'a');
                    mergeTries(no.prox[i], palavra + word, arvore);
                }
            }
        } else {
            arvore.inserir(palavra);
        }
    }
}

public class MergeTries {
    public static void main(String[] args) throws Exception {
        ArvoreTrie arvore1 = new ArvoreTrie();
        ArvoreTrie arvore2 = new ArvoreTrie();

        String linha = "";

        linha = MyIO.readLine();
        while (!(linha.contains("FIM"))) {
            arvore1.inserir(linha);
            linha = MyIO.readLine();
        }

        linha = MyIO.readLine();
        while (!(linha.contains("FIM"))) {
            arvore2.inserir(linha);
            linha = MyIO.readLine();
        }

        arvore1.mostrar();
        System.out.println("---------");
        arvore2.mostrar();

        arvore2.mergeTries(arvore1);
        System.out.println("--------- depois ---------");
        arvore1.mostrar();
//
        //linha = MyIO.readLine();
        //while (!(linha.contains("FIM"))) {
        //    if (arvore1.pesquisar(linha)) {
        //        System.out.println(linha + " SIM");
        //    } else {
        //        System.out.println(linha + " NAO");
        //    }
        //    linha = MyIO.readLine();
        //}
    }
}
