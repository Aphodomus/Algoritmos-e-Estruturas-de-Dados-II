//  Calcule o número de multiplicações que o código abaixo realiza:

public class unidade01bExercicio17 {
    public static void main(String[] args) {
        for (int i = n; i > 0; i /= 2) {
            a *= 2;
        }
    }
}

/**
 * O código acima realiza log2(n) + 1 multiplicações, se o n for uma potencia de 2;
 * Caso contrário, para um valor qualquer de n, temos o PISO do log2(x) + 1 multiplicações
 * 
 * Complexidade: O(log2(n)), Ω(log2(n)) e Θ(log2(n))
 */
