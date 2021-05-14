class Pilha {
    // Atributos
    private int[] pilha;
    public int posicaoPilha;


    // Metodos especiais
    public Pilha() {
        this.pilha = new int[10]; // Tamanho padrao de 10 posicoes
        this.posicaoPilha = -1; // Indica que esta nula, vazia
    }

    // Metodos
    // Verificar se a pilha esta vazia
    public boolean pilhaVazia() {
        boolean resp = false;

        if (this.posicaoPilha == -1) {
            resp = true;
        }

        return resp;
    }

    // Retornar o tamanho da pilha
    public int tamanho() {
        if (this.pilhaVazia()) {
            return 0;
        }

        return this.posicaoPilha + 1;
    }

    // Retornar o ultimo valor da pilha
    public int ultimoValor() {
        // Topo
        if (this.pilhaVazia()) {
            return -1;
        }

        return this.pilha[this.posicaoPilha];
    }

    // Empilhar algum valor na pilha
    public void empilhar(int valor) {
        // Push
        if (this.posicaoPilha < this.pilha.length - 1) {
            this.pilha[++posicaoPilha] = valor;
        }
    }

    // Desempilhar algum valor da pilha
    public int desempilhar() {
        // Pop
        if (pilhaVazia()) {
            return -1;
        }
        return this.pilha[this.posicaoPilha--];
    }

    // Mostrar os valores na pilha
    public void mostrar() {
        System.out.print("[");
        for(int i = 0; i < posicaoPilha; i++) {
           System.out.print(pilha[i] + " ");
        }
        System.out.println("]");
    }
}
