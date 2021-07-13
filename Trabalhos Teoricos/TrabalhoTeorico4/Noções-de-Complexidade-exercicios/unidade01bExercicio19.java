//  Calcule o número de multiplicações que o código abaixo realiza:

public class unidade01bExercicio19 {
    public static void main(String[] args) {
        for (int i = n - 7; i >= 1; i--)
            for (int j = n - 7; j >= 1; j--)
                a *= 2;
    }
}

/**
 * O código acima realiza (n - 7) * (n - 7) * 1 = n^2 - 7n -7n + 49 = (n^2 - 14n + 49) * 1 multiplicações
 * 
 * Complexidade: O(n^2), Ω(n^2) e Θ(n^2)
 */
