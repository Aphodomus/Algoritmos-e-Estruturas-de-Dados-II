// Leia o nome de um arquivo e uma frase e salve essa frase nesse arquivo

public class unidade00f_exercicio03 {
    public static void main(String[] args) {
        //Abrir o arquivo texto
        Arq.openWrite(MyIO.readString("Digite o nome do arquivo aqui: "));

        String frase = "";

        frase = MyIO.readLine("Digite algo: ");

        Arq.println(frase);

        Arq.close();
    }
}
