//Supondo que temos uma informação extra sobre o array: que ele está ordenado. Conseguimos fazer algo mais eficiente? Como?

public class unidade01cExercicio02 {
    public static void main(String[] args) {

    }
}

// Sim, podemos pesquisar a partir da metade
// Se o elemento procurado for maior que o da metade, descartamos a primeira metade do array
// Senao, a segunda metade. Temos que repetir esse processo com a metade nao descartada ate encontrar o valor
// Esse metodo tambem e conhecido como Pesquisa Binaria
