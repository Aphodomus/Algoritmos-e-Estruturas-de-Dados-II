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
}
