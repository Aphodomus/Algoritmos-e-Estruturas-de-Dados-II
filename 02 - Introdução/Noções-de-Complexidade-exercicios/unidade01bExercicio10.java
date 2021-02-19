//   Calcule o número de subtrações que o código abaixo realiza:

public class unidade01bExercicio10 {
    public static void main(String[] args) {
        int a;
        int b;
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                a--;
                b--;
            } else {
                c--;
            }
        }
    }
}

/**
 * O código acima realiza 8 operações de subtração
 * 
 * i = 0, i % 2 == 0 ? true, 2 operação de subtração
 * i = 1, i % 2 == 0 ? false, 1 operação de subtração
 * i = 2, i % 2 == 0 ? true, 2 operação de subtração
 * i = 3, i % 2 == 0 ? false, 1 operação de subtração
 * i = 4, i % 2 == 0 ? true, 2 operação de subtração
 * 
 * Complexidade: O(1), Ω(1) e Θ(1)
 * 
 */
