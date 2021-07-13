class Selecao extends Geracao {
    //Metodos especiais
    public Selecao() {
        super(); //e o construtor da superclasse pai
    }

    public Selecao(int tamanho) {
        super(tamanho);
    }

    //Metodos
    @Override //Facultativo, porem uma boa pratica
    public void sort() {
        for(int i = 0; i < (n - 1); i++) {
            int menor = i;
            for (int j = (i + 1); j < n; j++) {
                if (array[menor] > array[j]) {
                    menor = j;
                }
            }
            swap(menor, i);
        }
    }
}
