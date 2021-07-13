//  Calcule o número de multiplicações que o código abaixo realiza:

public class unidade01bExercicio18 {
    public static void main(String[] args) {
        int a = 1;
        int n = 12;
        for (int i = n+4; i > 0; i >>= 1) {
            System.out.println("ola");
            a *= 2;
        }
    }
}

/** Realiza n multiplicações no codigo acima
 * 
 *  Complexidade: O(n), Ω(n) e Θ(n)
 */
