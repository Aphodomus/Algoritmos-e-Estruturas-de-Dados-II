//  Calcule o número de subtrações que o código abaixo realiza:

public class unidade01bExercicio13 {
    public static void main(String[] args) {
        int i = 1, b = 10;
        while (i > 0) {
            b--;            //1
            i = i >> 1;
        }

        i = 0;

        while (i < 15) {
            b--;            //8 vezes
            i += 2;
        }

    }
}

/**
 * O código acima realiza 9 sutrações no total, sendo 1 no primeiro while e 8 no segundo while
 * 
 * Complexidade: O(1), Ω(1) e Θ(1)
 */
