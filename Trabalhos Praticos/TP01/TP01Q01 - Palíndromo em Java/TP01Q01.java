public class TP01Q01 {
    public static void main(String[] args) {
        String palavra = "";

        while (palavra.intern() != "FIM") {
            palavra = MyIO.readLine();
            String invertida = new StringBuilder(palavra).reverse().toString();

            if (palavra.intern() != "FIM") {
                if (palavra.intern() == invertida.intern()) {
                    MyIO.println("SIM");
                } else {
                    MyIO.println("NAO");
                }
            }
        }
    }
}
