class Lista {
    // Atributos
    private int[] array; // Pode ser de qualquer outro tipo
    private int n;

    // Metodos especiais
    public Lista() {
        this(6); // Tamanho padrao
    }

    public Lista(int tamanho) {
        array = new int[tamanho];
        n = 0;
    }

    public int[] getArray() {
        return this.array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getTamanho() {
        return this.n;
    }

    public void setTamanho(int n) {
        this.n = n;
    }

    // Metodos

    // Insere um elemento na primeira posicao da lista e move os demais elementos para o fim
    public void inserirInicio(int x) throws Exception {
        // Validar insercao
        if (n >= array.length) {
            throw new Exception("Erro ao inserir !!!");
        }

        // Levar elementos para o fim do array
        for (int i = n; i > 0; i--) {
            array[i] = array[i - 1];
        }

        // Coloca o elemento x na primeira posicao
        array[0] = x;
        n++;
    }

    // Insere um elemento na ultima posicao
    public void inserirFim(int x) throws Exception {
        // Validar insercao
        if (n >= array.length) {
            throw new Exception("Erro ao inserir !!!");
        }

        // Coloca o elemento x na ultima posicao
        array[n] = x;
        n++;
    }

    // Insere um elemento na posicao especificada e move os demais para o fim
    public void inserir(int x, int posicao) throws Exception {
        // Validar insercao
        if (n >= array.length || posicao < 0 || posicao > n) {
            throw new Exception("Erro ao inserir !!!");
        }

        // Levar elementos para o fim do array
        for(int i = n; i > posicao; i--){
            array[i] = array[i - 1];
        }

        //Colocar o elemento na posicao especificada, apos mover os demais
        array[posicao] = x;
        n++;
    }

    // Remove um elemento da primeira posicao da lista e movimenta os demais para o inicio
    public int removerInicio() throws Exception {
        // Validar remocao
        if (n == 0) {
            throw new Exception("Erro ao remover, tamanho igual a zero !!!");
        }

        //Guarda o elemento da primeira posicao em resp, e diminui o tamanho do array para sinalizar que removeu
        int resp = array[0];
        n--;

        for(int i = 0; i < n; i++){
            array[i] = array[i + 1];
        }

        return resp;
    }

    // Remove um elemento da ultima posicao
    public int removerFim() throws Exception {
        // Validar remocao
        if (n == 0) {
            throw new Exception("Erro ao remover, tamanho igual a zero !!!");
        }

        // Decrementa primeiro e depois devolve o valor
        return array[--n];
    }

    // Remove um elemento de uma posicao especifica e move os demais elementos para o inicio
    public int remover(int posicao) throws Exception {
        // Validar remocao
        if (n == 0 || posicao < 0 || posicao >= n) {
            throw new Exception("Erro ao remover !!!");
        }

        // Pega o elemento da posicao desejada e retira um do tamanho, para sinalizar que removeu
        int resp = array[posicao];
        n--;

        // Move os elementos para preencher o buraco do elemento removido
        for(int i = posicao; i < n; i++){
            array[i] = array[i + 1];
        }

        return resp;
    }

    // Mostra os elementos da lista
    public void mostrar (){
        System.out.print("[");
        for(int i = 0; i < n; i++){
           System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }

    // Procura um elemento e retorna true or false se ele existe
    public boolean pesquisar(int x) {
        boolean resp = false;

        // Faz um busca sequencial para ver se encontra o valor
        for (int i = 0; i < n && resp == false; i++) {
            resp = (array[i] == x);
        }

        return resp;
    }
}
