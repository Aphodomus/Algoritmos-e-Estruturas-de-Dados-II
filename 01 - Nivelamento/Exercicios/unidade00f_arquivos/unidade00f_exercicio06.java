// Leia o nome de dois arquivos, abra o primeiro, converta seu conteúdo para letra maiúscula e salve o no segundo

public class unidade00f_exercicio06 {
    public static void main(String[] args) {
        //Abrir arquivo
        Arq.openRead(MyIO.readString("Digite o nome do arquivo para copiar: "));

        //Ler conteudo
        String str = "";
        while (Arq.hasNext() == true){
            str += Arq.readLine() + "\n";
        }

        //Converter para maiusculo
        String strMaiuscula = str.toUpperCase();

        //Fechar primeiro arquivo
        Arq.close();

        Arq.openWrite(MyIO.readString("Digite o nome do arquivo onde quer salvar o conteudo: "));
        Arq.print(strMaiuscula);
        Arq.close();

        //
    }
}
