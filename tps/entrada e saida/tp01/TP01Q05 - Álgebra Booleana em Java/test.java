public class test {
    public static String MyReplace(String frase, String oldChar, String newChar) {  
        String resp = "";
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) != oldChar.charAt(0)) {
                resp = resp + frase.charAt(i);
            } else {
                resp = resp + newChar;
            }
        }
        
        return resp;
    }
    
    public static void main(String[] args) {
        String nome = "D a n i e l";

        String nova = MyReplace(nome, " ", "");

        MyIO.println(nova);
        MyIO.println(nova.length());
    }
}
