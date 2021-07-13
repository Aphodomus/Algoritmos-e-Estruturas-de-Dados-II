import java.io.*;
import java.net.*;

public class TP01Q08 {
    // Metodo para verificar se é o fim da entrada
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static String getHtml(String endereco) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;

        try {
            url = new URL(endereco);
            is = url.openStream(); // throws an IOException
            br = new BufferedReader(new InputStreamReader(is, "utf-8"));

            while ((line = br.readLine()) != null) {
                resp += line + "\n";
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            is.close();
        } catch (IOException ioe) {
            // nothing to see here

        }

        return resp;
    }

    public static String procurar(String html, String nome) {
        int a = 0, e = 0, i = 0, o = 0, u = 0, a1 = 0, e1 = 0, i1 = 0, o1 = 0, u1 = 0, a2 = 0, e2 = 0, i2 = 0, o2 = 0, u2 = 0, a3 = 0, o3 = 0, a4 = 0, e4 = 0, i4 = 0, o4 = 0, u4 = 0;
        int br = 0;
        int table = 0;
        int consoante = 0;
        String resp = "";

        for (int x = 0; x < html.length(); x = x + 1) {
            
            if ((int) html.charAt(x) == 97) {
                a = a + 1;
            } else if ((int) html.charAt(x) == 101) {
                e = e + 1;
            } else if ((int) html.charAt(x) == 105) {
                i = i + 1;
            } else if ((int) html.charAt(x) == 111) {
                o = o + 1;
            } else if ((int) html.charAt(x) == 117) {
                u = u + 1;
            } else if ((int) html.charAt(x) == 225) {
                a1 = a1 + 1;
            } else if ((int) html.charAt(x) == 233) {
                e1 = e1 + 1;
            } else if ((int) html.charAt(x) == 237) {
                i1 = i1 + 1;
            } else if ((int) html.charAt(x) == 243) {
                o1 = o1 + 1;
            } else if ((int) html.charAt(x) == 250) {
                u1 = u1 + 1;
            } else if ((int) html.charAt(x) == 224) {
                a2 = a2 + 1;
            } else if ((int) html.charAt(x) == 232) {
                e2 = e2 + 1;
            } else if ((int) html.charAt(x) == 236) {
                i2 = i2 + 1;
            } else if ((int) html.charAt(x) == 242) {
                o2 = o2 + 1;
            } else if ((int) html.charAt(x) == 249) {
                u2 = u2 + 1;
            } else if ((int) html.charAt(x) == 227) {
                a3 = a3 + 1;
            } else if ((int) html.charAt(x) == 245) {
                o3 = o3 + 1;
            } else if ((int) html.charAt(x) == 226) {
                a4 = a4 + 1;
            } else if ((int) html.charAt(x) == 234) {
                e4 = e4 + 1;
            } else if ((int) html.charAt(x) == 238) {
                i4 = i4 + 1;
            } else if ((int) html.charAt(x) == 244) {
                o4 = o4 + 1;
            } else if ((int) html.charAt(x) == 251) {
                u4 = u4 + 1;
            } else if ((html.charAt(x) >= 'a' && html.charAt(x) <= 'z')) {
                consoante = consoante + 1;
            } else if (html.charAt(x) == '<' && html.charAt(x + 1) == 'b' && html.charAt(x + 2) == 'r' && html.charAt(x + 3) == '>') {
                br = br + 1;
                x = x + 3;
            } else if (html.charAt(x) == '<' && html.charAt(x + 1) == 't' && html.charAt(x + 2) == 'a' && html.charAt(x + 3) == 'b' && html.charAt(x + 4) == 'l' && html.charAt(x + 5) == 'e' && html.charAt(x + 6) == '>') {
                table = table + 1;
                x = x + 6;
            }
        }

        resp = ("a(" + a + ") " + "e(" + e + ") " + "i(" + i + ") " + "o(" + o + ") " + "u(" + u + ") " + "á(" + a1 + ") " + "é(" + e1 + ") " + "í(" + i1 + ") " + "ó(" + o1 + ") " + "ú(" + u1 + ") " + "à(" + a2 + ") " + "è(" + e2 + ") " + "ì(" + i2 + ") " + "ò(" + o2 + ") " + "ù(" + u2 + ") " + "ã(" + a3 + ") " + "õ(" + o3 + ") " + "â(" + a4 + ") " + "ê(" + e4 + ") " + "î(" + i4 + ") " + "ô(" + o4 + ") " + "û(" + u4 + ") " + "consoante(" + consoante + ") " + "<br>(" + br + ") " + "<table>(" + table + ") " + nome);
        return resp;
    }

    public static void main(String[] args) {
        MyIO.setCharset("ISO-8859-1");
        String endereco, html, nome;
        String[] entrada = new String[1000];
        int numEntrada = 0;
        String aux = "";

        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM
        
        for (int i = 0; i < numEntrada; i = i + 2) {
            // Vai chamar a função, retornar a string modificada ou nao e depois printar
            nome = entrada[i];
            endereco = entrada[i + 1];
            html = getHtml(endereco);
            aux = procurar(html, nome);
            MyIO.println(aux);
        }
    }
}
