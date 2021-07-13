import java.util.Random;

public class TP01Q04 {
    // Metodo para verificar se é o fim da entrada
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
    
    // Metodo para trocar o caracter sorteado por outro, caso ele exista na posicao verificada, e retornar a string final.
    public static String swapCharRandom(String original, char caracter1, char caracter2, Random gerador) {
        // Gerar um numero aleatorio e transformar em um caracter
        caracter1 = (char) ('a' + gerador.nextInt(26));
        caracter2 = (char) ('a' + gerador.nextInt(26));
        // Declarar a string onde a string modificada vai ficar;
        String modificada = "";
        
        //Um loop para percorrer toda a string original e verificar se algum caracter dela corresponde a um caracter a ser trocado
        for (int i = 0; i < original.length(); i = i + 1) {
            if (original.charAt(i) == caracter1) {
                modificada = modificada + (char) (caracter2);
            } else {
                modificada = modificada + (char) (original.charAt(i));
            }
        }

        //Retornar a string modificada
        return modificada;
    }


    public static void main(String[] args) {
         // Declarando Variáveis e charset
        MyIO.setCharset("ISO-8859-1");
        char caracter1 = '-';
        char caracter2 = '-';
        
        // Declarando o gerador random
        Random gerador = new Random( ) ;
        gerador.setSeed ( 4 ) ;
        
        String[] entrada = new String[1000];
        int numEntrada = 0;

        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

        // Para cada linha de entrada, gerando uma de saida contendo a string criptografada pela cifra de cesar
        for (int i = 0; i < numEntrada; i = i + 1) {
            // Vai chamar a função, retornar a string modificada ou nao e depois printar
            MyIO.println(swapCharRandom(entrada[i], caracter1, caracter2, gerador));
        }
        
    }
}
