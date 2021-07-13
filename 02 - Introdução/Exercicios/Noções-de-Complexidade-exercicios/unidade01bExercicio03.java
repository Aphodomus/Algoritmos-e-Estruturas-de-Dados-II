// Calcule o número de adições que o código abaixo realiza:

public class unidade01bExercicio03 {
    public static void main(String[] args) {
        if (a + 5 < b + 3 || c + 1 < d + 3) {
            i++;
            ++b;
            a += 3;
        } else {
            j++;
        }
    }
}

/**
 * O número máximo de adições (pior caso) acontece quando a primeira condição do if é falsa e a segunda verdadeira
 * Se for esse o caso, ele vai realizar um total de 4 adições na condição e mais 3 adições dentro da condição verdadeira, totalizando 7
 * Se a primeira for verdadeira, o Java automaticamente não executa a segunda, então ele vai fazer um total de 2 adições na condição e mais 3 dentro da condição verdadeira totalizando 5 adições.
 * Outra opção seria a condição ser falsa em ambos os lados, mas ele teria que fazer 4 somas mais 1 soma do else, totalizando 5.
 * 
 * Complexidade: O(1), Ω(1) e Θ(1)
 */
