class Principal {
    public static void main(String[] args) {
        Geracao algoritmo;
        int n = (args.length < 1) ? 1000 : Integer.parseInt(args[0]);

        double inicio, fim;

        //Inicialização do algoritmo de ordenação
        //algoritmo = new Bolha(n);
        //algoritmo = new Countingsort(n);
        //algoritmo = new Heapsort(n);
        //algoritmo = new Insercao(n);
        //algoritmo = new Mergesort(n);
        //algoritmo = new Quicksort(n);
        algoritmo = new Selecao(n);
        //algoritmo = new Shellsort(n);

        //Geração do conjunto a ser ordenado
        algoritmo.aleatorio();
        //algoritmo.crescente();
        //algoritmo.decrescente();

        //Mostrar o conjunto a ser ordenado
        //algoritmo.mostrar();

        //Execução do algoritmo de ordenação
        inicio = algoritmo.now();
        algoritmo.sort();
        fim = algoritmo.now();

        //Mostrar o conjunto ordenado, tempo de execucao e status da ordenacao
        //algoritmo.mostrar();
        System.out.println("Tempo para ordenar: " + (fim - inicio)/1000.0 + " s.");
        System.out.println("isOrdenado: " + algoritmo.isOrdenado());
    }
}
