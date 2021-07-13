//Leia o nome de dois arquivos e copie o conteúdo do primeiro para o último

public class unidade00f_exercicio05 {
    public static void main(String[] args) {
        //Abrir arquivo
        Arq.openRead(MyIO.readString("Digite o nome de um arquivo para copiar: "));
        String str = "";
        
        //Ler ate acabar o conteudo
        while (Arq.hasNext() == true){
            str += Arq.readLine() + "\n";//Aqui ele lê uma linha inteira, mas pode ser modificado para ler um int, double etc...
        }

        //Fechar arquivo, perguntar o nome do arquivo para salvar e salvar o conteudo dentro dele
        Arq.close();
        Arq.openWrite(MyIO.readString("Digite o nome de um arquivo para salvar: "));
        Arq.print(str);
        Arq.close();
    }
}
