public class TP01Q052 {
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static boolean isAnd(String expressao, int i) {
        if (expressao.charAt(i) == 'a') {
            if (expressao.charAt(i + 1) == 'n') {
                if (expressao.charAt(i + 2) == 'd') {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isNot(String expressao, int i) {
        if (expressao.charAt(i) == 'n') {
            if (expressao.charAt(i + 1) == 'o') {
                if (expressao.charAt(i + 2) == 't') {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isOr(String expressao, int i) {
        if (expressao.charAt(i) == 'o') {
            if (expressao.charAt(i + 1) == 'r') {
                return true;
            }
        }
        return false;
    }

    public static boolean BooleanValue(int valor) {
        if (valor == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static String MyReplace(String frase, String oldChar, String newChar) {  
        String resp = "";
        //char aux = newChar.charAt(0);
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) != oldChar.charAt(0)) {
                resp = resp + frase.charAt(i);
            } else {
                resp = resp + newChar;
            }
        }
        
        return resp;
    }

    public static int searchCount(String expressao, char value, int tamanho) {
        int quantidade = -1;
        for (int i = tamanho; i < expressao.length(); i = i + 1) {
            if (expressao.charAt(i) != ')') {
                if (expressao.charAt(i) == value){
                    quantidade = quantidade + 1;
                }
            } else {
                return quantidade;
            }
        }
        return quantidade;
    }

    public static int searchPositionInicial(String expressao, char value, int tamanho) {
        int position = -1;
        for (int i = tamanho; i < expressao.length(); i = i + 1) {
            if (expressao.charAt(i) != ')') {
                if (expressao.charAt(i) == value){
                    position = i;
                    return position;
                }
            }
        }
        return position;
    }
    
    public static int searchPositionFinal(String expressao, char value, int tamanho) {
        int position = -1;
        
        for (int i = tamanho; i < expressao.length(); i = i + 1) {
            if (expressao.charAt(i) != '(') {
                if (expressao.charAt(i) == value){
                    position = i;
                    return position;
                }
            }
        }

        return position;
    }

    public static boolean charToBool(char value) {
        if (value == '1') {
            return true;
        } else {
            return false;
        }
    }

    public static String cortarExpressao(String expressao, int posicaoInicio, int posicaoFinal) {
        return expressao.substring(posicaoInicio, posicaoFinal);
    }

    public static boolean CalcularExpressao(String expressao, int quantidade, int index) {
        int[] array = new int[quantidade + 1];
        int value = 0;
        int positionInicial;
        int positionFinal;
        String cortar = "";
        String respString = "";
        String guardarExpressao = "";
        boolean result = true;
        boolean resp = false;
        boolean booleanA = false;
        boolean booleanB = false;
        boolean booleanC = false;

        expressao = MyReplace(expressao, " ", "");

        for (int i = 0; i < quantidade + 1; i = i + 1) {
            array[i] = ((int) expressao.charAt(i)) - 48;
        }

        MyIO.println(expressao);

        int A = ((char) array[1]) + 48;
        int B = ((char) array[2]) + 48;
        int C = ((char) array[3]) + 48;

        String charA = "";
        String charB = "";
        String charC = "";

        charA = charA + (char) (A);
        charB = charB + (char) (B);
        charC = charC + (char) (C);

        expressao = MyReplace(expressao, "A", charA);
        expressao = MyReplace(expressao, "B", charB);
        expressao = MyReplace(expressao, "C", charC);

        MyIO.println(expressao);
        
        for (int i = 0; i < expressao.length(); i = i + 1) {
            if (expressao.charAt(i) == 'a') {
                value = searchCount(expressao, '(', i + 3);
                positionInicial = searchPositionInicial(expressao, '(', i + 3);
                positionFinal = searchPositionFinal(expressao, ')', i + 3);
                cortar = cortarExpressao(expressao, positionInicial, positionFinal);
                if (value == 0) {
                    booleanA = charToBool(expressao.charAt(positionInicial + 1));
                    booleanB = charToBool(expressao.charAt(positionInicial + 3));
                    resp = booleanA && booleanB;
                    //MyIO.println(cortar);
                    respString = respString + String.valueOf(resp);
                    MyIO.println(respString);
                    MyIO.println(positionInicial);
                    MyIO.println(positionFinal);
                    cortar = expressao.substring(positionInicial - 3, positionFinal);
                    guardarExpressao = expressao.replace(cortar, respString);
                    MyIO.println(guardarExpressao);
                }
            }

            if (expressao.charAt(i) == 'n') {
                
            }
            
        }

        //Cuidado
        return result;
    }

    public static void main(String[] args) {
        // Declarando Variáveis e charset
        MyIO.setCharset("ISO-8859-1");
        String[] entrada = new String[1000];
        int numEntrada = 0;
        int quantidade = 0;
        boolean resp = false;
        int index = 0;

        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

        for (int i = 0; i < numEntrada; i = i + 1) {
            // Vai chamar a função, retornar a string modificada ou nao e depois printar
            quantidade = ((int) entrada[i].charAt(0)) - 48;
            resp = CalcularExpressao(entrada[i], quantidade, index);
            if (resp == true) {
                MyIO.println(1);
            } else {
                MyIO.println(0);
            }
        }
    }
}
