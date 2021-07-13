//  Calcule o número de subtrações que o código abaixo realiza:

public class unidade01bExercicio12 {
    public static void main(String[] args) {
        int a = 10;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                a--;
            }
        }
    }
}

/**
 * O código acima realiza n*n*1 operações, ou (n^2) * 1
 * 
 * Complexidade: O(n^2), Ω(n^2) e Θ(n^2)
 */
