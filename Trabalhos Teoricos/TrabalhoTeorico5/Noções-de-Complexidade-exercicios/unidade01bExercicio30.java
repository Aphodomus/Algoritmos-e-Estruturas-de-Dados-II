/* Encontre o menor valor em um array de inteiros: */

public class unidade01bExercicio30 {
    public static void main(String[] args) {
        int min = array[0];
        for (int i = 1; i < n; i++){
            if (min > array[i]){
            min = array[i];
            }
        }
    }
}


/*
 *  Qual e a operacao relevante ?
 *  A comparacao entre cada um dos elementos do array
 * 
 *  Quantas vezes ela e executada ?
 *  Supondo que temos n elementos, entao a f(x) = n - 1
 * 
 *  O nosso f(n) = n – 1 é para qual dos três casos?
 *  Igual para todos os casos, não existe variação
 * 
 * 
 * Complexidade: O(n), Ω(n) e Θ(n)
 */