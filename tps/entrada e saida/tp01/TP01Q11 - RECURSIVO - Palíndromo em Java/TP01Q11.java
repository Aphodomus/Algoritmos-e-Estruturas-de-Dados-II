public class TP01Q11 {

    public static void iniciar(String palavra) {
        palavra = MyIO.readLine();
        String invertida = new StringBuilder(palavra).reverse().toString();
        if (palavra.intern() == "FIM") {
            
        } else {
            if (palavra.intern() == invertida.intern()) {
                MyIO.println("SIM");
            } else {
                MyIO.println("NAO");
            }
            iniciar(palavra);
        }
    }


    public static void main(String[] args) {
        String palavra = "";

        iniciar(palavra);
    }
}
