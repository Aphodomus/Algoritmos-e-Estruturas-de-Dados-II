public class Uppercase {
    public static boolean isUpperCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String palavra = "";
        int count;

        while (palavra.intern() != "FIM") {
            count = 0;
            palavra = MyIO.readLine();
            
            for (int i = 0; i < palavra.length(); i = i + 1) {
                if (isUpperCase(palavra.charAt(i)) == true) {
                    count = count + 1;
                }
            }

            if (palavra.intern() != "FIM") {
                MyIO.println(count);
            }
        }
    }
}
