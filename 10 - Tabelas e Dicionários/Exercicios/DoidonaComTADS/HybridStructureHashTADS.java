class Celula {
    // Atributos
    public int elemento;
    public Celula prox;

    // Metodos especiais
    public Celula() {
        this(0);
    }

    public Celula(int x) {
        this.elemento = x;
        this.prox = null;
    }
    
}

class ListaSimples {
    // Atributos
    private Celula primeiro, ultimo;

    // Metodos especiais
    public ListaSimples() {
        //O primeiro vai ser "Café com leite", na verdade nao guarda elemento algum
        primeiro = new Celula();
        ultimo = primeiro;
    }

    // Funcoes e metodos

    // Inserir um elemento na lista
    public void inserirFim(int x ) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    // Inserir um elemento no inicio
    public void inserirInicio(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        }
        tmp = null;
    }

    // Inserie em um elemento em uma posicao
    public void inserir(int x, int posicao) throws Exception {
        int tamanho = tamanho();

        if (posicao < 0 || posicao > tamanho) {
            throw new Exception("Erro !!!");
        } else if (posicao == 0) {
            inserirInicio(x);
        } else if (posicao == tamanho) {
            inserirFim(x);
        } else {
            Celula i = primeiro;

            for (int j = 0; j < posicao; j++, i = i.prox);
            
            Celula tmp = new Celula(x);
            tmp.prox = i.prox;
            i.prox = tmp;
            tmp = null;
            i = null;
        }
    }

    // Remover um elemento na lista
    public int removerInicio() throws Exception {
        // Verificar se a lista esta vazia
        if (primeiro == ultimo) {
            throw new Exception("Erro !!!");
        }

        Celula tmp = primeiro;
        primeiro = primeiro.prox; // Ou primeiro.prox.prox
        int elemento = primeiro.elemento;
        tmp.prox = null;
        tmp = null;
        
        return elemento;
    }

    // Remover do fim
    public int removerFim() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro !!!");
        }

        Celula i;
        for (i = primeiro; i.prox != ultimo; i = i.prox); 

        int elemento = ultimo.elemento;
        ultimo = i;
        i = null;
        ultimo.prox = null;
        
        return elemento;
    }
    
    // Remover um elemento de uma posicao da fila
    public int remover(int posicao) throws Exception {
        int elemento = 0;
        int tamanho = tamanho();

        if (primeiro == ultimo || posicao < 0 || posicao >= tamanho) {
            throw new Exception("Erro !!!");
        } else if (posicao == 0) {
            removerInicio();
        } else if (posicao == tamanho - 1) {
            removerFim();
        } else {
            Celula i = primeiro;

            for (int j = 0; j < posicao; j++, i = i.prox);
            
            Celula tmp = i.prox;
            elemento = tmp.elemento;
            i.prox = tmp.prox;
            tmp.prox = null;
            i = null;
            tmp = null;
        }

        return elemento;
    }

    // Mostrar os elementos na fila
    public void mostrar() {
        System.out.print("[ ");

        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }

        System.out.print("]");
    }

    // Retornar o tamanho da lista simples
    public int tamanho() {
        int contador = 0;

        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            contador++;
        }

        return contador;
    }
}

class NoAN{
    // Atributos
    public boolean cor;
    public int elemento;
    public NoAN esq, dir;

    // Metodos especiais
    public NoAN (){
        this(-1);
    }

    public NoAN (int elemento){
        this(elemento, false, null, null);
    }

    public NoAN (int elemento, boolean cor){
        this(elemento, cor, null, null);
    }

    public NoAN (int elemento, boolean cor, NoAN esq, NoAN dir){
      this.cor = cor;
      this.elemento = elemento;
      this.esq = esq;
      this.dir = dir;
    }
}

class ArvoreBicolor {
	private NoAN raiz; // Raiz da arvore.

	/**
	 * Construtor da classe.
	 */
	public ArvoreBicolor() {
		raiz = null;
	}

	/**
	 * Metodo publico iterativo para pesquisar elemento.
	 * @param elemento Elemento que sera procurado.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	public boolean pesquisar(int elemento) {
		return pesquisar(elemento, raiz);
	}

	/**
	 * Metodo privado recursivo para pesquisar elemento.
	 * @param elemento Elemento que sera procurado.
	 * @param i NoAN em analise.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	private boolean pesquisar(int elemento, NoAN i) {
      boolean resp;
		if (i == null) {
         resp = false;

      } else if (elemento == i.elemento) {
         resp = true;

      } else if (elemento < i.elemento) {
         resp = pesquisar(elemento, i.esq);

      } else {
         resp = pesquisar(elemento, i.dir);
      }
      return resp;
	}

	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void caminharCentral() {
		System.out.print("[ ");
		caminharCentral(raiz);
		System.out.println("]");
	}

	/**
	 * Metodo privado recursivo para exibir elementos.
	 * @param i NoAN em analise.
	 */
	private void caminharCentral(NoAN i) {
		if (i != null) {
			caminharCentral(i.esq); // Elementos da esquerda.
			System.out.print(i.elemento + ((i.cor) ? "(p) " : "(b) ")); // Conteudo do no.
			caminharCentral(i.dir); // Elementos da direita.
		}
	}

	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void caminharPre() {
		System.out.print("[ ");
		caminharPre(raiz);
		System.out.println("]");
	}

	/**
	 * Metodo privado recursivo para exibir elementos.
	 * @param i NoAN em analise.
	 */
	private void caminharPre(NoAN i) {
		if (i != null) {
			System.out.print(i.elemento + ((i.cor) ? "(p) " : "(b) ")); // Conteudo do no.
			caminharPre(i.esq); // Elementos da esquerda.
			caminharPre(i.dir); // Elementos da direita.
		}
	}

	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void caminharPos() {
		System.out.print("[ ");
		caminharPos(raiz);
		System.out.println("]");
	}

	/**
	 * Metodo privado recursivo para exibir elementos.
	 * @param i NoAN em analise.
	 */
	private void caminharPos(NoAN i) {
		if (i != null) {
			caminharPos(i.esq); // Elementos da esquerda.
			caminharPos(i.dir); // Elementos da direita.
			System.out.print(i.elemento + ((i.cor) ? "(p) " : "(b) ")); // Conteudo do no.
		}
	}


	/**
	 * Metodo publico iterativo para inserir elemento.
	 * @param elemento Elemento a ser inserido.
	 * @throws Exception Se o elemento existir.
	 */
	public void inserir(int elemento) throws Exception {
   
      //Se a arvore estiver vazia
      if(raiz == null){
         raiz = new NoAN(elemento, false);
         System.out.println("Antes, zero elementos. Agora, raiz(" + raiz.elemento + ").");

      //Senao, se a arvore tiver um elemento 
      } else if (raiz.esq == null && raiz.dir == null){
         if (raiz.elemento > elemento){
            raiz.esq = new NoAN(elemento, true);
            System.out.println("Antes, um elemento. Agora, raiz(" + raiz.elemento + ") e esq(" + raiz.esq.elemento +").");
         } else {
            raiz.dir = new NoAN(elemento, true);
            System.out.println("Antes, um elemento. Agora, raiz(" + raiz.elemento + ") e dir(" + raiz.dir.elemento +").");
         }

      //Senao, se a arvore tiver dois elementos (raiz e dir)
      } else if (raiz.esq == null){

         if(raiz.elemento > elemento){
            raiz.esq = new NoAN(elemento);
            System.out.println("Antes, dois elementos(A). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");

         } else if (raiz.dir.elemento > elemento){
            raiz.esq = new NoAN(raiz.elemento);
            raiz.elemento = elemento;
            System.out.println("Antes, dois elementos(B). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");

         } else {
            raiz.esq = new NoAN(raiz.elemento);
            raiz.elemento = raiz.dir.elemento;
            raiz.dir.elemento = elemento;
            System.out.println("Antes, dois elementos(C). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
         }

         raiz.esq.cor = raiz.dir.cor = false;
         
      //Senao, se a arvore tiver dois elementos (raiz e esq)
      } else if (raiz.dir == null){
         
         if(raiz.elemento < elemento){
            raiz.dir = new NoAN(elemento);
            System.out.println("Antes, dois elementos(D). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
         } else if (raiz.esq.elemento < elemento){
            raiz.dir = new NoAN(raiz.elemento);
            raiz.elemento = elemento;
            System.out.println("Antes, dois elementos(E). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
         } else {
            raiz.dir = new NoAN(raiz.elemento);
            raiz.elemento = raiz.esq.elemento;
            raiz.esq.elemento = elemento;
            System.out.println("Antes, dois elementos(F). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
         }

         raiz.esq.cor = raiz.dir.cor = false;

      //Senao, a arvore tem tres ou mais elementos
      } else {
         System.out.println("Arvore com tres ou mais elementos...");
		   inserir(elemento, null, null, null, raiz);
      }

      raiz.cor = false;
   }

   private void balancear(NoAN bisavo, NoAN avo, NoAN pai, NoAN i){

      //Se o pai tambem e preto, reequilibrar a arvore, rotacionando o avo
      if(pai.cor == true){

         //4 tipos de reequilibrios e acoplamento
         if(pai.elemento > avo.elemento){ // rotacao a esquerda ou direita-esquerda
            if(i.elemento > pai.elemento){
               avo = rotacaoEsq(avo);
            } else {
               avo = rotacaoDirEsq(avo);
            }

         } else { // rotacao a direita ou esquerda-direita
            if(i.elemento < pai.elemento){
               avo = rotacaoDir(avo);
            } else {
               avo = rotacaoEsqDir(avo);
            }
         }

         if (bisavo == null){
            raiz = avo;
         } else if(avo.elemento < bisavo.elemento){
            bisavo.esq = avo;
         } else {
            bisavo.dir = avo;
         }

         //reestabelecer as cores apos a rotacao
         avo.cor = false;
         avo.esq.cor = avo.dir.cor = true;
         System.out.println("Reestabeler cores: avo(" + avo.elemento + "->branco) e avo.esq / avo.dir(" + avo.esq.elemento + "," + avo.dir.elemento + "-> pretos)");
      } //if(pai.cor == true)
   }

	/**
	 * Metodo privado recursivo para inserir elemento.
	 * @param elemento Elemento a ser inserido.
	 * @param avo NoAN em analise.
	 * @param pai NoAN em analise.
	 * @param i NoAN em analise.
	 * @throws Exception Se o elemento existir.
	 */
	private void inserir(int elemento, NoAN bisavo, NoAN avo, NoAN pai, NoAN i) throws Exception {
		if (i == null) {

         if(elemento < pai.elemento){
            i = pai.esq = new NoAN(elemento, true);
         } else {
            i = pai.dir = new NoAN(elemento, true);
         }

         if(pai.cor == true){
            balancear(bisavo, avo, pai, i);
         }

      } else {

        //Achou um 4-no: eh preciso fragmeta-lo e reequilibrar a arvore
         if(i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true){
            i.cor = true;
            i.esq.cor = i.dir.cor = false;
            if(i == raiz){
               i.cor = false;
            }else if(pai.cor == true){
               balancear(bisavo, avo, pai, i);
            }
         }

         if (elemento < i.elemento) {
            inserir(elemento, avo, pai, i, i.esq);
         } else if (elemento > i.elemento) {
            inserir(elemento, avo, pai, i, i.dir);
         } else {
            throw new Exception("Erro inserir (elemento repetido)!");
         }
      }
	}

   private NoAN rotacaoDir(NoAN no) {
      System.out.println("Rotacao DIR(" + no.elemento + ")");
      NoAN noEsq = no.esq;
      NoAN noEsqDir = noEsq.dir;

      noEsq.dir = no;
      no.esq = noEsqDir;

      return noEsq;
   }

   private NoAN rotacaoEsq(NoAN no) {
      System.out.println("Rotacao ESQ(" + no.elemento + ")");
      NoAN noDir = no.dir;
      NoAN noDirEsq = noDir.esq;

      noDir.esq = no;
      no.dir = noDirEsq;
      return noDir;
   }

   private NoAN rotacaoDirEsq(NoAN no) {
      no.dir = rotacaoDir(no.dir);
      return rotacaoEsq(no);
   }

   private NoAN rotacaoEsqDir(NoAN no) {
      no.esq = rotacaoEsq(no.esq);
      return rotacaoDir(no);
   }
}

class Hash {
    //Atributos
    public int tamanhoTabela;
    public int tabela[];
    public int NULO = -0x7FFFFF;
    public ArvoreBicolor arvore;

    //Metodos especiais
    public Hash() {
        tabela = new int[10];
        this.tamanhoTabela = 10;
        
        for (int i = 0; i < 10; i++) {
            tabela[i] = NULO;
        }

        arvore = new ArvoreBicolor();
    }

    public Hash(int tamanho) {
        tabela = new int[tamanho];
        this.tamanhoTabela = tamanho;
        
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = NULO;
        }

        arvore = new ArvoreBicolor();
    }

    public int hash(int elemento) {
        return elemento % tamanhoTabela;
    }

    public int rehash(int elemento) {
        return ++elemento % tamanhoTabela;
    }

    public void inserir(int elemento) throws Exception {
        if (elemento != NULO) {
            int posicao = hash(elemento);

            if (tabela[posicao] == NULO) {
                tabela[posicao] = elemento;
            } else {
                posicao = rehash(elemento);

                if (tabela[posicao] == NULO) {
                    tabela[posicao] = elemento;
                } else {
                    arvore.inserir(elemento);
                }
            }
        }
    }

    public boolean pesquisar(int elemento) {
        boolean resp = false;

        int posicao = hash(elemento);

        if (tabela[posicao] == elemento) {
            resp = true;
        } else {
            posicao = rehash(elemento);

            if (tabela[posicao] == elemento) {
                resp = true;
            } else {
                resp = arvore.pesquisar(elemento);
            }
        }

        return resp;
    }
}

class Doidona {
    //Atributos
    public int tamanhoT1;
    public int NULO = -0x7FFFFF;
    public int[] t1;
    public Hash hash;
    public ListaSimples lista;
    public ArvoreBicolor arvore;

    //Metodos especiais
    public Doidona() {
        this.t1 = new int[10];
        this.tamanhoT1 = 10;

        for (int i = 0; i < 10; i++) {
            this.t1[i] = NULO;
        }

        arvore = new ArvoreBicolor();
        lista = new ListaSimples();
        hash = new Hash(10);
    }

    //Metodos especiais
    public Doidona(int tamT1, int tamT3) {
        this.t1 = new int[tamT1];
        this.tamanhoT1 = tamT1;

        for (int i = 0; i < tamT1; i++) {
            this.t1[i] = NULO;
        }

        arvore = new ArvoreBicolor();
        lista = new ListaSimples();
        hash = new Hash(tamT3);
    }

    public int hashT1(int elemento) {
        return elemento % tamanhoT1;
    }

    public int hashT2(int elemento) {
        return elemento % 3;
    }

    public void inserir(int elemento) throws Exception {

        if (elemento != NULO) {
            int posicao = hashT1(elemento);

            if (t1[posicao] == NULO) {
                t1[posicao] = elemento;
            } else {
                posicao = hashT2(elemento);

                if (posicao == 0) { //Inserir na outra tabela hash
                    hash.inserir(elemento);
                } else if (posicao == 1) { //Inserir na lista simples
                    lista.inserirFim(elemento);
                } else { //Inserir na arvore
                    arvore.inserir(elemento);
                }
            }
        }
    }
}

public class HybridStructureHash {
    public static void main(String[] args) throws Exception {
        Doidona doidona = new Doidona(13, 10);

        doidona.inserir(3);
        doidona.inserir(3);
        doidona.inserir(3);
        doidona.inserir(4);
        doidona.inserir(8);
        doidona.inserir(6);
        doidona.inserir(6);
        doidona.inserir(6);
    }
}