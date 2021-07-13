public class unidade00i_exercicio01 {
    public static void main(String[] args) {
        int[] vetor = new int[5]; //vetor armazena o endereço de memoria da primeira posição do array
        MyIO.println(vetor[0]);

    }
}

/**
 * Pontos importantes:
 * 
 * Na linguagem Java, temos somente a passagem de parâmetros por valor
 * 
 * Logo, quando inserimos uma variável como parâmetro de um método, passamos apenas seu valor
 * 
 * Qualquer alteração do método chamado no conteúdo dessa variável nunca afeta o conteúdo dela no método que chama
 * 
 * Temos duas variáveis distintas , contudo, o valor inicial da do método chamado é o corrente da do método que chama
 * 
 */
