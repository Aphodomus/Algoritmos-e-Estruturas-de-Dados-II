public class No {
    // Atributos
    public char elemento;
    public final int tamanho = 26;
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
