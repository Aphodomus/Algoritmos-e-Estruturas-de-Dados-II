public class TP01Q06 {
    // Metodo para verificar se é o fim da entrada
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static char toUpper(char c) {
        return (c >= 'a' && c <= 'z') ? ((char) (c - 32)) : c;
    }

    public static boolean isNumber(char c) {
        if ((c >= '0' && c <= '9') || (c == '.' || c == ',')) {
            return true;
        }

        return false;
    }

    public static boolean apenasVogais(String palavra) {
        char aux = '-';

        for (int i = 0; i < palavra.length(); i = i + 1) {
            aux = palavra.charAt(i);
            aux = toUpper(aux);
            if (aux != 'A' && aux != 'E' && aux != 'I' && aux != 'O' && aux != 'U') {
                return false;
            }
        }
        return true;
    }

    public static boolean apenasConsoantes(String palavra) {
        char aux = '-';
        
        for (int i = 0; i < palavra.length(); i = i + 1) {
            aux = palavra.charAt(i);
            aux = toUpper(aux);
            if (aux != 'B' && aux != 'C' && aux != 'D' && aux != 'F' && aux != 'G'&& aux != 'J' && aux != 'K' && aux != 'L' && aux != 'M' && aux != 'N' && aux != 'P' && aux != 'Q' && aux != 'R' && aux != 'S' && aux != 'T'&& aux != 'V' && aux != 'W' && aux != 'X' && aux != 'Z') {
                return false;
            }
        }
        return true;
    }

    public static boolean apenasInteiros(String palavra) {
        char aux = '-';

        for (int i = 0; i < palavra.length(); i = i + 1) {
            aux = palavra.charAt(i);
            if (isNumber(aux)) {
                if (aux == '.' || aux == ',') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public static boolean apenasReais(String palavra) {
        char aux = '-';
        int count = 0;

        for (int i = 0; i < palavra.length(); i = i + 1) {
            aux = palavra.charAt(i);
            if (isNumber(aux)) {
                if (aux == '.' || aux == ',') {
                    count = count + 1;
                }
            } else {
                return false;
            }
        }
        
        if (count == 1 || count == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void verificar(String palavra) {
        if (apenasVogais(palavra)) {
            MyIO.print("SIM ");
        } else {
            MyIO.print("NAO ");
        }

        if (apenasConsoantes(palavra)) {
            MyIO.print("SIM ");
        } else {
            MyIO.print("NAO ");
        }

        if (apenasInteiros(palavra)) {
            MyIO.print("SIM ");
        } else {
            MyIO.print("NAO ");
        }

        if (apenasReais(palavra)) {
            MyIO.print("SIM");
        } else {
            MyIO.print("NAO");
        }
    }
    public static void main(String[] args) {
        // Declarando Variáveis e charset
        MyIO.setCharset("ISO-8859-1");
        String[] entrada = new String[1000];
        int numEntrada = 0;

        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

        for (int i = 0; i < numEntrada; i = i + 1) {
            // Vai chamar a função, retornar a string modificada ou nao e depois printar
            verificar(entrada[i]);
            System.out.print("\n");
        }
    }
}
