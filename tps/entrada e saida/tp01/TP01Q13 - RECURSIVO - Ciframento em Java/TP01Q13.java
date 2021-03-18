public class TP01Q13 {
    // Metodo para verificar se é o fim da entrada
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    // Metodo para aplicar a cifra de cesar
    public static String encrypt(String palavra, int i) {
        char caracter = palavra.charAt(0);
        String resp = "";
        caracter = (char) ((((int) palavra.charAt(i)) + 3));
        resp = resp + caracter;

        if (palavra.length() > 1) {
            resp = resp + encrypt(palavra.substring(1), i);
        }
       
        return resp;
    }

    public static void main(String[] args) {
        MyIO.setCharset("ISO-8859-1");
        String[] entrada = new String[1000];
        int numEntrada = 0;
        int count = 0;

        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

        // Para cada linha de entrada, gerando uma de saida contendo a string criptografada pela cifra de cesar
        for (int i = 0; i < numEntrada; i = i + 1) {
            MyIO.println(encrypt(entrada[i], count));
        }
    }
}
