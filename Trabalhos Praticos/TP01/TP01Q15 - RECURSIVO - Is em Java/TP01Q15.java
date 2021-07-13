public class TP01Q15 {
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

    public static boolean isVogal(char c) {
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }

    public static boolean isConsoante(char c) {
        if (c == 'B' || c == 'C' || c == 'D' || c == 'F' || c == 'G' || c == 'J' || c == 'K' || c == 'L' || c == 'M' || c == 'N' || c == 'P' || c == 'Q' || c == 'R' || c == 'S' || c == 'T' || c == 'V' || c == 'W' || c == 'X' || c == 'Z') {
            return true;
        }

        return false;
    }

    public static boolean apenasVogais(String palavra, int i, boolean resp) {
        if(i < palavra.length()) {
            if (isVogal(toUpper(palavra.charAt(i))) == false) {
                return false;
            } else {
                resp = apenasVogais(palavra, ++i, resp);
            }
        }
        
        return resp;
    }

    public static boolean apenasConsoantes(String palavra, int i, boolean resp) {
        if(i < palavra.length()) {
            if (isConsoante(toUpper(palavra.charAt(i))) == false) {
                return false;
            } else {
                resp = apenasConsoantes(palavra, ++i, resp);
            }
        }
        
        return resp;
    }

    public static boolean apenasInteiros(String palavra, int i, boolean resp) {
        if (i < palavra.length()) {
            if (isNumber(palavra.charAt(i)) == false) {
                return false;
            } else {    
                if (palavra.charAt(i) == '.' || palavra.charAt(i) == ',') {
                    return false;
                } else {
                    resp = true;
                    resp = apenasInteiros(palavra, ++i, resp);
                }
            }
        }
        return resp;
    }

    public static int apenasReais(String palavra, int i, int count) {
        if (i < palavra.length()) {
            if (isNumber(palavra.charAt(i)) == false) {
                return -1;
            } else {
                if (palavra.charAt(i) == '.' || palavra.charAt(i) == ',') {
                    count = count + apenasReais(palavra, ++i, count++);
                } else {
                    count = count + apenasReais(palavra, ++i, count);
                }
            }
        }
        
        return count;

    }

    public static void verificar(String palavra) {
        int aux = 0;
        int i = 0;
        boolean resp = true;
        resp = apenasVogais(palavra, i, resp);

        if (resp) {
            MyIO.print("SIM ");
        } else {
            MyIO.print("NAO ");
        }
        
        if (apenasConsoantes(palavra, i, resp)) {
            MyIO.print("SIM ");
        } else {
            MyIO.print("NAO ");
        }
        
        if (apenasInteiros(palavra, i, resp)) {
            MyIO.print("SIM ");
        } else {
            MyIO.print("NAO ");
        }
        
        if (apenasReais(palavra, i, aux) == 1 || apenasReais(palavra, i, aux) == 0) {
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
