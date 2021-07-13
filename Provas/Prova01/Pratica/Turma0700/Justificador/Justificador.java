public class Questao01 {
    public static String tratarString(String frase) {
        //Variaveis
        String resp = "";
        String tmp = "";
        String[] palavras = new String[50];

        //Quebrar a frase original em partes, separadas por espaco
        palavras = frase.split(" ");

        //Ordenar pelo tamanho utilizando o metodo de insercao
        for (int i = 1; i < palavras.length; i++) {
            tmp = palavras[i];
            int j = i - 1;
            while ((j >= 0) && (palavras[j].length() < tmp.length())) {
                palavras[j + 1] = palavras[j]; // Deslocamento
                j--;
            }
            palavras[j + 1] = tmp;
        }
        
        //Copiar cada parte do array de string para a frase final
        for (int k = 0; k < palavras.length; k++) {
            resp = resp + palavras[k] + " ";
        }

        return resp;
    }

    public static void main(String[] args) {
        String[] entrada = new String[50];
        int numEntrada = 0;
        int quantidade = 0;
        String resp = "";  

        //Ler a quantidade de casos de teste
        quantidade = MyIO.readInt();

        //Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
            numEntrada++;
        } while (numEntrada != quantidade);

        //Tratar a string e printar a resposta
        for (int i = 0; i < quantidade; i++) {
            resp = tratarString(entrada[i]);
            MyIO.println(resp);
        }
    }
}
