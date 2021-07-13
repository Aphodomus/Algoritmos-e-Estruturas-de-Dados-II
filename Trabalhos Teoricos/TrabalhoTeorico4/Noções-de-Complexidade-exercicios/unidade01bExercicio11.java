//  Calcule o número de subtrações que o código abaixo realiza:

public class unidade01bExercicio11 {
    public static void main(String[] args) {
        int a = 10;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                a--;
            }
        }
    }
}

/**
 * O código acima realiza 3*2*1 operações, ou seja, 6 operações de subtração.
 * 
 * Complexidade: O(1), Ω(1) e Θ(1)
 */
