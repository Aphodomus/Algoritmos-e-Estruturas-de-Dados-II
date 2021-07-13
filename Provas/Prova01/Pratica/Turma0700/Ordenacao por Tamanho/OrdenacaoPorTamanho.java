public class Questao02 {
    // Verificar se a linha lida e igual a FIM
    public static boolean isFim(String s) {
        return (s.length() == 1 && s.charAt(0) == '0');
    }

    // Procurar maior palavra
    public static int acharMaior(String[] palavras) {
        int posicao = 0;

        int index = 0;
        int elementLength = palavras[0].length();
        for (int i = 1; i < palavras.length; i++) {
            if (palavras[i].length() > elementLength) {
                index = i;
                elementLength = palavras[i].length();
            }
        }

        return index;
    }

    // Tratar dados
    public static void tratarDado(String[] frase, int comeco, int fim) {
        String[] palavras = new String[(fim - comeco) + 1];
        int k = 0;
        int maior = 0;

        // Copiar para uma string auxiliar cada frase
        for (int i = comeco; i <= fim; i++) {
            palavras[k] = frase[i];
            k++;
        }

        // Retirar espacos desnecessarios
        for (int m = 0; m < palavras.length; m++) {
            palavras[m] = palavras[m].trim().replaceAll(" +", " ");
        }

        maior = acharMaior(palavras);

        MyIO.println("Maior: " + maior);

        for (int j = 0; j < palavras.length; j++) {
            MyIO.println(palavras[j]);
        }

    }

    public static void main(String[] args) {
        String[] entrada = new String[50];
        int numEntrada = 0;
        int quantidade = 0;

        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

        for (int i = 0; i < numEntrada; i++) {
            quantidade = Integer.parseInt(entrada[i]);
            tratarDado(entrada, i + 1, i + quantidade);
            MyIO.println("\n");
            i = i + quantidade;
        }
    }
}
