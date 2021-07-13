// Calcule o número de adições que o código abaixo realiza:

public class unidade01bExercicio02 {
    public static void main(String[] args) {
        if (a + 5 < b + 3) {
            i++;
            ++b;
            a += 3;
        } else {
            j++;
        }
    }
}

/**
 * Depende da situação
 * No melhor caso, ele vai realizar 3 operação de adição, sendo duas na condição e uma quando for false
 * No pior caso, ele vai realizar 5 operações de adição, sendo duas na condição e três quando for verdadeiro
 * 
 * Complexidade: O(1), Ω(1) e Θ(1)
 */
