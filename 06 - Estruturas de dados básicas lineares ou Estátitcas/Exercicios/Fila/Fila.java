class Fila {
    // Atributos
    private int[] array;
    private int primeiro;
    private int ultimo;

    // Metodos especiais
    public Fila() {
        this(6);
    }

    public Fila(int tamanho) {
        array = new int[tamanho + 1];
        primeiro = 0;
        ultimo = 0;
    }

    public int[] getArray() {
        return this.array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getPrimeiro() {
        return this.primeiro;
    }

    public void setPrimeiro(int primeiro) {
        this.primeiro = primeiro;
    }

    public int getUltimo() {
        return this.ultimo;
    }

    public void setUltimo(int ultimo) {
        this.ultimo = ultimo;
    }

    // Metodos

    //Insere um elemento na ultima posicao da fila
    public void inserir(int x) throws Exception {
        // Validar insercao
        if (((ultimo + 1) % array.length) == primeiro) {
            throw new Exception("Erro ao inserir, o primeiro nao pode ser igual ao ultimo");
        }

        // Vai inserir o elemento na ultima posicao
        array[ultimo] = x;
        ultimo = (ultimo + 1) % array.length;
    }

    //Remove um elemento da primeira posicao da fila, e movimenta os demais elementos para o inicio
    public int remover() throws Exception {
        // Validar remocao
        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover !!!");
        }

        // resp recebe o elemento na primeira posicao
        int resp = array[primeiro];
        primeiro = (primeiro + 1) % array.length;
        return resp;
    }

    // Mostrar o array
    public void mostrar() {
        System.out.print("[");

        for(int i = primeiro; i != ultimo; i = ((i + 1) % array.length)) {
            System.out.print(array[i] + " ");
        }

        System.out.println("]");
    }

    // Mostrar recursivamente
    public void mostrarRec(){
        System.out.print("[ ");
        mostrarRec(primeiro);
        System.out.println("]");
    }
  
    public void mostrarRec(int i){
        if(i != ultimo){
            System.out.print(array[i] + " ");
            mostrarRec((i + 1) % array.length);
        }
    }

    // Retornar um boolean indicando se a fila esta vazia
    public boolean isVazia() {
        return (primeiro == ultimo);
    }

    // Pesquisar um elemento e retornar verdadeiro ou falso
    public boolean pesquisar(int elemento) throws Exception {
        boolean resp = false;

        // Validar pesquisa
        if (primeiro == ultimo) {
            throw new Exception("Erro ao pesquisar !!!");
        }

        // Fazer a procura
        for (int i = primeiro; i != ultimo; i = (i + 1) % array.length) {
            if (array[i] == elemento) {
                resp = true;
            }
        }

        return resp;
    }

    // Retorna a posicao de um elemento
    public int retornaPosicao(int elemento) throws Exception {
        int resp = -1;

        // Validar pesquisa
        if (primeiro == ultimo) {
            throw new Exception("Erro ao pesquisar !!!");
        }

        // Fazer a procura
        for (int i = primeiro; i != ultimo; i = (i + 1) % array.length) {
            if (array[i] == elemento) {
                resp = i - 1;
            }
        }

        return resp;
    }
}
