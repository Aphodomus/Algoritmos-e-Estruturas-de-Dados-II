// Leia o nome de um arquivo e mostre na tela o conteúdo desse arquivo criptografado usando o ciframento de César (k = 3)

public class unidade00f_exercicio08 {
    public static void main(String[] args) {
        //Abrir arquivo
        Arq.openRead(MyIO.readString("Digite o nome do arquivo para abrir: "));

        //Ler conteudo
        String str = "";
        while (Arq.hasNext() == true){
            str += Arq.readLine() + "\n";
        }

        //Fechar arquivo
        Arq.close();

        //Cria um loop que vai passar por cada letra da string e criptografar ela com a cifra de cesar k = 3
        String strCriptografada = "";
        for (int i = 0; i < str.length(); i = i + 1) {
            strCriptografada = strCriptografada + (char) ((((int) str.charAt(i)) + 3));
            if (str.charAt(i) == '\n') {
                strCriptografada = strCriptografada + "\n";
            }
        }

        //Vai mostrar o conteudo criptografado na saida
        MyIO.println("Conteudo do arquivo criptografado:");
        MyIO.println(strCriptografada);

        //Abrir arquivo para gravar
        Arq.openWrite("ConteudoCriptografado.txt");
        Arq.print(strCriptografada);
        Arq.close();
    }
}
