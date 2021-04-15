public class BibliotecaSenhorSeverino {
    // Verificar se a linha lida e igual a "0000"
    public static boolean isFim(String s) {
        return (s.length() == 4 && s.charAt(0) == '0' && s.charAt(1) == '0' && s.charAt(2) == '0' && s.charAt(3) == '0');
    }

    // Tratar dados
    public static void tratarDado(String[] frase, int comeco, int fim) {
        //Variaveis
        String[] palavras = new String[(fim - comeco) + 1];
        int k = 0;
        String tmp = "";

        // Copiar para uma string auxiliar cada frase
        for (int i = comeco; i <= fim; i++) {
            palavras[k] = frase[i];
            k++;
        }

        // Ordenar por meio do insertionSort
        for (int i = 1; i < palavras.length; i++) {
            tmp = palavras[i];
            int j = i - 1;
            while ((j >= 0) && (palavras[j].compareTo(tmp) > 0)) {
                palavras[j + 1] = palavras[j]; // Deslocamento
                j--;
            }
            palavras[j + 1] = tmp;
        }

        // Printar o array de string agora ordenado
        for (int j = 0; j < palavras.length; j++) {
            MyIO.println(palavras[j]);
        }

    }

    public static void main(String[] args) {
        //Variaveis
        String[] entrada = new String[50];
        int numEntrada = 0;
        int quantidade = 0;

        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

        // Fazer o tratamento dos dados de acordo com o pedido pela questao
        for (int i = 0; i < numEntrada; i++) {
            quantidade = Integer.parseInt(entrada[i]);
            tratarDado(entrada, i + 1, i + quantidade);
            i = i + quantidade;
        }
    }
}
