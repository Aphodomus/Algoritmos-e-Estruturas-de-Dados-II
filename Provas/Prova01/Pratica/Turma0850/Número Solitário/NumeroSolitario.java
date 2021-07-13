public class NumeroSolitario {
    // Verificar se a linha lida e igual a "0"
    public static boolean isFim(String s) {
        return (s.length() == 1 && s.charAt(0) == '0');
    }

    // Tratar dados
    public static void tratarDado(String[] frase, int comeco, int quantidade) {
        //Variaveis
        String fraseTemporaria = "";
        String[] palavras = new String[quantidade];
        int k = 0;
        String tmp = "";
        String solitario = "";
        int contador = 0;

        // Copiar para uma string auxiliar cada frase
        for (int i = comeco; i < comeco + 1; i++) {
            fraseTemporaria = frase[i];
        }

        // Quebrar a frase original em partes, separadas por espaco
        palavras = fraseTemporaria.split(" ");

        //Procurar numeros iguais, e colocar "x" neles
        for (int i = 0; i < quantidade; i++) {
            for (int j = i + 1; j < quantidade; j++) {
                if (palavras[i].compareTo(palavras[j]) == 0) {
                    palavras[i] = "x";
                    palavras[j] = "x";
                    j = quantidade;
                }
            }
        }

        //Printar o numero solitario
        for (int i = 0; i < quantidade; i++) {
            if (palavras[i] != "x") {
                MyIO.println(palavras[i]);
            }
        }
    }

    public static void main(String[] args) {
        //Variaveis
        String[] entrada = new String[10000];
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
            tratarDado(entrada, i + 1, quantidade);
            i = i + 1;
        }
    }
}
