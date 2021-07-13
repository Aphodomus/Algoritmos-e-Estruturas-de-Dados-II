/*
Contabilize os números de comparações e movimentações entre
elementos do array; calcule os valores teóricos para as duas métricas; e
contabilize o tempo de execução. Em seguida, para os códigos em Java e
C, gere arrays aleatórios (seed 0) com tamanhos 100, 1000 e 10000. Para
cada instância (variação de linguagem e tamanho de vetor), faça 33
execuções. Faça um gráfico para os valores médios de cada métrica
avaliada (comparações, movimentações e tempo de execução) variando o
tamanho do array. Nos gráficos de comparações e movimentações, mostre
também os resultados teóricos. Cada gráfico terá uma curva para cada
linguagem. Interprete os resultados obtidos. Repita o processo para arrays
gerados de de forma crescente e decrescente.
*/
public class unidade01dExercicio04 {
    public static void main(String[] args) {
        //Declarando variáveis
        Geracao algoritmo;
        int n = (args.length < 1) ? 100 : Integer.parseInt(args[0]);
        double inicio, fim;

        //Inicializando o algoritmo de ordenação
        algoritmo = new Selecao(n);

        //Geração do conjunto a ser ordenado
        algoritmo.aleatorio();

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
