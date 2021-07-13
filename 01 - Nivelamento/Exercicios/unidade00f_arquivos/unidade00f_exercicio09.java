public class unidade00f_exercicio09 {
    public static void main(String[] args) {
        //Abrir um arquivo
        Arq.openRead(MyIO.readString("Digite o nome do arquivo para ler e descriptografar: "));

        //Ler conteudo
        String str = "";
        while (Arq.hasNext() == true){
            str += Arq.readLine() + "\n";
        }

        //Fechar arquivo
        Arq.close();

        //Cria um loop que vai passar por cada letra da string e criptografar ela com a cifra de cesar k = 3
        String strDescriptografada = "";
        for (int i = 0; i < str.length(); i = i + 1) {
            strDescriptografada = strDescriptografada + (char) ((((int) str.charAt(i)) - 3));
            if (str.charAt(i) == '\n') {
                strDescriptografada = strDescriptografada + "\n";
            }
        }

        //Vai mostrar o conteudo criptografado na saida
        MyIO.println("Conteudo do arquivo descriptografado:");
        MyIO.println(strDescriptografada);

        //Abrir arquivo para gravar
        Arq.openWrite("ConteudoDescriptografado.txt");
        Arq.print(strDescriptografada);
        Arq.close();
    }
}
